package com.sktelecom.nova.customer.profile.internal;

//import com.sktelecom.nova.modular.monolith.common.notification.event.NotificationRequestedEvent;
import com.sktelecom.nova.customer.profile.event.CustomerRegisteredEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CustomerEventListener {
    //private final EventPublisher eventPublisher;
    private final ApplicationEventPublisher eventPublisher;

    //@Async("taskExecutor")
//    @ApplicationModuleListener
//    //@EventListener
//    @Transactional(propagation = Propagation.REQUIRES_NEW)
//    @TransactionalEventListener
//    void onCustomerRegisteredEvent(final CustomerRegisteredEvent customerRegisteredEvent) {
//        eventPublisher.publishEvent(
//                NotificationRequestedEvent.create(
//                        customerRegisteredEvent.email(),
//                        "Customer Registered",
//                        "Welcome!"
//                )
//        );
//    }
}
