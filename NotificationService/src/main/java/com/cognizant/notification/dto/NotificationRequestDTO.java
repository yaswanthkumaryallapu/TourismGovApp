package com.cognizant.notification.dto;

import com.cognizant.notification.enums.NotificationCategory; // FIXED: Import from your microservice package
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NotificationRequestDTO {

    @NotNull(message = "userId is required")
    private Long userId;

    private Long entityId;

    @NotBlank(message = "message cannot be blank")
    @Size(min = 5, max = 500, message = "Message must be between 5 and 500 characters")
    private String message;

    private NotificationCategory category;

    @NotBlank(message = "Email subject is required")
    @Size(max = 100, message = "Subject line cannot exceed 100 characters")
    private String subject;
}