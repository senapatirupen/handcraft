package com.app.handcraft.repository;

import com.app.handcraft.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Collection;
import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order, Long> {

    @Query("SELECT o FROM Order o WHERE o.peId = :peId AND o.odId = :odId")
    Order findOrderByPersonId(@Param("peId") Long peId, @Param("odId") Long odId);

    @Query("SELECT o FROM Order o WHERE o.peId = :peId AND o.status = :status")
    Optional<Order> findOrderByPersonIdAndStatus(@Param("peId") Long peId, @Param("status") String status);

    @Query("SELECT o FROM Order o WHERE o.peId = :peId AND o.status = :status")
    Collection<Order> findOrdersByPersonIdAndStatus(@Param("peId") Long peId, @Param("status") String status);
}
