package com.app.handcraft.entity.inventory;
import com.app.handcraft.entity.AuditLog;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="ADMIN_PRODUCT_PRICE")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AdminProductPrice extends AuditLog {
    private static final long serialVersionUID=1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ADPRPR_ID", insertable = false, updatable = false, nullable = false)
    private Long adPrPrId;
    @Column(name="MRP", unique = false, nullable = true)
    private Float MRP;
    @Column(name="SELL_PRICE", unique = false, nullable = true)
    private Float sellPrice;
    @Column(name="DISCOUNT_ON_MRP", unique = false, nullable = true)
    private Float discountOnMRP;
}
