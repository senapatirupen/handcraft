package com.app.handcraft.repository.inventory;

import com.app.handcraft.entity.inventory.AdminProductDescription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminProductDescriptionRepository extends JpaRepository<AdminProductDescription, Long> {
}
