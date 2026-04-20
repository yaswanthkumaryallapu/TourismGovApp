package com.cognizant.compliance.dto;


import java.time.LocalDateTime;

import com.cognizant.compliance.enums.AuditStatus;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AuditResponseDTO {
    private Long auditId;
    private Long officerId;
    private String scope;
    private String findings;
    private LocalDateTime date;
    private AuditStatus status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}