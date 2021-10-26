package spring.cloud.kafka.customer.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import spring.cloud.kafka.customer.models.Contact;

public interface ContactRepository extends JpaRepository<Contact, Long> {}