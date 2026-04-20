package com.cognizant.notification.repository;

import com.cognizant.notification.model.Notification;
import com.cognizant.notification.enums.NotificationCategory;
import com.cognizant.notification.enums.NotificationStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Long> {

    List<Notification> findByUserIdOrderByCreatedDateDesc(Long userId);

    List<Notification> findByUserIdAndStatusOrderByCreatedDateDesc(Long userId, NotificationStatus status);

    Optional<Notification> findByNotificationIdAndUserId(Long notificationId, Long userId);

    long countByUserIdAndStatus(Long userId, NotificationStatus status);

    @Modifying
    @Query("UPDATE Notification n SET n.status = :status WHERE n.notificationId = :id AND n.userId = :userId")
    int updateStatus(@Param("status") NotificationStatus status, @Param("id") Long id, @Param("userId") Long userId);
    
    List<Notification> findByUserIdAndCategoryOrderByCreatedDateDesc(Long userId, NotificationCategory category);
}