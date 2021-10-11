package com.app.handcraft.repository.inventory;

import com.app.handcraft.entity.inventory.AdminProduct;
import com.app.handcraft.entity.inventory.AdminProductSpecification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminProductSpecificationRepository extends JpaRepository<AdminProductSpecification, Long> {
}
