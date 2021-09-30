package com.app.handcraft.util;

import com.app.handcraft.entity.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.lang.reflect.Field;

public class DtoGenerator {

    public static void main(String[] args) {
//        new DtoGenerator().printCustomizeSetterAndGetterToSetValue("com.app.handcraft.entity.Vote",
//                "fromVote", "com.app.handcraft.web.model.Vote",
//                "toVote");
//        new DtoGenerator().printCustomizeSetterAndGetterToSetValue("com.app.handcraft.web.model.Vote",
//                "fromVote", "com.app.handcraft.entity.Vote",
//                "toVote");

//        new DtoGenerator().printClassStructureFromC1ToC2(packageName+"AuditLog");


//        new DtoGenerator().forListOfClasses(new DtoGenerator().getFromClassNames("com.app.handcraft.entity."));

        new DtoGenerator().convertPojoToJson();
    }

    public void convertPojoToJson() {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            System.out.println(objectMapper.writeValueAsString(new Cart()));
        } catch (JsonProcessingException e) {
            System.out.println(" Error on conversion " + e.getMessage());
        }
    }

    public void forListOfClasses(String[] classNames){
        for(String className: classNames){
            new DtoGenerator().printClassStructureFromC1ToC2(className);
        }
    }

    public void printCustomizeSetterAndGetterToSetValue(String fromClass, String fromClassRefName, String toClass, String toClassRefName) {
        try {
            StringBuffer sb = new StringBuffer();
            Class<?> c2 = Class.forName(toClass);
            Field[] toFields = c2.getDeclaredFields();
            Class<?> c1 = Class.forName(fromClass);
            Field[] fromFields = c1.getDeclaredFields();
            int i = 0;
            sb.append("public " + c2.getName() + " transfer" + "(" + c1.getName() + " from" + c1.getName().substring(c1.getName().lastIndexOf(".") + 1, c1.getName().length()) + "){");
            sb.append("\n");
            sb.append(c2.getName() + " to" + c2.getName().substring(c2.getName().lastIndexOf(".") + 1, c2.getName().length()) + " = new " + c2.getName()+"();");
            sb.append("\n");
            for (Field f : toFields) {
                sb.append(toClassRefName + ".set" + f.getName().substring(0, 1).toUpperCase()
                        + f.getName().substring(1, f.getName().length()) + "(" + fromClassRefName
                        + ".get" + fromFields[i].getName().substring(0, 1).toUpperCase()
                        + fromFields[i].getName().substring(1, fromFields[i].getName().length()) +
                        "());");
                sb.append("\n");
                i++;
            }
            sb.append("return "+"to" + c2.getName().substring(c2.getName().lastIndexOf(".") + 1, c2.getName().length())+";");
            sb.append("\n");
            sb.append("}");
            System.out.println(sb);
        } catch (ClassNotFoundException e) {
            System.out.println(" Class not found from the location " + e.getMessage());
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(" No of fields miss match from both classes " + e.getMessage());
        }
    }

    public void printClassStructureFromC1ToC2(String fromClass) {
        try {
            StringBuffer sb = new StringBuffer();
            Class<?> c1 = Class.forName(fromClass);
            Field[] fromFields = c1.getDeclaredFields();
            sb.append(c1.getName());
            sb.append("\n");
            for (Field f : fromFields) {
                sb.append("private "+f.getType()+" "+f.getName()+";");
                sb.append("\n");
            }
            System.out.println(sb);
        } catch (ClassNotFoundException e) {
            System.out.println(" Class no found from the location " + e.getMessage());
        }
    }

    public String[] getFromClassNames(String packageName){
        String[] fromClassNames = {
                packageName+"Address",
                packageName+"AuditLog",
                packageName+"Cart",
                packageName+"Delivery",
                packageName+"DeliveryAddress",
                packageName+"Feedback",
                packageName+"Invoice",
                packageName+"Option",
                packageName+"Order",
                packageName+"Payment",
                packageName+"Person",
                packageName+"Poll",
                packageName+"Product",
                packageName+"ProductForInventory",
                packageName+"Receipt",
                packageName+"Return",
                packageName+"ReturnAddress",
                packageName+"Shipping",
                packageName+"ShippingAddress",
                packageName+"Stock",
                packageName+"User",
                packageName+"UserDetail",
                packageName+"UserRole",
                packageName+"Vote",
                packageName+"WishList"
        };
        return fromClassNames;
    }
    
    public String[] getToClassNames(String packageName){
        String[] toClassNames = {
                packageName+"Address",
                packageName+"AuditLog",
                packageName+"Cart",
                packageName+"Delivery",
                packageName+"DeliveryAddress",
                packageName+"Feedback",
                packageName+"Invoice",
                packageName+"Option",
                packageName+"Order",
                packageName+"Payment",
                packageName+"Person",
                packageName+"Poll",
                packageName+"Product",
                packageName+"ProductForInventory",
                packageName+"Receipt",
                packageName+"Return",
                packageName+"ReturnAddress",
                packageName+"Shipping",
                packageName+"ShippingAddress",
                packageName+"Stock",
                packageName+"User",
                packageName+"UserDetail",
                packageName+"UserRole",
                packageName+"Vote",
                packageName+"WishList"
        };
        return toClassNames;
    }
}
