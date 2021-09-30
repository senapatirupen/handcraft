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
public class Delivery extends AuditLog {
    private static final long serialVersionUID=1L;
    private Long deId;
    private String prIds;
    private Long shId;
    private String deliveryStatus;
    private String productHealthStatus;
    private String packagingStatus;
    private Date startDate;
    private Date endDate;
    private Date expectedDate;
    private DeliveryAddress deliveryAddress;
}
