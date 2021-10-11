package com.app.handcraft.service;

import com.app.handcraft.entity.inventory.AdminProduct;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface InventoryService {
    AdminProduct save(AdminProduct adminProduct);

    void remove(Long id);

    AdminProduct findById(Long id);

    List<AdminProduct> findAll();

    AdminProduct findByName(String name);

    Page<AdminProduct> findPaginated(Pageable pageable);
}
