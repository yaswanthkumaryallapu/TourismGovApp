package com.cognizant.user.service;

import java.time.LocalDateTime;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.cognizant.user.dto.AuditLogResponse;

public interface AuditLogService {

    // Internal audit logging
    void logAction(Long userId, String action, String resource, String status);

    void logActionInCurrentTransaction(Long userId, String action, String resource, String status);

    // Reporting
    Page<AuditLogResponse> getAllLogs(Pageable pageable);

    Page<AuditLogResponse> getLogsByUserId(Long userId, Pageable pageable);

    Page<AuditLogResponse> getLogsByDateRange(
            LocalDateTime start,
            LocalDateTime end,
            Pageable pageable);

    Page<AuditLogResponse> getLogsByAction(String action, Pageable pageable);
}
