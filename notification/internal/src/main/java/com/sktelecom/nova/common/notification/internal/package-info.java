@ApplicationModule(
        displayName = "common-notification",
        allowedDependencies = {
            "customer.profile.event",
                "product.catalog.event",
                "billing.payment.event"
        }
)
package com.sktelecom.nova.common.notification.internal;

import org.springframework.modulith.ApplicationModule;