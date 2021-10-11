package com.app.handcraft.repository.inventory;

import com.app.handcraft.entity.inventory.AdminProductFilter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminProductFilterRepository extends JpaRepository<AdminProductFilter, Long> {
}
