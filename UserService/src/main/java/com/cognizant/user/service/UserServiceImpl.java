package com.cognizant.user.service;

import java.util.List;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cognizant.user.dto.UserRequest;
import com.cognizant.user.dto.UserResponse;
import com.cognizant.user.entity.User;
import com.cognizant.user.enums.Status;
import com.cognizant.user.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public UserResponse registerUser(UserRequest request) {

        User user = new User();
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setRole(request.getRole());
        user.setStatus(
            request.getStatus() != null ? request.getStatus() : Status.ACTIVE
        );
        user.setPhone(request.getPhone());
        user.setPassword(passwordEncoder.encode(request.getPassword()));

        User saved = userRepository.save(user);
        return toResponse(saved);
    }

    @Override
    public List<UserResponse> fetchAllUsers() {
        return userRepository.findAll()
            .stream()
            .map(this::toResponse)
            .toList();
    }

    private UserResponse toResponse(User user) {
        UserResponse dto = new UserResponse();
        dto.setUserId(user.getUserId());
        dto.setName(user.getName());
        dto.setEmail(user.getEmail());
        dto.setRole(user.getRole());
        dto.setPhone(user.getPhone());
        dto.setStatus(user.getStatus());
        return dto;
    }
}