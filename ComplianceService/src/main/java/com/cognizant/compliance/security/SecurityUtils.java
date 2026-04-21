package com.cognizant.compliance.security;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.server.ResponseStatusException;

public final class SecurityUtils {

    private static final String ANONYMOUS_USER = "anonymousUser";

    private SecurityUtils() {
        throw new IllegalStateException("Utility class cannot be instantiated");
    }
    public static Long getCurrentUserId() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication == null || !authentication.isAuthenticated() || 
            ANONYMOUS_USER.equals(authentication.getPrincipal())) {
            
            throw new ResponseStatusException(
                HttpStatus.UNAUTHORIZED, 
                "You must be logged in to perform this action."
            );
        }

        // Spring Security maps the JWT 'sub' claim to the principal's name
        try {
            return Long.parseLong(authentication.getName());
        } catch (NumberFormatException e) {
            throw new ResponseStatusException(
                HttpStatus.INTERNAL_SERVER_ERROR, 
                "Security context error: JWT Subject is not a valid numeric User ID. Found: " + authentication.getName()
            );
        }
    }
}