@ApplicationModule(
        displayName = "customer-profile-internal",
        allowedDependencies = {
                "customer.profile.api",
                "customer.profile.event"
                //"common.notification::event"
        }
)
package com.sktelecom.nova.customer.profile.internal;

import org.springframework.modulith.ApplicationModule;