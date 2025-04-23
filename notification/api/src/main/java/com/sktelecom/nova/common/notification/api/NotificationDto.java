package com.sktelecom.nova.common.notification.api;

import java.util.UUID;

public record NotificationDto(UUID id, String recipient, String title, String message) {
}
