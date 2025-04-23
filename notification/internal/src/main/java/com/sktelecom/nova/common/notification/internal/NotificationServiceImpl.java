package com.sktelecom.nova.common.notification.internal;

import com.sktelecom.nova.common.notification.api.NotificationDto;
import com.sktelecom.nova.common.notification.api.NotificationRequest;
import com.sktelecom.nova.common.notification.api.NotificationService;

import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
class NotificationServiceImpl implements NotificationService {
    private final NotificationRepository notificationRepository;
    private final ApplicationEventPublisher eventPublisher;

    @Override
    @Async
    @Transactional(propagation=Propagation.REQUIRES_NEW)
    public NotificationDto sendNotification(NotificationRequest notificationRequest) {
        Notification createdNotification = notificationRepository.save(
                Notification.createNotification(
                        notificationRequest.recipient(),
                        notificationRequest.title(),
                        notificationRequest.message()
                )
        );

        System.out.println("Notification Send: " + createdNotification);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        eventPublisher.publishEvent(createdNotification.createNotificationSentEvent());

        if(true) {
            throw new RuntimeException("Exception");
        }

        return NotificationMapper.toNotificationDto(createdNotification);
    }

    @Override
    public NotificationDto getNotificationById(UUID customerId) {
        return notificationRepository.findById(customerId).map(NotificationMapper::toNotificationDto)
                .orElseThrow(()->new RuntimeException("Notification not found"));
    }

    @Override
    public List<NotificationDto> findAllNotifications() {
        return notificationRepository.findAll().stream().map(NotificationMapper::toNotificationDto).toList();
    }
}
