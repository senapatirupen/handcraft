package com.app.handcraft.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="PAYMENT")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Payment extends AuditLog {
    private static final long serialVersionUID=1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="PA_ID", insertable = false, updatable = false, nullable = false)
    private Long paId;
    @Column(name="OD_ID")
    private Long odId;
    @Column(name="NAME", unique = false, nullable = true)
    private String name;
    @Column(name="PRICE", unique = false, nullable = true)
    private Float price;
    @Column(name="OFFER_PERCENTAGE", unique = false, nullable = true)
    private Float offerPercentage;
    @Column(name="PAYMENT_STATUS", unique = false, nullable = true)
    private String paymentStatus;
    @Column(name="TYPE", unique = false, nullable = true)
    private String type;
}
