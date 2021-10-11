package com.app.handcraft.entity;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@MappedSuperclass
public class AuditLog implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "CREATED_BY", nullable = false, unique = false)
    protected String createdBy;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "CREATED_DATE", nullable = false, unique = false)
    @Temporal(TemporalType.TIMESTAMP)
    protected Date createdDate;
    @Column(name = "LAST_MODIFIED_BY", nullable = false, unique = false)
    protected String lastModifiedBy;
    @Column(name = "LAST_MODIFIED_DATE", nullable = false, unique = false)
    @Temporal(TemporalType.TIMESTAMP)
    protected Date lastModifiedDate;
    @Column(name = "IS_ACTIVE", nullable = false, unique = false)
    protected Boolean isActive;
    @Column(name = "STATUS", nullable = false, unique = false)
    protected String status;

    @PrePersist
    public void onPrePersist() {
        setCreatedBy("Rupen");
        setCreatedDate(new Date());
        setLastModifiedBy("Rupen");
        setLastModifiedDate(new Date());
        setIsActive(true);
        setStatus("Active");
    }

    @PreRemove
    @PreUpdate
    public void onPreUpdate() {
        setLastModifiedDate(new Date());
    }
}
