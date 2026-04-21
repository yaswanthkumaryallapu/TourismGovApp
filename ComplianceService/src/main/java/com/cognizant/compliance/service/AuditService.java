package com.cognizant.compliance.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.cognizant.compliance.dto.AuditRequestDTO;
import com.cognizant.compliance.dto.AuditResponseDTO;

public interface AuditService {
    AuditResponseDTO recordAudit(AuditRequestDTO dto);
    AuditResponseDTO updateAuditFindings(Long auditId, String findings, String status);
    List<AuditResponseDTO> getAllAudits();
    Page<AuditResponseDTO> getAuditsByOfficer(Long officerId, int page, int size);
}