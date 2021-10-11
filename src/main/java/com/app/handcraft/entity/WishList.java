package com.app.handcraft.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="WISH_LIST")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WishList extends AuditLog {
    private static final long serialVersionUID=1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="WI_ID", insertable = false, updatable = false, nullable = false)
    private Long wiId;
    @Column(name="WISH_LIST_STATUS", unique = false, nullable = false)
    private String wishListStatus;
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name="WI_ID")
    private Set<Product> products = new HashSet<>();
}
