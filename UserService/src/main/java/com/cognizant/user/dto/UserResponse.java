package com.cognizant.user.dto;

import com.cognizant.user.enums.Role;
import com.cognizant.user.enums.Status;

import lombok.Data;

@Data
public class UserResponse {

	private Long userId;
	private String name;
	private Role role;
	private String email;
	private String phone;
	private Status status;
}