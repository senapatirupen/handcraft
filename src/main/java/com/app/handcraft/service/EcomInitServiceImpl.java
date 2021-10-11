package com.app.handcraft.service;

import com.app.handcraft.entity.Product;
import com.app.handcraft.entity.inventory.AdminProduct;
import com.app.handcraft.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class EcomInitServiceImpl implements EcomInitService {

    @Autowired
    public ProductRepository productRepository;

    @Override
    public void productSave() {
        Product product = Product.builder()
                .name("ball")
                .model("balls")
                .productStatus("good")
                .isStockAvailable(true)
                .build();
        defaultAuditLog(product);
        productRepository.save(product);
    }

    private Product defaultAuditLog(Product product){
        product.setCreatedBy("system");
        product.setCreatedDate(new Date());
        product.setLastModifiedBy("system");
        product.setLastModifiedDate(new Date());
        product.setIsActive(true);
        product.setStatus("good");
        return product;
    }

}
