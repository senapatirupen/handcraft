package com.app.handcraft.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name="PERSON")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Person extends AuditLog {
    private static final long serialVersionUID=1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="PE_ID", insertable = false, updatable = false, nullable = false)
    private Long peId;
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name="US_ID")
    @JsonIgnore
    private UserDetail userDetail;
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name="CA_ID")
    @JsonIgnore
    private Cart cart;
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name="PE_ID")
    private Collection<Product> products;
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name="PE_ID")
    private Collection<Order> orders;
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name="PE_ID")
    private Collection<Address> addresses;
}
