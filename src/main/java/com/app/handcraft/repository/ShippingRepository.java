package com.app.handcraft.repository;

import com.app.handcraft.entity.Shipping;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShippingRepository extends JpaRepository<Shipping, Long> {

    Shipping findByOdId(Long odId);

}
