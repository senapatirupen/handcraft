package com.app.handcraft.service;

import com.app.handcraft.entity.Address;
import com.app.handcraft.entity.Person;
import com.app.handcraft.entity.UserDetail;
import com.app.handcraft.repository.AddressRepository;
import com.app.handcraft.repository.PersonRepository;
import com.app.handcraft.repository.UserDetailRepository;
import com.app.handcraft.util.DateUtil;
import com.apress.prospringmvc.bookstore.domain.Account;
import com.apress.prospringmvc.bookstore.service.AuthenticationException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;

@Slf4j
@Service
public class UserInteractionServiceImpl implements UserInteractionService {

    @Autowired
    PersonRepository personRepository;

    @Autowired
    UserDetailRepository userDetailRepository;

    @Autowired
    AddressRepository addressRepository;

    @Autowired
    DateUtil dateUtil;

    private Optional<UserDetail> userDetailOptional;

    private PersonRepository getPersonRepository() {
        return personRepository;
    }

    private void setPersonRepository(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public UserDetailRepository getUserDetailRepository() {
        return userDetailRepository;
    }

    public void setUserDetailRepository(UserDetailRepository userDetailRepository) {
        this.userDetailRepository = userDetailRepository;
    }

    @Override
    public Person findPersonByUserName(String userName) {
        Person person = personRepository.findByUserName(userName);
        return person;
    }

    @Override
    public Collection<Address> findPersonAddressesByUserName(String userName) {
        Person person = personRepository.findByUserName(userName);
        return person.getAddresses();
    }

    @Override
    public UserDetail findUserDetailByUserName(String userName) {
        UserDetail userDetail = userDetailRepository.findByUserName(userName);
        return userDetail;
    }

    @Override
    public UserDetail findUserDetailByPhoneNumber(String phoneNumber) {
        UserDetail userDetail = userDetailRepository.findByPhoneNumber(phoneNumber);
        return userDetail;
    }

    public UserDetail findUserDetailByEmailId(String emailId) {
        UserDetail userDetail = userDetailRepository.findByEmailId(emailId);
        return userDetail;
    }

    public Optional<UserDetail> isPresentUserDetailByUserName(String userName) {
        userDetailOptional = Optional.of(userDetailRepository.findByUserName(userName));
        return userDetailOptional;
    }

    public Optional<UserDetail> isPresentUserDetailByEmailId(String emailId) {
        userDetailOptional = Optional.of(userDetailRepository.findByEmailId(emailId));
        return userDetailOptional;
    }

    public UserDetail findByUserNameOrEmailId(String userNameEmailId) {
        String emailId = "";
        String userName = "";
        if (userNameEmailId.contains(".com"))
            emailId = userNameEmailId;
        else
            userName = userNameEmailId;
        UserDetail userDetail = userDetailRepository.validateUserNameOrEmailId(userName, emailId);
        return userDetail;
    }

    public UserDetail findByPhoneNumberOrEmailId(String phoneNumberEmailId) {
        String emailId = "";
        String phoneNumber = "";
        if (phoneNumberEmailId.contains(".com"))
            emailId = phoneNumberEmailId;
        else
            phoneNumber = phoneNumberEmailId;
        UserDetail userDetail = userDetailRepository.validatePhoneNumberOrEmailId(phoneNumber, emailId);
        return userDetail;
    }

    @Override
    public Address createAddress(String userName, Address address) {
        Person person = findPersonByUserName(userName);
        Address newAddress = addressRepository.save(address);
        if(CollectionUtils.isEmpty(person.getAddresses())){
            Set<Address> addressSet = new HashSet<Address>();
            addressSet.add(newAddress);
            person.setAddresses(addressSet);
        }
        person.getAddresses().add(newAddress);
        personRepository.save(person);
        log.info("Existing Person >>>>> {}", person.toString());
        log.info("New Address >>>>> {}", newAddress.toString());
        return newAddress;
    }

    @Override
    public Address updateAddress(String userName, Address address) {
        Address existAddress = addressRepository.findById(address.getAdId()).get();
        existAddress.setAddressLineOne(address.getAddressLineOne());
        existAddress.setAddressLineTwo(address.getAddressLineTwo());
        existAddress.setCityVillage(address.getCityVillage());
        existAddress.setCountry(address.getCountry());
        existAddress.setLandmark(address.getLandmark());
        existAddress.setState(address.getState());
        existAddress.setZipcode(address.getZipcode());
        existAddress.setType(address.getType());
        existAddress = addressRepository.save(existAddress);
        log.info("Updated Address >>>>> {}", existAddress.toString());
        return existAddress;
    }

    @Override
    public Boolean removeAddress(String userName, Long adId) {
        Address existAddress = addressRepository.findById(adId).get();
        addressRepository.deleteById(adId);
        log.info("Removed Address >>>>> {}", existAddress.toString());
        return true;
    }

    @Override
    public Collection<Address> allAddresses(String userName) {
        Collection<Address> addresses = personRepository.findByUserName(userName).getAddresses();
        return addresses;
    }

    @Override
    public UserDetail singIn(UserDetail userDetail){
        userDetail = findByPhoneNumberOrEmailId(userDetail.getStatus());
        if(Objects.isNull(userDetail.getUsId()))
            userDetail.setStatus("User Not Found");
        return userDetail;
    }

    @Override
    public UserDetail resetPassword(UserDetail userDetail){
        UserDetail userDetail1 = findByPhoneNumberOrEmailId(userDetail.getStatus());
        if(Objects.isNull(userDetail1.getUsId())) {
            userDetail.setStatus("User Not Found");
            return userDetail;
        }
        else {
            userDetail1.setPassword(userDetail.getPassword());
            userDetailRepository.save(userDetail1);
        }
        return userDetail1;
    }


    @Override
    public UserDetail createUserDetail(UserDetail userDetail) {
        Boolean valid = validateUserDetail(userDetail).containsKey(true);
        UserDetail newUserDetail = null;
        if (!valid) {
            userDetail.setCreatedBy(userDetail.getUserName());
            userDetail.setCreatedDate(new Date());
            userDetail.setLastModifiedBy(userDetail.getUserName());
            userDetail.setLastModifiedDate(new Date());
            userDetail.setIsActive(true);
            userDetail.setStatus("Active");
//            userDetail.setDob(dateUtil.dateToDate(userDetail.getDob()));
            userDetail.setUserName(userDetail.getEmailId());
            newUserDetail = userDetailRepository.save(userDetail);
            Person person = new Person();
            person.setUserDetail(newUserDetail);
            personRepository.save(person);
            log.info("New Person >>>>> {}", person.toString());
            log.info("New User Detail >>>>> {}", newUserDetail.toString());
        } else {
            userDetail.setStatus(validateUserDetail(userDetail).get(true));
            return userDetail;
        }
        return newUserDetail;
    }

    public HashMap<Boolean, String> validateUserDetail(UserDetail userDetail) {
        UserDetail validUserDetail = null;
        HashMap<Boolean, String> userInfo = new HashMap<Boolean, String>();
        Boolean flag = false;
        if (StringUtils.isNotBlank(userDetail.getPhoneNumber())) {
            validUserDetail = findUserDetailByPhoneNumber(userDetail.getPhoneNumber());
            if (!Objects.isNull(validUserDetail) && StringUtils.isNotBlank(validUserDetail.getEmailId())) {
                flag = true;
                userInfo.put(true, "Phone Number Already Exist");
            }
        }
        if (StringUtils.isNotBlank(userDetail.getEmailId())) {
            validUserDetail = userDetailRepository.findByEmailId(userDetail.getEmailId());
            if (!Objects.isNull(validUserDetail) && StringUtils.isNotBlank(validUserDetail.getPhoneNumber())) {
                flag = true;
                userInfo.put(true, "EmailId Already Exist");
            }
        }
        return userInfo;
    }

    @Override
    @Transactional(readOnly = false)
    public UserDetail save(UserDetail account) {
        UserDetail acc = getAccount(account.getUserName());
        if(acc == null) {
            account.setPassword(sha256Hex(account.getPassword() + "{" + account.getUserName() + "}"));
        }
        return userDetailRepository.save(account);
    }

    @Override
    public UserDetail login(String username, String password) throws AuthenticationException {
        var account = userDetailRepository.findByUserName(username);
        if (account != null) {
            var pwd = sha256Hex(password + "{" + username + "}");
            if (!account.getPassword().equalsIgnoreCase(pwd)) {
                throw new AuthenticationException("Wrong username/password combination.", "invalid.password");
            }
        } else {
            throw new AuthenticationException("Wrong username/password combination.", "invalid.username");
        }

        return account;
    }

    @Override
    public UserDetail getAccount(String username) {
        return userDetailRepository.findByUserName(username);
    }

    private String sha256Hex(String text) {
        try {
            var digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(text.getBytes(StandardCharsets.UTF_8));
            return Base64.getEncoder().encodeToString(hash);
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException("Error creating hash.", e);
        }
    }

}
