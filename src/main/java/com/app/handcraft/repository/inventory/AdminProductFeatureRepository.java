package com.app.handcraft.repository.inventory;

import com.app.handcraft.entity.inventory.AdminProduct;
import com.app.handcraft.entity.inventory.AdminProductFeature;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminProductFeatureRepository extends JpaRepository<AdminProductFeature, Long> {
}
