package com.app.handcraft.dto;

public class ReturnAddressTransformer {
    public com.app.handcraft.web.model.ReturnAddress transfer(com.app.handcraft.entity.ReturnAddress fromReturnAddress){
        com.app.handcraft.web.model.ReturnAddress toReturnAddress = new com.app.handcraft.web.model.ReturnAddress();
        toReturnAddress.setReadId(fromReturnAddress.getReadId());
        toReturnAddress.setReId(fromReturnAddress.getReId());
        toReturnAddress.setAddressLineOne(fromReturnAddress.getAddressLineOne());
        toReturnAddress.setAddressLineTwo(fromReturnAddress.getAddressLineTwo());
        toReturnAddress.setLandmark(fromReturnAddress.getLandmark());
        toReturnAddress.setCountry(fromReturnAddress.getCountry());
        toReturnAddress.setState(fromReturnAddress.getState());
        toReturnAddress.setCityVillage(fromReturnAddress.getCityVillage());
        toReturnAddress.setZipcode(fromReturnAddress.getZipcode());
        toReturnAddress.setType(fromReturnAddress.getType());
        return toReturnAddress;
    }

    public com.app.handcraft.entity.ReturnAddress transfer(com.app.handcraft.web.model.ReturnAddress fromReturnAddress){
        com.app.handcraft.entity.ReturnAddress toReturnAddress = new com.app.handcraft.entity.ReturnAddress();
        toReturnAddress.setReadId(fromReturnAddress.getReadId());
        toReturnAddress.setReId(fromReturnAddress.getReId());
        toReturnAddress.setAddressLineOne(fromReturnAddress.getAddressLineOne());
        toReturnAddress.setAddressLineTwo(fromReturnAddress.getAddressLineTwo());
        toReturnAddress.setLandmark(fromReturnAddress.getLandmark());
        toReturnAddress.setCountry(fromReturnAddress.getCountry());
        toReturnAddress.setState(fromReturnAddress.getState());
        toReturnAddress.setCityVillage(fromReturnAddress.getCityVillage());
        toReturnAddress.setZipcode(fromReturnAddress.getZipcode());
        toReturnAddress.setType(fromReturnAddress.getType());
        return toReturnAddress;
    }
}
