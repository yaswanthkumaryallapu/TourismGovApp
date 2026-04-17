package com.cognizant.user.service;

import com.cognizant.user.dto.AuthRequest;
import com.cognizant.user.dto.AuthResponse;
import com.cognizant.user.dto.PasswordResetRequest;
import com.cognizant.user.dto.PasswordUpdateRequest;
import com.cognizant.user.dto.UserRequest;
import com.cognizant.user.dto.UserResponse;

public interface AuthService {
    UserResponse registerUser(UserRequest request);
    AuthResponse loginUser(AuthRequest request);
    void updatePassword(PasswordUpdateRequest request);
    void resetPassword(PasswordResetRequest request);
}