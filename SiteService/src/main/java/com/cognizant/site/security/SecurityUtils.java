package com.cognizant.site.security;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.server.ResponseStatusException;

public final class SecurityUtils {

    // Sonar Fix: Extract hardcoded strings into constants (java:S1192)
    private static final String ANONYMOUS_USER = "anonymousUser";

    private SecurityUtils() {
        // Sonar Fix: Empty methods/constructors should be avoided. 
        // Throwing an exception prevents instantiation via Java Reflection (java:S1118 / java:S1186)
        throw new IllegalStateException("Utility class cannot be instantiated");
    }

    /**
     * Extracts the database User ID of the currently authenticated user from the JWT.
     * Throws an exception if the user is not logged in.
     * @return Long representing the current user ID
     */
    public static Long getCurrentUserId() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication == null || !authentication.isAuthenticated() || 
            ANONYMOUS_USER.equals(authentication.getPrincipal())) {
            
            throw new ResponseStatusException(
                HttpStatus.UNAUTHORIZED, 
                "You must be logged in to perform this action."
            );
        }

        // MICROSERVICE FIX: In a JWT Resource Server, there is no CustomUserDetails.
        // Spring Security extracts the 'subject' (sub claim) from the JWT and stores it in the Name.
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