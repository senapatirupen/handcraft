package com.app.handcraft.service;

import com.app.handcraft.entity.AuditLog;
import com.app.handcraft.entity.inventory.AdminProduct;
import com.app.handcraft.repository.inventory.AdminProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Date;
import java.util.List;

@Service
public class InventoryServiceImpl implements InventoryService {

    @Autowired
    AdminProductRepository adminProductRepository;

    @Override
    public AdminProduct save(AdminProduct adminProduct) {
        defaultAuditLog(adminProduct);
        adminProductRepository.save(adminProduct);
        return adminProduct;
    }

    @Override
    public void remove(Long id) {
        adminProductRepository.deleteById(id);
    }

    @Override
    public AdminProduct findById(Long id) {
        return adminProductRepository.findById(id).get();
    }

    @Override
    public List<AdminProduct> findAll() {
        return adminProductRepository.findAll();
    }

    @Override
    public AdminProduct findByName(String name) {
        return adminProductRepository.findByName(name);
    }

    private AdminProduct defaultAuditLog(AdminProduct adminProduct) {
        adminProduct.setCreatedBy("system");
        adminProduct.setCreatedDate(new Date());
        adminProduct.setLastModifiedBy("system");
        adminProduct.setLastModifiedDate(new Date());
        adminProduct.setIsActive(true);
        adminProduct.setStatus("good");
        return adminProduct;
    }

    @Override
    public Page<AdminProduct> findPaginated(Pageable pageable) {
        List<AdminProduct> products = findAll();
        int pageSize = pageable.getPageSize();
        int currentPage = pageable.getPageNumber();
        int startItem = currentPage * pageSize;
        List<AdminProduct> list;

        if (products.size() < startItem) {
            list = Collections.emptyList();
        } else {
            int toIndex = Math.min(startItem + pageSize, products.size());
            list = products.subList(startItem, toIndex);
        }

        Page<AdminProduct> productPage
                = new PageImpl<AdminProduct>(list, PageRequest.of(currentPage, pageSize), products.size());

        return productPage;
    }


}
