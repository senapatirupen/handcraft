package com.app.handcraft.dto;

public class DeliveryAddressTransformer {
    public com.app.handcraft.web.model.DeliveryAddress transfer(com.app.handcraft.entity.DeliveryAddress fromDeliveryAddress){
        com.app.handcraft.web.model.DeliveryAddress toDeliveryAddress = new com.app.handcraft.web.model.DeliveryAddress();
        toDeliveryAddress.setDeadId(fromDeliveryAddress.getDeadId());
        toDeliveryAddress.setDeId(fromDeliveryAddress.getDeId());
        toDeliveryAddress.setAddressLineOne(fromDeliveryAddress.getAddressLineOne());
        toDeliveryAddress.setAddressLineTwo(fromDeliveryAddress.getAddressLineTwo());
        toDeliveryAddress.setLandmark(fromDeliveryAddress.getLandmark());
        toDeliveryAddress.setCountry(fromDeliveryAddress.getCountry());
        toDeliveryAddress.setState(fromDeliveryAddress.getState());
        toDeliveryAddress.setZipcode(fromDeliveryAddress.getZipcode());
        toDeliveryAddress.setType(fromDeliveryAddress.getType());
        return toDeliveryAddress;
    }

    public com.app.handcraft.entity.DeliveryAddress transfer(com.app.handcraft.web.model.DeliveryAddress fromDeliveryAddress){
        com.app.handcraft.entity.DeliveryAddress toDeliveryAddress = new com.app.handcraft.entity.DeliveryAddress();
        toDeliveryAddress.setDeadId(fromDeliveryAddress.getDeadId());
        toDeliveryAddress.setDeId(fromDeliveryAddress.getDeId());
        toDeliveryAddress.setAddressLineOne(fromDeliveryAddress.getAddressLineOne());
        toDeliveryAddress.setAddressLineTwo(fromDeliveryAddress.getAddressLineTwo());
        toDeliveryAddress.setLandmark(fromDeliveryAddress.getLandmark());
        toDeliveryAddress.setCountry(fromDeliveryAddress.getCountry());
        toDeliveryAddress.setState(fromDeliveryAddress.getState());
        toDeliveryAddress.setZipcode(fromDeliveryAddress.getZipcode());
        toDeliveryAddress.setType(fromDeliveryAddress.getType());
        return toDeliveryAddress;
    }
}
