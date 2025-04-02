package com.sktelecom.nova.customer.profile.internal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
interface CustomerRepository extends JpaRepository<Customer, UUID> {
}
