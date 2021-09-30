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
public class Invoice extends AuditLog {
    private static final long serialVersionUID=1L;
    private Long inId;
    private Long odId;
    private Long shId;
    private Date orderStartDate;
    private String invoiceNumber;
    private Date startDate;
    private Long prId;
    private String productName;
    private String productDetail;
    private Long qty;
    private String communicationAddress;
    private Float grossAmount;
    private Float discount;
    private Float taxableAmount;
    private Float cgst;
    private Float sgst;
    private Float totalAmount;
    private Float grandTotal;
    private String authorizedSignature;
    private String cin;
    private String pan;
    private String gstin;
    private Long peId;
    private String customerName;
    private String customerDetail;
    private String shipFromAddress;
    private String shipToAddress;
}
