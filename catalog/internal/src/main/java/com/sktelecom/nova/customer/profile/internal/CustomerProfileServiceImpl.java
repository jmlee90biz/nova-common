package com.sktelecom.nova.customer.profile.internal;

import com.sktelecom.nova.customer.profile.api.CustomerDto;
import com.sktelecom.nova.customer.profile.api.CustomerProfileService;
import com.sktelecom.nova.customer.profile.api.CustomerRegistrationRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
class CustomerProfileServiceImpl implements CustomerProfileService {
    private final CustomerRepository customerRepository;
    //private final EventPublisher eventPublisher;
    private final ApplicationEventPublisher eventPublisher;


    @Override
    @Transactional
    public CustomerDto registerCustomer(CustomerRegistrationRequest customerRegistrationRequest) {
        Customer registeredCustomer = customerRepository.save(
                Customer.createCustomer(customerRegistrationRequest.name(), customerRegistrationRequest.email())
        );

        eventPublisher.publishEvent(registeredCustomer.createCustomerRegisteredEvent());
    //    eventPublisher.publish(registeredCustomer.createCustomerRegisteredEvent());

//        if(true) {
//            throw new RuntimeException("TRANSACTION TEST");
//        }
        return CustomerMapper.toCustomerDto(registeredCustomer);
    }

    @Override
    public CustomerDto getCustomerById(UUID customerId) {
        return customerRepository.findById(customerId).map(CustomerMapper::toCustomerDto)
                .orElseThrow(()->new RuntimeException("Customer not found"));
    }

    @Override
    public List<CustomerDto> findAllCustomers(int page, int size) {
        return customerRepository.findAll(PageRequest.of(page, size)).stream().map(CustomerMapper::toCustomerDto).toList();
    }
}
