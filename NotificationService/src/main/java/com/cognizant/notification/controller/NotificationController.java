package com.cognizant.notification.controller;

import com.cognizant.notification.dto.NotificationRequestDTO;
import com.cognizant.notification.dto.NotificationResponseDTO;
import com.cognizant.notification.enums.NotificationCategory;
import com.cognizant.notification.service.NotificationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notifications") // Standard microservice naming
@RequiredArgsConstructor
public class NotificationController {

    private final NotificationService notificationService;

    // 1. Create - Used by other services (like Report) to send a notification
    @PostMapping
    public ResponseEntity<NotificationResponseDTO> create(
            @Valid @RequestBody NotificationRequestDTO request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(notificationService.create(request));
    }

    // 2. Get All - Uses header injected by API Gateway for security
    @GetMapping
    public ResponseEntity<List<NotificationResponseDTO>> getAll(
            @RequestHeader("X-User-Id") Long userId) {
        return ResponseEntity.ok(notificationService.getAll(userId));
    }
    
    // 3. Get by Category - User ID from Header, Category from Path
    @GetMapping("/category/{category}")
    public ResponseEntity<List<NotificationResponseDTO>> getNotificationsByCategory(
            @RequestHeader("X-User-Id") Long userId,
            @PathVariable NotificationCategory category) {
        return ResponseEntity.ok(notificationService.getByCategory(userId, category));
    }

    // 4. Get Unread - Uses header
    @GetMapping("/unread")
    public ResponseEntity<List<NotificationResponseDTO>> getUnread(
            @RequestHeader("X-User-Id") Long userId) {
        return ResponseEntity.ok(notificationService.getUnread(userId));
    }

    // 5. Mark as Read - Uses ID from path and UserID from header to verify ownership
    @PatchMapping("/{id}/read")
    public ResponseEntity<NotificationResponseDTO> markAsRead(
            @PathVariable Long id,
            @RequestHeader("X-User-Id") Long userId) {
        return ResponseEntity.ok(notificationService.markAsRead(id, userId));
    }
    
    // 6. Broadcast - Still requires the full request body
    @PostMapping("/broadcast")
    public ResponseEntity<String> broadcast(@Valid @RequestBody NotificationRequestDTO request) {
        notificationService.sendGlobalNotification(request);
        return ResponseEntity.ok("Global Broadcast Successful!");
    }
}