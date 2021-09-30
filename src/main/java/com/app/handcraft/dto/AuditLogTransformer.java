package com.app.handcraft.dto;

public class AuditLogTransformer {
    public com.app.handcraft.web.model.AuditLog transfer(com.app.handcraft.entity.AuditLog fromAuditLog){
        com.app.handcraft.web.model.AuditLog toAuditLog = new com.app.handcraft.web.model.AuditLog();
        toAuditLog.setCreatedBy(fromAuditLog.getCreatedBy());
        toAuditLog.setCreatedDate(fromAuditLog.getCreatedDate());
        toAuditLog.setLastModifiedBy(fromAuditLog.getLastModifiedBy());
        toAuditLog.setLastModifiedDate(fromAuditLog.getLastModifiedDate());
        toAuditLog.setIsActive(fromAuditLog.getIsActive());
        toAuditLog.setStatus(fromAuditLog.getStatus());
        return toAuditLog;
    }

    public com.app.handcraft.entity.AuditLog transfer(com.app.handcraft.web.model.AuditLog fromAuditLog){
        com.app.handcraft.entity.AuditLog toAuditLog = new com.app.handcraft.entity.AuditLog();
        toAuditLog.setCreatedBy(fromAuditLog.getCreatedBy());
        toAuditLog.setCreatedDate(fromAuditLog.getCreatedDate());
        toAuditLog.setLastModifiedBy(fromAuditLog.getLastModifiedBy());
        toAuditLog.setLastModifiedDate(fromAuditLog.getLastModifiedDate());
        toAuditLog.setIsActive(fromAuditLog.getIsActive());
        toAuditLog.setStatus(fromAuditLog.getStatus());
        return toAuditLog;
    }
}
