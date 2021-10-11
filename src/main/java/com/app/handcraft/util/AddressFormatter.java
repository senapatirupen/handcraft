package com.app.handcraft.util;

import com.app.handcraft.entity.Address;
import org.apache.commons.lang3.StringUtils;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AddressFormatter {

    public static String addressFormat(Address address) {
        String addressAfterFormat =
                Stream.of("ID:"+address.getAdId(), "TYPE:"+address.getType().toUpperCase(), address.getAddressLineOne(), address.getAddressLineTwo(),
                        address.getState(), address.getCountry(), address.getLandmark(),
                        address.getZipcode()).filter(StringUtils::isNotBlank)
                        .collect(Collectors.joining(", "));
        return addressAfterFormat;
    }

    public static String addressCommaFormat(Address address) {
        return String.format("%s, %s", address.getAddressLineOne(), address.getAddressLineTwo());
    }

}
