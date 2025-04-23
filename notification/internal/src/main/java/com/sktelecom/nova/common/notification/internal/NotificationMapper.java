package com.sktelecom.nova.common.notification.internal;

import com.sktelecom.nova.common.notification.api.NotificationDto;

class NotificationMapper {
    static NotificationDto toNotificationDto(Notification notification) {
        return new NotificationDto(notification.getId(), notification.getRecipient(), notification.getTitle(), notification.getMessage());
    }
}
