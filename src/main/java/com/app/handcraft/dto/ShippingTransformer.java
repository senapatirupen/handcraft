package com.app.handcraft.dto;

public class ShippingTransformer {
    public com.app.handcraft.web.model.Shipping transfer(com.app.handcraft.entity.Shipping fromShipping){
        com.app.handcraft.web.model.Shipping toShipping = new com.app.handcraft.web.model.Shipping();
        toShipping.setShId(fromShipping.getShId());
        toShipping.setPrIds(fromShipping.getPrIds());
        toShipping.setOdId(fromShipping.getOdId());
        toShipping.setShippingStatus(fromShipping.getShippingStatus());
        toShipping.setProductHealthStatus(fromShipping.getProductHealthStatus());
        toShipping.setPackagingCharge(fromShipping.getPackagingCharge());
        toShipping.setStartDate(fromShipping.getStartDate());
        toShipping.setEndDate(fromShipping.getEndDate());
        toShipping.setExpectedDate(fromShipping.getExpectedDate());
        toShipping.setCourierPerson(fromShipping.getCourierPerson());
//        toShipping.setShippingAddress(fromShipping.getShippingAddress());
//        toShipping.setDelivery(fromShipping.getDelivery());
        return toShipping;
    }

    public com.app.handcraft.entity.Shipping transfer(com.app.handcraft.web.model.Shipping fromShipping){
        com.app.handcraft.entity.Shipping toShipping = new com.app.handcraft.entity.Shipping();
        toShipping.setShId(fromShipping.getShId());
        toShipping.setPrIds(fromShipping.getPrIds());
        toShipping.setOdId(fromShipping.getOdId());
        toShipping.setShippingStatus(fromShipping.getShippingStatus());
        toShipping.setProductHealthStatus(fromShipping.getProductHealthStatus());
        toShipping.setPackagingCharge(fromShipping.getPackagingCharge());
        toShipping.setStartDate(fromShipping.getStartDate());
        toShipping.setEndDate(fromShipping.getEndDate());
        toShipping.setExpectedDate(fromShipping.getExpectedDate());
        toShipping.setCourierPerson(fromShipping.getCourierPerson());
//        toShipping.setShippingAddress(fromShipping.getShippingAddress());
//        toShipping.setDelivery(fromShipping.getDelivery());
        return toShipping;
    }
}
