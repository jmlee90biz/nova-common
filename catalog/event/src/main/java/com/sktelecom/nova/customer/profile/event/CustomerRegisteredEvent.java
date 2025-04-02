package com.sktelecom.nova.customer.profile.event;

import java.util.UUID;

public record CustomerRegisteredEvent(UUID id, String name, String email) {
}
