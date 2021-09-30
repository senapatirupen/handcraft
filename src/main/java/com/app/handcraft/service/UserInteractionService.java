package com.app.handcraft.service;

import com.app.handcraft.entity.Address;
import com.app.handcraft.entity.Person;
import com.app.handcraft.entity.UserDetail;
import com.apress.prospringmvc.bookstore.service.AuthenticationException;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

public interface UserInteractionService {
    Address updateAddress(String userName, Address address);

    Boolean removeAddress(String userName, Long adId);

    Collection<Address> allAddresses(String userName);

    UserDetail singIn(UserDetail userDetail);

    UserDetail resetPassword(UserDetail userDetail);

    public UserDetail createUserDetail(UserDetail userDetail);
    public UserDetail findUserDetailByUserName(String userName);
    public UserDetail findUserDetailByPhoneNumber(String phoneNumber);
    public Person findPersonByUserName(String userName);
    public Address createAddress(String userName, Address address);
    public Collection<Address> findPersonAddressesByUserName(String userName);

    @Transactional(readOnly = false)
    UserDetail save(UserDetail account);

    UserDetail login(String username, String password) throws AuthenticationException;

    UserDetail getAccount(String username);
}
