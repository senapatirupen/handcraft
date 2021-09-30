package com.app.handcraft.dto;

public class ReceiptTransformer {
    public com.app.handcraft.web.model.Receipt transfer(com.app.handcraft.entity.Receipt fromReceipt){
        com.app.handcraft.web.model.Receipt toReceipt = new com.app.handcraft.web.model.Receipt();
        return toReceipt;
    }

    public com.app.handcraft.entity.Receipt transfer(com.app.handcraft.web.model.Receipt fromReceipt){
        com.app.handcraft.entity.Receipt toReceipt = new com.app.handcraft.entity.Receipt();
        return toReceipt;
    }
}
