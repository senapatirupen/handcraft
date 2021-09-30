package com.app.handcraft.dto;

public class InvoiceTransformer {
    public com.app.handcraft.web.model.Invoice transfer(com.app.handcraft.entity.Invoice fromInvoice){
        com.app.handcraft.web.model.Invoice toInvoice = new com.app.handcraft.web.model.Invoice();
        toInvoice.setInId(fromInvoice.getInId());
        toInvoice.setOdId(fromInvoice.getOdId());
        toInvoice.setShId(fromInvoice.getShId());
        toInvoice.setOrderStartDate(fromInvoice.getOrderStartDate());
        toInvoice.setInvoiceNumber(fromInvoice.getInvoiceNumber());
        toInvoice.setStartDate(fromInvoice.getStartDate());
        toInvoice.setPrId(fromInvoice.getPrId());
        toInvoice.setProductName(fromInvoice.getProductName());
        toInvoice.setProductDetail(fromInvoice.getProductDetail());
        toInvoice.setQty(fromInvoice.getQty());
        toInvoice.setCommunicationAddress(fromInvoice.getCommunicationAddress());
        toInvoice.setGrossAmount(fromInvoice.getGrossAmount());
        toInvoice.setDiscount(fromInvoice.getDiscount());
        toInvoice.setTaxableAmount(fromInvoice.getTaxableAmount());
        toInvoice.setCgst(fromInvoice.getCgst());
        toInvoice.setSgst(fromInvoice.getSgst());
        toInvoice.setTotalAmount(fromInvoice.getTotalAmount());
        toInvoice.setGrandTotal(fromInvoice.getGrandTotal());
        toInvoice.setAuthorizedSignature(fromInvoice.getAuthorizedSignature());
        toInvoice.setCin(fromInvoice.getCin());
        toInvoice.setPan(fromInvoice.getPan());
        toInvoice.setGstin(fromInvoice.getGstin());
        toInvoice.setPeId(fromInvoice.getPeId());
        toInvoice.setCustomerName(fromInvoice.getCustomerName());
        toInvoice.setCustomerDetail(fromInvoice.getCustomerDetail());
        toInvoice.setShipFromAddress(fromInvoice.getShipFromAddress());
        toInvoice.setShipToAddress(fromInvoice.getShipToAddress());
        return toInvoice;
    }

    public com.app.handcraft.entity.Invoice transfer(com.app.handcraft.web.model.Invoice fromInvoice){
        com.app.handcraft.entity.Invoice toInvoice = new com.app.handcraft.entity.Invoice();
        toInvoice.setInId(fromInvoice.getInId());
        toInvoice.setOdId(fromInvoice.getOdId());
        toInvoice.setShId(fromInvoice.getShId());
        toInvoice.setOrderStartDate(fromInvoice.getOrderStartDate());
        toInvoice.setInvoiceNumber(fromInvoice.getInvoiceNumber());
        toInvoice.setStartDate(fromInvoice.getStartDate());
        toInvoice.setPrId(fromInvoice.getPrId());
        toInvoice.setProductName(fromInvoice.getProductName());
        toInvoice.setProductDetail(fromInvoice.getProductDetail());
        toInvoice.setQty(fromInvoice.getQty());
        toInvoice.setCommunicationAddress(fromInvoice.getCommunicationAddress());
        toInvoice.setGrossAmount(fromInvoice.getGrossAmount());
        toInvoice.setDiscount(fromInvoice.getDiscount());
        toInvoice.setTaxableAmount(fromInvoice.getTaxableAmount());
        toInvoice.setCgst(fromInvoice.getCgst());
        toInvoice.setSgst(fromInvoice.getSgst());
        toInvoice.setTotalAmount(fromInvoice.getTotalAmount());
        toInvoice.setGrandTotal(fromInvoice.getGrandTotal());
        toInvoice.setAuthorizedSignature(fromInvoice.getAuthorizedSignature());
        toInvoice.setCin(fromInvoice.getCin());
        toInvoice.setPan(fromInvoice.getPan());
        toInvoice.setGstin(fromInvoice.getGstin());
        toInvoice.setPeId(fromInvoice.getPeId());
        toInvoice.setCustomerName(fromInvoice.getCustomerName());
        toInvoice.setCustomerDetail(fromInvoice.getCustomerDetail());
        toInvoice.setShipFromAddress(fromInvoice.getShipFromAddress());
        toInvoice.setShipToAddress(fromInvoice.getShipToAddress());
        return toInvoice;
    }
}
