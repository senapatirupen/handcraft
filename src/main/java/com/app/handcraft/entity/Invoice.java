package com.app.handcraft.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "INVOICE")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Invoice extends AuditLog {
    private static final long serialVersionUID=1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IN_ID", insertable = false, updatable = false, nullable = false)
    private Long inId;
    @Column(name = "OD_ID", unique = false, nullable = false)
    private Long odId;
    @Column(name = "SH_ID", unique = false, nullable = false)
    private Long shId;
    @Column(name="ORDER_START_DATE", nullable = false, unique = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date orderStartDate;
    @Column(name = "INVOICE_NUMBER", unique = false, nullable = false)
    private String invoiceNumber;
    @Column(name="START_DATE", nullable = false, unique = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date startDate;
    @Column(name = "PR_ID", unique = false, nullable = false)
    private Long prId;
    @Column(name = "PRODUCT_NAME", unique = false, nullable = false)
    private String productName;
    @Column(name = "PRODUCT_DETAIL", unique = false, nullable = false)
    private String productDetail;
    @Column(name = "QTY", unique = false, nullable = false)
    private Long qty;
    @Column(name = "COMMUNICATION_ADDRESS", unique = false, nullable = false)
    private String communicationAddress;
    @Column(name = "GROSS_AMOUNT", unique = false, nullable = false)
    private Float grossAmount;
    @Column(name = "DISCOUNT", unique = false, nullable = false)
    private Float discount;
    @Column(name = "TAXABLE_AMOUNT", unique = false, nullable = false)
    private Float taxableAmount;
    @Column(name = "CGST", unique = false, nullable = false)
    private Float cgst;
    @Column(name = "SGST", unique = false, nullable = false)
    private Float sgst;
    @Column(name = "TOTAL_AMOUNT", unique = false, nullable = false)
    private Float totalAmount;
    @Column(name = "GRAND_TOTAL", unique = false, nullable = false)
    private Float grandTotal;
    @Column(name = "AUTHORIZED_SIGNATURE", unique = false, nullable = false)
    private String authorizedSignature;
    @Column(name = "CIN", unique = false, nullable = false)
    private String cin;
    @Column(name = "PAN", unique = false, nullable = false)
    private String pan;
    @Column(name = "GSTIN", unique = false, nullable = false)
    private String gstin;
    @Column(name = "PE_ID", unique = false, nullable = false)
    private Long peId;
    @Column(name = "CUSTOMER_NAME", unique = false, nullable = false)
    private String customerName;
    @Column(name = "CUSTOMER_DETAIL", unique = false, nullable = false)
    private String customerDetail;
    @Column(name = "SHIP_FROM_ADDRESS", unique = false, nullable = false)
    private String shipFromAddress;
    @Column(name = "SHIP_TO_ADDRESS", unique = false, nullable = false)
    private String shipToAddress;
}
