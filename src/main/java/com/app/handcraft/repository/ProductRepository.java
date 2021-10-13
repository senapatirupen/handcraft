package com.app.handcraft.repository;

import com.app.handcraft.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.Set;

public interface ProductRepository extends JpaRepository<Product, Long> {
    public Product findByName(String name);
    Optional<Set<Product>> findByNameIn(Set<String> names);
}
