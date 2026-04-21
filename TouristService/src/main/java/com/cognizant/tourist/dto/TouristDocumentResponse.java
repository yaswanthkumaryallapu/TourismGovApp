package com.cognizant.tourist.dto;

import java.time.LocalDateTime;

import com.cognizant.tourist.enums.VerificationStatus;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TouristDocumentResponse {
    private Long documentId;
    private String docType;
    private String fileUri;
    private LocalDateTime uploadedDate;
    private VerificationStatus verificationStatus;
    private String remarks;

}
