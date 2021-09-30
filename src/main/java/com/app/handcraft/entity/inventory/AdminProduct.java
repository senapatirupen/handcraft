package com.app.handcraft.entity.inventory;

import com.app.handcraft.entity.AuditLog;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="ADMIN_PRODUCT")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AdminProduct extends AuditLog {
    private static final long serialVersionUID=1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ADPR_ID", insertable = false, updatable = false, nullable = false)
    private Long adPrId;
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
    @JoinColumn(name="ADPRDE_ID")
    @JsonIgnore
    private AdminProductDescription adminProductDescription;
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name="ADPRFE_ID")
    @JsonIgnore
    private AdminProductFeature adminProductFeature;
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name="ADPRSP_ID")
    @JsonIgnore
    private AdminProductSpecification adminProductSpecification;
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name="ADPRST_ID")
    @JsonIgnore
    private AdminProductStock adminProductStock;
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name="ADPRPR_ID")
    @JsonIgnore
    private AdminProductPrice adminProductPrice;
}
