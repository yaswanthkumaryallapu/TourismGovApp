package com.cognizant.notification.model;

import com.cognizant.notification.enums.NotificationCategory;
import com.cognizant.notification.enums.NotificationStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "notifications")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "notification_id")
    private Long notificationId;

    @Column(name = "user_id", nullable = false)
    private Long userId; // Stores the ID from the external User service

    @Column(name = "entity_id")
    private Long entityId;

    @NotBlank(message = "Subject is required")
    @Size(max = 100)
    @Column(name = "subject", nullable = false, length = 100)
    private String subject;

    @NotBlank(message = "Message content is required")
    @Size(max = 500)
    @Column(name = "message", nullable = false, length = 500)
    private String message;

    @Enumerated(EnumType.STRING)
    @Column(name = "category", nullable = false)
    private NotificationCategory category;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private NotificationStatus status;

    @Column(name = "created_date", nullable = false, updatable = false)
    private LocalDateTime createdDate;

    @PrePersist
    protected void onCreate() {
        this.createdDate = LocalDateTime.now();
        if (this.status == null) this.status = NotificationStatus.UNREAD;
    }
}