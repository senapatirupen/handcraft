package com.app.handcraft.dto;

public class DeliveryTransformer {
    public com.app.handcraft.web.model.Delivery transfer(com.app.handcraft.entity.Delivery fromDelivery){
        com.app.handcraft.web.model.Delivery toDelivery = new com.app.handcraft.web.model.Delivery();
        toDelivery.setDeId(fromDelivery.getDeId());
        toDelivery.setPrIds(fromDelivery.getPrIds());
        toDelivery.setShId(fromDelivery.getShId());
        toDelivery.setDeliveryStatus(fromDelivery.getDeliveryStatus());
        toDelivery.setProductHealthStatus(fromDelivery.getProductHealthStatus());
        toDelivery.setPackagingStatus(fromDelivery.getPackagingStatus());
        toDelivery.setStartDate(fromDelivery.getStartDate());
        toDelivery.setEndDate(fromDelivery.getEndDate());
        toDelivery.setExpectedDate(fromDelivery.getExpectedDate());
//        toDelivery.setDeliveryAddress(fromDelivery.getDeliveryAddress());
        return toDelivery;
    }

    public com.app.handcraft.entity.Delivery transfer(com.app.handcraft.web.model.Delivery fromDelivery){
        com.app.handcraft.entity.Delivery toDelivery = new com.app.handcraft.entity.Delivery();
        toDelivery.setDeId(fromDelivery.getDeId());
        toDelivery.setPrIds(fromDelivery.getPrIds());
        toDelivery.setShId(fromDelivery.getShId());
        toDelivery.setDeliveryStatus(fromDelivery.getDeliveryStatus());
        toDelivery.setProductHealthStatus(fromDelivery.getProductHealthStatus());
        toDelivery.setPackagingStatus(fromDelivery.getPackagingStatus());
        toDelivery.setStartDate(fromDelivery.getStartDate());
        toDelivery.setEndDate(fromDelivery.getEndDate());
        toDelivery.setExpectedDate(fromDelivery.getExpectedDate());
//        toDelivery.setDeliveryAddress(fromDelivery.getDeliveryAddress());
        return toDelivery;
    }
}
