package com.cognizant.notification.dto;

import com.cognizant.notification.enums.NotificationCategory; // FIXED
import com.cognizant.notification.enums.NotificationStatus;   // FIXED
import lombok.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NotificationResponseDTO {

    private Long notificationId;
    private Long userId;
    private String userName; // We will fill this using the UserClient (Feign)
    private String subject;
    private Long entityId;
    private String message;
    private NotificationCategory category;
    private NotificationStatus status;
    private LocalDateTime createdDate;
}