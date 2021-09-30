package com.app.handcraft.web.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Shipping extends AuditLog {
    private static final long serialVersionUID=1L;
    private Long shId;
    private String prIds;
    private Long odId;
    private String shippingStatus;
    private String productHealthStatus;
    private Float packagingCharge;
    private Date startDate;
    private Date endDate;
    private Date expectedDate;
    private String courierPerson;
    private ShippingAddress shippingAddress;
    private Delivery delivery;
}
