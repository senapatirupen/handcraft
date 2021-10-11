package com.app.handcraft.service;

import com.app.handcraft.entity.Address;
import com.app.handcraft.entity.Person;
import com.app.handcraft.entity.UserDetail;
import com.apress.prospringmvc.bookstore.service.AuthenticationException;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Set;

public interface UserInteractionService {
    Address findAddress(String username, String id);

    Address updateAddress(String username, Address address);

    Boolean removeAddress(String username, Long adId);

    Set<Address> allAddresses(String username);

    UserDetail singIn(UserDetail userDetail);

    UserDetail resetPassword(UserDetail userDetail);

    public UserDetail createUserDetail(UserDetail userDetail);
    public UserDetail findUserDetailByUserName(String username);

    UserDetail updateUserDetail(UserDetail userDetail);

    public UserDetail findUserDetailByPhoneNumber(String phoneNumber);
    public Person findPersonByUserName(String username);
    public Address createAddress(String username, Address address);
    public Collection<Address> findPersonAddressesByUserName(String username);

    @Transactional(readOnly = false)
    UserDetail save(UserDetail account);

    UserDetail login(String username, String password) throws AuthenticationException;

    UserDetail getAccount(String username);
}
