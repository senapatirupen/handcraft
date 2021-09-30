package com.app.handcraft.dto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CartTransformer {
    @Autowired
    ProductTransformer productTransformer;
    public com.app.handcraft.web.model.Cart transfer(com.app.handcraft.entity.Cart fromCart){
        com.app.handcraft.web.model.Cart toCart = new com.app.handcraft.web.model.Cart();
        toCart.setCaId(fromCart.getCaId());
        toCart.setCartStatus(fromCart.getCartStatus());
        toCart.setPeId(fromCart.getPeId());
        toCart.setProducts(productTransformer.transfer(fromCart.getProducts()));
        return toCart;
    }

    public com.app.handcraft.entity.Cart transfer(com.app.handcraft.web.model.Cart fromCart){
        com.app.handcraft.entity.Cart toCart = new com.app.handcraft.entity.Cart();
        toCart.setCaId(fromCart.getCaId());
        toCart.setCartStatus(fromCart.getCartStatus());
        toCart.setPeId(fromCart.getPeId());
//        toCart.setProducts(fromCart.getProducts());
        return toCart;
    }

}
