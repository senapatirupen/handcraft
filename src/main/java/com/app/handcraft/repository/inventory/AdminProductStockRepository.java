package com.app.handcraft.repository.inventory;

import com.app.handcraft.entity.inventory.AdminProductSpecification;
import com.app.handcraft.entity.inventory.AdminProductStock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminProductStockRepository extends JpaRepository<AdminProductStock, Long> {
}
