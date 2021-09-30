package com.app.handcraft.repository;

import com.app.handcraft.entity.UserPermission;
import com.app.handcraft.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserPermissionRepository extends JpaRepository<UserPermission, Long> {
}
