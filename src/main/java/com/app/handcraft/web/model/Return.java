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
public class Return extends AuditLog {
    private static final long serialVersionUID=1L;
    private Long reId;
    private Long odId;
    private String prIds;
    private Date startDate;
    private Date endDate;
    private Date expectedDate;
    private String returnStatus;
    private String isReturned;
    private ReturnAddress returnAddress;
}
