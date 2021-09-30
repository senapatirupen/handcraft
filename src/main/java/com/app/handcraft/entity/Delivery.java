package com.app.handcraft.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "DELIVERY")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Delivery extends AuditLog {
    private static final long serialVersionUID=1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DE_ID", insertable = false, updatable = false, nullable = false)
    private Long deId;
    @Column(name = "PR_IDS")
    private String prIds;
    @Column(name = "SH_ID", unique = false, nullable = true)
    private Long shId;
    @Column(name = "DELIVERY_STATUS", unique = false, nullable = false)
    private String deliveryStatus;
    @Column(name = "PRODUCT_HEALTH_STATUS", unique = false, nullable = true)
    private String productHealthStatus;
    @Column(name = "PACKAGING_STATUS", unique = false, nullable = true)
    private String packagingStatus;
    @Column(name="START_DATE", unique = false, nullable = true)
    @Temporal(TemporalType.TIMESTAMP)
    private Date startDate;
    @Column(name="END_DATE", unique = false, nullable = true)
    @Temporal(TemporalType.TIMESTAMP)
    private Date endDate;
    @Column(name = "EXPECTED_DATE", unique = false, nullable = true)
    @Temporal(TemporalType.TIMESTAMP)
    private Date expectedDate;
    @Column(name="IS_DELIVERED", unique = false, nullable = true)
    private Boolean isDelivered;
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name="DEAD_ID")
    @JsonIgnore
    private DeliveryAddress deliveryAddress;
}
