package com.app.handcraft.entity;

import com.apress.prospringmvc.bookstore.domain.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "USER_DETAIL")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDetail extends AuditLog {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "US_ID", insertable = false, updatable = false, nullable = false)
    private Long usId;
    @Column(name="NAME", unique = false, nullable = false)
    private String name;
    @Column(name="FIRST_NAME", unique = false, nullable = true)
    private String firstName;
    @Column(name="LAST_NAME", unique = false, nullable = true)
    private String lastName;
    @Column(name = "USERNAME", unique = false, nullable = false)
    private String username;
    @Column(name = "EMAIL_ID", unique = false, nullable = false)
    private String emailId;
    @Column(name = "PHONE_NUMBER", unique = false, nullable = false)
    private String phoneNumber;
    @Column(name = "PASSWORD", unique = false, nullable = false)
    private String password;
    @Column(name = "RE_PASSWORD", unique = false, nullable = false)
    private String rePassword;
    @Column(name = "DOB", unique = false, nullable = true)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dob;
    @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    private List<UserRole> roles = new ArrayList<>();
}
