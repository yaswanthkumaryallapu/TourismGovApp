package com.cognizant.compliance.dto;

import com.cognizant.compliance.enums.Role;
import com.cognizant.compliance.enums.Status;

import lombok.Data;

@Data
public class UserResponseDto {

	private Long userId;
	private String name;
	private Role role;
	private String email;
	private String phone;
	private Status status;
}