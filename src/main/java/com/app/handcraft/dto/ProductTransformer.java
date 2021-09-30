package com.app.handcraft.dto;

import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public class ProductTransformer {
    public com.app.handcraft.web.model.Product transfer(com.app.handcraft.entity.Product fromProduct) {
        com.app.handcraft.web.model.Product toProduct = new com.app.handcraft.web.model.Product();
        toProduct.setPrId(fromProduct.getPrId());
        toProduct.setOdId(fromProduct.getOdId());
        toProduct.setCaId(fromProduct.getCaId());
        toProduct.setName(fromProduct.getName());
        toProduct.setModel(fromProduct.getModel());
        toProduct.setProductStatus(fromProduct.getProductStatus());
//        toProduct.setFeedback(fromProduct.getFeedback());
        toProduct.setIsStockAvailable(fromProduct.getIsStockAvailable());
        return toProduct;
    }

    public com.app.handcraft.entity.Product transfer(com.app.handcraft.web.model.Product fromProduct) {
        com.app.handcraft.entity.Product toProduct = new com.app.handcraft.entity.Product();
        toProduct.setPrId(fromProduct.getPrId());
        toProduct.setOdId(fromProduct.getOdId());
        toProduct.setCaId(fromProduct.getCaId());
        toProduct.setName(fromProduct.getName());
        toProduct.setModel(fromProduct.getModel());
        toProduct.setProductStatus(fromProduct.getProductStatus());
//        toProduct.setFeedback(fromProduct.getFeedback());
        toProduct.setIsStockAvailable(fromProduct.getIsStockAvailable());
        return toProduct;
    }

    public Collection<com.app.handcraft.web.model.Product> transfer(Collection<com.app.handcraft.entity.Product> fromProducts) {
        Collection<com.app.handcraft.web.model.Product> toProducts = null;
//        if (!Collections.isEmpty(fromProducts)) {
//            for (com.app.handcraft.entity.Product product : fromProducts) {
//                toProducts.add(transfer(product));
//            }
//        }
        return toProducts;
    }

//    public Collection<com.app.handcraft.entity.Product> transfer(Collection<com.app.handcraft.web.model.Product> fromProducts) {
//        Collection<com.app.handcraft.entity.Product> toProducts = null;
//        if (!Collections.isEmpty(fromProducts)) {
//            for (com.app.handcraft.web.model.Product product : fromProducts) {
//                toProducts.add(transfer(product));
//            }
//        }
//        return toProducts;
//    }
}
