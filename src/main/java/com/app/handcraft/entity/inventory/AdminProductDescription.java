package com.app.handcraft.entity.inventory;

import com.app.handcraft.entity.AuditLog;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="ADMIN_PRODUCT_DESCRIPTION")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AdminProductDescription extends AuditLog {
    private static final long serialVersionUID=1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ADPRDE_ID", insertable = false, updatable = false, nullable = false)
    private Long adprdeId;
    @Column(name="SHORT_DESC", unique = false, nullable = true)
    @Lob
    private byte[] shortDesc;
    @Column(name="LONG_DESC", unique = false, nullable = true)
    @Lob
    private byte[] longDesc;
}
