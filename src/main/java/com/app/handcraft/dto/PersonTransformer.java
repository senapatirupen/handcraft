package com.app.handcraft.dto;

public class PersonTransformer {
    public com.app.handcraft.web.model.Person transfer(com.app.handcraft.entity.Person fromPerson){
        com.app.handcraft.web.model.Person toPerson = new com.app.handcraft.web.model.Person();
        toPerson.setPeId(fromPerson.getPeId());
        toPerson.setUserDetail(fromPerson.getUserDetail());
//        toPerson.setCart(fromPerson.getCart());
//        toPerson.setProducts(fromPerson.getProducts());
//        toPerson.setAddresses(fromPerson.getAddresses());
        return toPerson;
    }

    public com.app.handcraft.entity.Person transfer(com.app.handcraft.web.model.Person fromPerson){
        com.app.handcraft.entity.Person toPerson = new com.app.handcraft.entity.Person();
        toPerson.setPeId(fromPerson.getPeId());
        toPerson.setUserDetail(fromPerson.getUserDetail());
//        toPerson.setCart(fromPerson.getCart());
//        toPerson.setProducts(fromPerson.getProducts());
//        toPerson.setAddresses(fromPerson.getAddresses());
        return toPerson;
    }
}
