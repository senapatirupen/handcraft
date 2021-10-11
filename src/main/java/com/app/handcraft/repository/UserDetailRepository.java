package com.app.handcraft.repository;

import com.app.handcraft.entity.UserDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserDetailRepository extends JpaRepository<UserDetail, Long> {
    UserDetail findByUsername(String username);
    UserDetail findByEmailId(String emailId);
    UserDetail findByPhoneNumber(String phoneNumber);


    @Query("SELECT u FROM UserDetail u WHERE u.username = :username OR u.emailId = :emailId")
    UserDetail validateUserNameOrEmailId(@Param("username") String username, @Param("emailId") String emailId);

    @Query("SELECT u FROM UserDetail u WHERE u.phoneNumber = :phoneNumber OR u.emailId = :emailId")
    UserDetail validatePhoneNumberOrEmailId(@Param("phoneNumber") String phoneNumber, @Param("emailId") String emailId);
}
