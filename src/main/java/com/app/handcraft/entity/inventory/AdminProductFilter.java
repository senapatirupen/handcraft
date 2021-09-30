package com.app.handcraft.entity.inventory;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import com.app.handcraft.entity.AuditLog;

@Entity
@Table(name="ADMIN_PRODUCT_FILTER")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AdminProductFilter extends AuditLog {
    private static final long serialVersionUID=1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ADPRFI_ID", insertable = false, updatable = false, nullable = false)
    private Long adprfiId;
    @Column(name="FILTER", unique = false, nullable = false)
    private String filter;
}
