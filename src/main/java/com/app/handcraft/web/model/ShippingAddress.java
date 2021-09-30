package com.app.handcraft.web.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ShippingAddress extends AuditLog {
    private static final long serialVersionUID=1L;
    private Long shadId;
    private Long shId;
    private String addressLineOne;
    private String addressLineTwo;
    private String landmark;
    private String country;
    private String state;
    private String cityVillage;
    private String zipcode;
    private String type;
}
