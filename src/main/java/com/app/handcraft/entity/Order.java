package com.app.handcraft.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

@Entity
@Table(name="PE_ORDER")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Order extends AuditLog {
    private static final long serialVersionUID=1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="OD_ID", insertable = false, updatable = false, nullable = false)
    private Long odId;
    @Column(name="PE_ID")
    private Long peId;
    @Column(name="ORDER_STATUS", unique = false, nullable = true)
    private String orderStatus;
    @Column(name="IS_DELIVERED", unique = false, nullable = true)
    private Boolean isDelivered;
    @Column(name="START_DATE", unique = false, nullable = true)
    @Temporal(TemporalType.TIMESTAMP)
    private Date startDate;
    @Column(name="END_DATE", unique = false, nullable = true)
    @Temporal(TemporalType.TIMESTAMP)
    private Date endDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "EXPECTED_DATE", unique = false, nullable = true)
    @Temporal(TemporalType.TIMESTAMP)
    private Date expectedDate;
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name="OD_ID")
    private Collection<Product> products;
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name="OD_ID")
    private Collection<Shipping> shipping;
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name="PA_ID")
    @JsonIgnore
    private Payment payment;
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name="BIAD_ID")
    @JsonIgnore
    private BillingAddress billingAddress;
}
