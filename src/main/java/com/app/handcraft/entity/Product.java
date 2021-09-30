package com.app.handcraft.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="PRODUCT")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Product extends AuditLog {
    private static final long serialVersionUID=1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="PR_ID", insertable = false, updatable = false, nullable = false)
    private Long prId;
    @Column(name="OD_ID", unique = false, nullable = true)
    private Long odId;
    @Column(name="CA_ID", unique = false, nullable = true)
    private Long caId;
    @Column(name="PE_ID", unique = false, nullable = true)
    private Long peId;
    @Column(name="NAME", unique = false, nullable = false)
    private String name;
    @Column(name="MODEL", unique = false, nullable = false)
    private String model;
    @Column(name="MRP", unique = false, nullable = true)
    private Float MRP;
    @Column(name="SELL_PRICE", unique = false, nullable = true)
    private Float sellPrice;
    @Column(name="DISCOUNT_ON_MRP", unique = false, nullable = true)
    private Float discountOnMRP;
    @Column(name="PRODUCT_STATUS", unique = false, nullable = false)
    private String productStatus;
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name="FE_ID")
    @JsonIgnore
    private Feedback feedback;
//    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//    @JoinColumn(name="PRDE_ID")
//    private ProductDescription productDescription;
//    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//    @JoinColumn(name="PRFE_ID")
//    private ProductFeature productFeature;
//    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//    @JoinColumn(name="PRSP_ID")
//    private ProductSpecification productSpecification;
    @Column(name="IS_STOCK_AVAILABLE", unique = false, nullable = false)
    private Boolean isStockAvailable;
}
