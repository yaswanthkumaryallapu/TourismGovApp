package com.cognizant.user.service;

import java.util.List;

import com.cognizant.user.dto.UserRequest;
import com.cognizant.user.dto.UserResponse;

public interface UserService {

    UserResponse registerUser(UserRequest request);

    List<UserResponse> fetchAllUsers();
}