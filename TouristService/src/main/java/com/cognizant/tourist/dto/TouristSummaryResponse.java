package com.cognizant.tourist.dto;

import com.cognizant.tourist.enums.Status;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class TouristSummaryResponse {
	private Long touristId;
	private String name;
	private Status status;
}
