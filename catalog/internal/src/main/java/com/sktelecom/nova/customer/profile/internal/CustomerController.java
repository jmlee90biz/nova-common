package com.sktelecom.nova.customer.profile.internal;

import com.sktelecom.nova.customer.profile.api.CustomerDto;
import com.sktelecom.nova.customer.profile.api.CustomerProfileService;
import com.sktelecom.nova.customer.profile.api.CustomerRegistrationRequest;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping(value="/customer/profile/customers")
@Tag(name="customer-profile")
class CustomerController {
    private final CustomerProfileService customerProfileService;

    @GetMapping("/{id}")
    public CustomerDto getCustomerById(@PathVariable(name="id") UUID customerId) {
        return customerProfileService.getCustomerById(customerId);
    }

    @PostMapping
    public CustomerDto registerCustomer(@RequestBody CustomerRegistrationRequest customerRegistrationRequest) {
        return customerProfileService.registerCustomer(customerRegistrationRequest);
    }

    @GetMapping
    public List<CustomerDto> getAllCustomers(int page, int size) {
        return customerProfileService.findAllCustomers(page, size);
    }


}
