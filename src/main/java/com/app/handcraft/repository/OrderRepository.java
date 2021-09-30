package com.app.handcraft.repository;

import com.app.handcraft.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface OrderRepository extends JpaRepository<Order, Long> {

    @Query("SELECT o FROM Order o WHERE o.peId = :peId AND o.odId = :odId")
    Order findOrderByPersonId(@Param("peId") Long peId, @Param("odId") Long odId);
}
