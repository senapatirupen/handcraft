package com.app.handcraft.repository;

import com.app.handcraft.entity.Address;
import com.app.handcraft.entity.Cart;
import com.app.handcraft.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Collection;

public interface PersonRepository extends JpaRepository<Person, Long> {
    @Query("SELECT p FROM Person p WHERE p.userDetail.userName = :userName")
    Person findByUserName(@Param("userName") String userName);

    @Query("SELECT p.cart FROM Person p WHERE p.userDetail.userName = :userName")
    Cart findCartByUserName(@Param("userName") String userName);

    @Query("SELECT p.addresses FROM Person p WHERE p.userDetail.userName = :userName")
    Collection<Address> findAddressesByUserName(@Param("userName") String userName);

    @Query("SELECT p.addresses FROM Person p WHERE p.peId = :peId")
    Collection<Address> findAddressesByPersonId(@Param("peId") Long peId);
}
