package com.app.handcraft.repository.inventory;

import com.app.handcraft.entity.inventory.AdminProductPrice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminProductPriceRepository extends JpaRepository<AdminProductPrice, Long> {
}
