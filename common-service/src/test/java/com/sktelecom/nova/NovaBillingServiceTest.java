package com.sktelecom.nova;

import org.junit.jupiter.api.Test;
import org.springframework.modulith.core.ApplicationModules;
import org.springframework.modulith.test.ApplicationModuleTest;

@ApplicationModuleTest(ApplicationModuleTest.BootstrapMode.ALL_DEPENDENCIES)
public class NovaBillingServiceTest {
    @Test
    void contextLoads() {
        ApplicationModules modules = ApplicationModules.of(NovaBillingService.class);

        modules.forEach(System.out::println);

        //modules.verify();
    }
}
