package com.app.handcraft.entity.inventory;

import com.app.handcraft.entity.AuditLog;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="ADMIN_PRODUCT_FEATURE")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AdminProductFeature extends AuditLog {
    private static final long serialVersionUID=1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ADPRFE_ID", insertable = false, updatable = false, nullable = false)
    private Long adprfeId;
    @Column(name="HIGHLIGHT", unique = false, nullable = false)
    private String highlight;
    @Column(name="CATEGORY", unique = false, nullable = false)
    private String category;
    @Column(name="TITLE", unique = false, nullable = false)
    private String title;
    @Column(name="FEATURE", unique = false, nullable = false)
    @Lob
    private byte[] feature;
}
