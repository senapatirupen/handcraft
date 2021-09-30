package com.app.handcraft.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "CART")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Cart extends AuditLog {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CA_ID", insertable = false, updatable = false, nullable = false)
    private Long caId;
    @Column(name = "CART_STATUS", unique = false, nullable = false)
    private String cartStatus;
    @Column(name = "PE_ID", unique = false, nullable = false)
    private Long peId;
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "CA_ID")
    private Collection<Product> products;
}
