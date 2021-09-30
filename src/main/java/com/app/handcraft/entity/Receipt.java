package com.app.handcraft.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="RECEIPT")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Receipt extends AuditLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="RE_ID", insertable = false, updatable = false, nullable = false)
    private Long reId;
}
