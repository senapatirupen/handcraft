package com.app.handcraft.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="USER_PERMISSION", uniqueConstraints = { @UniqueConstraint(columnNames = { "permission" }) })
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserPermission extends AuditLog {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "UP_ID", insertable = false, updatable = false, nullable = false)
	private Long upId;
	@Column(name="PERMISSION", unique = false, nullable = false)
	private String permission;

}
