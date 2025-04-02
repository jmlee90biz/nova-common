package com.sktelecom.nova.customer.profile.internal;

import com.sktelecom.nova.customer.profile.api.CustomerDto;

class CustomerMapper {
    static CustomerDto toCustomerDto(Customer customer) {
        return new CustomerDto(customer.getId(), customer.getName(), customer.getEmail());
    }
}
