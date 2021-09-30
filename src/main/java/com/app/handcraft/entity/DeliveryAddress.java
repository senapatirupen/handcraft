package com.app.handcraft.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="DELIVERY_ADDRESS")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DeliveryAddress extends AuditLog {
    private static final long serialVersionUID=1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="DEAD_ID", insertable = false, updatable = false, nullable = false)
    private Long deadId;
    @Column(name="DE_ID")
    private Long deId;
    @Column(name="ADDRESS_LINE_ONE", unique = false, nullable = true)
    private String addressLineOne;
    @Column(name="ADDRESS_LINE_TWO", unique = false, nullable = true)
    private String addressLineTwo;
    @Column(name="LANDMARK", unique = false, nullable = true)
    private String landmark;
    @Column(name="COUNTRY", unique = false, nullable = true)
    private String country;
    @Column(name="STATE", unique = false, nullable = true)
    private String state;
    @Column(name="CITY_VILLAGE", unique = false, nullable = true)
    private String cityVillage;
    @Column(name="ZIPCODE", unique = false, nullable = false)
    private String zipcode;
    @Column(name="TYPE", unique = false, nullable = false)
    private String type;
}
