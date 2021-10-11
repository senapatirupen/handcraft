package com.app.handcraft.dto;

public class ShippingAddressTransformer {
    public com.app.handcraft.web.model.ShippingAddress transfer(com.app.handcraft.entity.ShippingAddress fromShippingAddress){
        com.app.handcraft.web.model.ShippingAddress toShippingAddress = new com.app.handcraft.web.model.ShippingAddress();
        toShippingAddress.setShadId(fromShippingAddress.getShadId());
        toShippingAddress.setShId(fromShippingAddress.getShId());
        toShippingAddress.setAddressLineOne(fromShippingAddress.getAddressLineOne());
        toShippingAddress.setAddressLineTwo(fromShippingAddress.getAddressLineTwo());
        toShippingAddress.setLandmark(fromShippingAddress.getLandmark());
        toShippingAddress.setCountry(fromShippingAddress.getCountry());
        toShippingAddress.setState(fromShippingAddress.getState());
        toShippingAddress.setZipcode(fromShippingAddress.getZipcode());
        toShippingAddress.setType(fromShippingAddress.getType());
        return toShippingAddress;
    }

    public com.app.handcraft.entity.ShippingAddress transfer(com.app.handcraft.web.model.ShippingAddress fromShippingAddress){
        com.app.handcraft.entity.ShippingAddress toShippingAddress = new com.app.handcraft.entity.ShippingAddress();
        toShippingAddress.setShadId(fromShippingAddress.getShadId());
        toShippingAddress.setShId(fromShippingAddress.getShId());
        toShippingAddress.setAddressLineOne(fromShippingAddress.getAddressLineOne());
        toShippingAddress.setAddressLineTwo(fromShippingAddress.getAddressLineTwo());
        toShippingAddress.setLandmark(fromShippingAddress.getLandmark());
        toShippingAddress.setCountry(fromShippingAddress.getCountry());
        toShippingAddress.setState(fromShippingAddress.getState());
        toShippingAddress.setZipcode(fromShippingAddress.getZipcode());
        toShippingAddress.setType(fromShippingAddress.getType());
        return toShippingAddress;
    }
}
