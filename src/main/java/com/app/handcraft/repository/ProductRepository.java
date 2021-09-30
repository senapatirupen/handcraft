package com.app.handcraft.repository;

import com.app.handcraft.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
    public Product findByName(String name);
}
