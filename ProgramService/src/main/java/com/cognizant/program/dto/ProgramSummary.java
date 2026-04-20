package com.cognizant.program.dto;

import lombok.Data;
import lombok.AllArgsConstructor;

@Data
@AllArgsConstructor
public class ProgramSummary {
    private Long programId;
    private String title;
    private String status;
}