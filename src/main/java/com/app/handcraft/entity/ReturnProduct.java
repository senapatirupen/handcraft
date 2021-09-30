package com.app.handcraft.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="RETURN_PRODUCT")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReturnProduct extends AuditLog {
    private static final long serialVersionUID=1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="RE_ID", insertable = false, updatable = false, nullable = false)
    private Long reId;
    @Column(name = "PR_IDS")
    private String prIds;
    @Column(name = "SH_ID", unique = false, nullable = true)
    private Long shId;
    @Column(name="START_DATE", unique = false, nullable = true)
    @Temporal(TemporalType.TIMESTAMP)
    private Date startDate;
    @Column(name="END_DATE", unique = false, nullable = true)
    @Temporal(TemporalType.TIMESTAMP)
    private Date endDate;
    @Column(name = "EXPECTED_DATE", unique = false, nullable = true)
    @Temporal(TemporalType.TIMESTAMP)
    private Date expectedDate;
    @Column(name="RETURN_STATUS", unique = false, nullable = false)
    private String returnStatus;
    @Column(name="IS_RETURNED", unique = false, nullable = true)
    private Boolean isReturned;
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name="READ_ID")
    @JsonIgnore
    private ReturnAddress returnAddress;
}
