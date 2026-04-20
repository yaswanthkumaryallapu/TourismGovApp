package com.cognizant.compliance.dto;

import java.time.LocalDateTime;

import com.cognizant.compliance.enums.AuditStatus;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class AuditRequestDTO {

    @NotNull(message = "Officer ID is required")
    private Long officerId;

    @NotBlank(message = "Audit scope cannot be empty")
    @Size(max = 100, message = "Scope cannot exceed 100 characters")
    private String scope;

    private String findings; // Might be null when the audit is first scheduled

    @NotNull(message = "Audit date is required")
    private LocalDateTime date;

    @NotNull(message = "Audit status is required")
    private AuditStatus status;
}