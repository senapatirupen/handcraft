package com.app.handcraft.dto;

public class OrderTransformer {
    public com.app.handcraft.web.model.Order transfer(com.app.handcraft.entity.Order fromOrder){
        com.app.handcraft.web.model.Order toOrder = new com.app.handcraft.web.model.Order();
        toOrder.setOdId(fromOrder.getOdId());
        toOrder.setPeId(fromOrder.getPeId());
        toOrder.setOrderStatus(fromOrder.getOrderStatus());
        toOrder.setIsDelivered(fromOrder.getIsDelivered());
//        toOrder.setProducts(fromOrder.getProducts());
        toOrder.setStartDate(fromOrder.getStartDate());
        toOrder.setEndDate(fromOrder.getEndDate());
        toOrder.setExpectedDate(fromOrder.getExpectedDate());
//        toOrder.setShippings(fromOrder.getShippings());
//        toOrder.setReturns(fromOrder.getReturns());
//        toOrder.setPayment(fromOrder.getPayment());
        return toOrder;
    }

    public com.app.handcraft.entity.Order transfer(com.app.handcraft.web.model.Order fromOrder){
        com.app.handcraft.entity.Order toOrder = new com.app.handcraft.entity.Order();
        toOrder.setOdId(fromOrder.getOdId());
        toOrder.setPeId(fromOrder.getPeId());
        toOrder.setOrderStatus(fromOrder.getOrderStatus());
        toOrder.setIsDelivered(fromOrder.getIsDelivered());
//        toOrder.setProducts(fromOrder.getProducts());
        toOrder.setStartDate(fromOrder.getStartDate());
        toOrder.setEndDate(fromOrder.getEndDate());
        toOrder.setExpectedDate(fromOrder.getExpectedDate());
//        toOrder.setShippings(fromOrder.getShippings());
//        toOrder.setReturns(fromOrder.getReturns());
//        toOrder.setPayment(fromOrder.getPayment());
        return toOrder;
    }
}
