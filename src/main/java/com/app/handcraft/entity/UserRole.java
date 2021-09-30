package com.app.handcraft.entity;

import com.apress.prospringmvc.bookstore.domain.Permission;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "USER_ROLE", uniqueConstraints = { @UniqueConstraint(columnNames = { "role" }) })
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserRole extends AuditLog {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "UR_ID", insertable = false, updatable = false, nullable = false)
    private Long urId;
    @Column(name = "ROLE", unique = false, nullable = false)
    private String role;
    @ManyToMany(cascade = CascadeType.ALL)
    private List<UserPermission> permissions = new ArrayList<>();
    public UserRole(String role){
        this.role = role;
    }
}
