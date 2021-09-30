package com.app.handcraft.dto;

public class WishListTransformer {
    public com.app.handcraft.web.model.WishList transfer(com.app.handcraft.entity.WishList fromWishList){
        com.app.handcraft.web.model.WishList toWishList = new com.app.handcraft.web.model.WishList();
        toWishList.setWiId(fromWishList.getWiId());
        toWishList.setWishListStatus(fromWishList.getWishListStatus());
//        toWishList.setProducts(fromWishList.getProducts());
        return toWishList;
    }

    public com.app.handcraft.entity.WishList transfer(com.app.handcraft.web.model.WishList fromWishList){
        com.app.handcraft.entity.WishList toWishList = new com.app.handcraft.entity.WishList();
        toWishList.setWiId(fromWishList.getWiId());
        toWishList.setWishListStatus(fromWishList.getWishListStatus());
//        toWishList.setProducts(fromWishList.getProducts());
        return toWishList;
    }
}
