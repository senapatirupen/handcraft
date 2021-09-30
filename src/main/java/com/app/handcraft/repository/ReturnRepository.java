package com.app.handcraft.repository;

import com.app.handcraft.entity.ReturnProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReturnRepository extends JpaRepository<ReturnProduct, Long> {
}
