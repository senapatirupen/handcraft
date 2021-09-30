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
public class Stock extends AuditLog {
    private static final long serialVersionUID=1L;
    private Long stId;
    private String name;
    private Date startDate;
    private Date endDate;
    private Date expectedDate;
    private Boolean isAvailable;
    private Integer quantity;
    private String stockStatus;
}
