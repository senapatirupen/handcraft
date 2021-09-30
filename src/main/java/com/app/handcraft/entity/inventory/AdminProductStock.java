package com.app.handcraft.entity.inventory;

import com.app.handcraft.entity.AuditLog;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "ADMIN_PRODUCT_STOCK")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AdminProductStock extends AuditLog {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ADPRST_ID", insertable = false, updatable = false, nullable = false)
    private Long adprstId;
    @Column(name = "NAME", unique = false, nullable = false)
    private String name;
    @Column(name="START_DATE", nullable = false, unique = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date startDate;
    @Column(name="END_DATE", nullable = false, unique = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date endDate;
    @Column(name = "EXPECTED_DATE", unique = false, nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date expectedDate;
    @Column(name = "IS_AVAILABLE", unique = false, nullable = false)
    private Boolean isAvailable;
    @Column(name = "QUANTITY", unique = false, nullable = false)
    private Integer quantity;
    @Column(name = "STOCK_STATUS", unique = false, nullable = false)
    private String stockStatus;
}
