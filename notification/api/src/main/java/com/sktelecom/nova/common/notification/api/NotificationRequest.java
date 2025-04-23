package com.sktelecom.nova.common.notification.api;

public record NotificationRequest(String recipient, String title, String message) {
//    public static NotificationRequest fromEvent(NotificationRequestedEvent event) {
//        return new NotificationRequest(
//                event.recipient(),
//                event.title(),
//                event.message()
//        );
//    }
}
