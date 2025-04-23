package com.sktelecom.nova.common.notification.internal;

import com.sktelecom.nova.billing.payment.event.PaymentCreatedEvent;
import com.sktelecom.nova.common.notification.api.NotificationRequest;
import com.sktelecom.nova.common.notification.api.NotificationService;

import com.sktelecom.nova.customer.profile.event.CustomerRegisteredEvent;
import com.sktelecom.nova.product.catalog.event.ProductRegisteredEvent;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.modulith.events.ApplicationModuleListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionalEventListener;
import org.springframework.transaction.annotation.Transactional;

import static org.springframework.transaction.event.TransactionPhase.AFTER_ROLLBACK;

@Component
@RequiredArgsConstructor
@Slf4j
public class NotificationEventListener {
    private final NotificationService notificationService;

    //@Async("taskExecutor")
    //@ApplicationModuleListener
    //@EventListener
//    @TransactionalEventListener
//    void onNotificationRequestedEvent(final NotificationRequestedEvent notificationRequestedEvent) {
//        notificationService.sendNotification(NotificationRequestedEvent.fromEvent(notificationRequestedEvent));
//    }

//    @Async
//    //@Transactional(propagation=Propagation.REQUIRES_NEW)
//    @TransactionalEventListener(phase=AFTER_ROLLBACK)
    //@TransactionalEventListener(phase=BEFORE_COMMIT)
    //@TransactionalEventListener(phase=AFTER_COMPLETION)
    //@EventListener
    @ApplicationModuleListener
    public void onCustomerRegisteredEvent(final CustomerRegisteredEvent customerRegisteredEvent) {
        notificationService.sendNotification(new NotificationRequest(
                customerRegisteredEvent.email(),
                "Customer Registered",
                "Succuess")
        );
    }

    @ApplicationModuleListener
    public void onProductRegisteredEvent(final ProductRegisteredEvent productRegisteredEvent) {
        notificationService.sendNotification(new NotificationRequest(
                productRegisteredEvent.email(),
                "Prouct Registered",
                "Succuess")
        );
    }

    @EventListener
    public void onPaymentCreationEvent(final PaymentCreatedEvent paymentCreationEvent) {
        try {
            notificationService.sendNotification(new NotificationRequest(
                    "Customer",
                    "Payment Creation",
                    "Succuess")
            );
        } catch(RuntimeException e) {
            // Ignore
            log.warn("알림 실패: {}", paymentCreationEvent.id());
        }
    }

}