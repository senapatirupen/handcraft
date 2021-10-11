package com.app.handcraft.dto;

public class AddressTransformer {
    public com.app.handcraft.web.model.Address transfer(com.app.handcraft.entity.Address fromAddress){
        com.app.handcraft.web.model.Address toAddress = new com.app.handcraft.web.model.Address();
        toAddress.setAdId(fromAddress.getAdId());
        toAddress.setPeId(fromAddress.getPeId());
        toAddress.setAddressLineOne(fromAddress.getAddressLineOne());
        toAddress.setAddressLineTwo(fromAddress.getAddressLineTwo());
        toAddress.setLandmark(fromAddress.getLandmark());
        toAddress.setCountry(fromAddress.getCountry());
        toAddress.setState(fromAddress.getState());
        toAddress.setZipcode(fromAddress.getZipcode());
        toAddress.setType(fromAddress.getType());
        return toAddress;
    }

    public com.app.handcraft.entity.Address transfer(com.app.handcraft.web.model.Address fromAddress){
        com.app.handcraft.entity.Address toAddress = new com.app.handcraft.entity.Address();
        toAddress.setAdId(fromAddress.getAdId());
        toAddress.setPeId(fromAddress.getPeId());
        toAddress.setAddressLineOne(fromAddress.getAddressLineOne());
        toAddress.setAddressLineTwo(fromAddress.getAddressLineTwo());
        toAddress.setLandmark(fromAddress.getLandmark());
        toAddress.setCountry(fromAddress.getCountry());
        toAddress.setState(fromAddress.getState());
        toAddress.setZipcode(fromAddress.getZipcode());
        toAddress.setType(fromAddress.getType());
        return toAddress;
    }
}
