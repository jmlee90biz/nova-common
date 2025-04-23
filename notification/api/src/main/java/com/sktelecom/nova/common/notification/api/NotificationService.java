package com.sktelecom.nova.common.notification.api;

import java.util.List;
import java.util.UUID;

public interface NotificationService {
    NotificationDto sendNotification(NotificationRequest notificationRequest);
    NotificationDto getNotificationById(UUID customerId);
    List<NotificationDto> findAllNotifications();
}
