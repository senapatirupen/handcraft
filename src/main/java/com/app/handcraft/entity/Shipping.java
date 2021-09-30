package com.app.handcraft.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "SHIPPING")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Shipping extends AuditLog {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SH_ID", insertable = false, updatable = false, nullable = false)
    private Long shId;
    @Column(name = "PR_IDS")
    private String prIds;
    @Column(name = "OD_ID", unique = false, nullable = true)
    private Long odId;
    @Column(name = "SHIPPING_STATUS", unique = false, nullable = false)
    private String shippingStatus;
    @Column(name = "PRODUCT_HEALTH_STATUS", unique = false, nullable = true)
    private String productHealthStatus;
    @Column(name = "PACKAGING_CHARGE", unique = false, nullable = true)
    private Float packagingCharge;
    @Column(name="START_DATE", unique = false, nullable = true)
    @Temporal(TemporalType.TIMESTAMP)
    private Date startDate;
    @Column(name="END_DATE", unique = false, nullable = true)
    @Temporal(TemporalType.TIMESTAMP)
    private Date endDate;
    @Column(name = "EXPECTED_DATE", unique = false, nullable = true)
    @Temporal(TemporalType.TIMESTAMP)
    private Date expectedDate;
    @Column(name = "COURIER_PERSON", unique = false, nullable = true)
    private String courierPerson;
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name="SHAD_ID")
    @JsonIgnore
    private ShippingAddress shippingAddress;
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JsonIgnore
    private Delivery delivery;
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JsonIgnore
    private ReturnProduct areturn;
}
