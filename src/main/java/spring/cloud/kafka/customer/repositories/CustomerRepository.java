package spring.cloud.kafka.customer.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import spring.cloud.kafka.customer.models.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {}
