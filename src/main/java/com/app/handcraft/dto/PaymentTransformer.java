package com.app.handcraft.dto;

public class PaymentTransformer {
    public com.app.handcraft.web.model.Payment transfer(com.app.handcraft.entity.Payment fromPayment){
        com.app.handcraft.web.model.Payment toPayment = new com.app.handcraft.web.model.Payment();
        toPayment.setPaId(fromPayment.getPaId());
        toPayment.setName(fromPayment.getName());
        toPayment.setPrice(fromPayment.getPrice());
        toPayment.setOfferPercentage(fromPayment.getOfferPercentage());
        toPayment.setPaymentStatus(fromPayment.getPaymentStatus());
        toPayment.setType(fromPayment.getType());
        return toPayment;
    }

    public com.app.handcraft.entity.Payment transfer(com.app.handcraft.web.model.Payment fromPayment){
        com.app.handcraft.entity.Payment toPayment = new com.app.handcraft.entity.Payment();
        toPayment.setPaId(fromPayment.getPaId());
        toPayment.setName(fromPayment.getName());
        toPayment.setPrice(fromPayment.getPrice());
        toPayment.setOfferPercentage(fromPayment.getOfferPercentage());
        toPayment.setPaymentStatus(fromPayment.getPaymentStatus());
        toPayment.setType(fromPayment.getType());
        return toPayment;
    }
}
