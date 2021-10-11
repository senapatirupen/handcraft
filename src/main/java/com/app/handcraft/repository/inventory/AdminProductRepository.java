package com.app.handcraft.repository.inventory;

import com.app.handcraft.entity.inventory.AdminProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminProductRepository extends JpaRepository<AdminProduct, Long> {
    public AdminProduct findByName(@Param("name") String name);
}
