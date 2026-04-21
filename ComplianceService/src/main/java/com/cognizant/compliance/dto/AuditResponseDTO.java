package com.cognizant.compliance.dto;

import com.cognizant.compliance.enums.AuditStatus;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL) // Ensures null fields (like findings on a new audit) aren't sent in the JSON response
public class AuditResponseDTO {

    private Long auditId;
    
    // In a microservice, we send the flat ID and the resolved name, rather than a nested User object
    private Long officerId;
    private String officerName; 
    
    private String scope;
    private String findings;
    private LocalDateTime date;
    
    // Storing as a String in the DTO makes JSON serialization straightforward, 
    // even though it maps to the AuditStatus enum in the database.
    private AuditStatus status; 

}