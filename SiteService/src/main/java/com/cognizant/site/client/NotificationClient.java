package com.cognizant.site.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "notification-service", path = "/api/notifications")
public interface NotificationClient {
    @PostMapping("/system-alert")
    void sendSystemAlert(@RequestParam("userId") Long userId,
                         @RequestParam("entityId") Long entityId,
                         @RequestParam("subject") String subject,
                         @RequestParam("message") String message,
                         @RequestParam("category") String category);
}