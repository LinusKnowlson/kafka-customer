package spring.cloud.kafka.customer.controllers;

import spring.cloud.kafka.customer.models.Contact;
import spring.cloud.kafka.customer.models.Customer;
import spring.cloud.kafka.customer.repositories.ContactRepository;
import spring.cloud.kafka.customer.repositories.CustomerRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);
    //loading database with data
    @Bean
    CommandLineRunner initDB(CustomerRepository repository,ContactRepository contactRepository) {
        return args -> { 	
        	log.info("Loading... " + repository.save(new Customer("ABC Company", "221B Baker St", "United Kingdom")));
            log.info("Loading... " + repository.save(new Customer("DEF Company", "742 Evergreen Terrace", "United States of America")));
        	log.info("Loading... " + contactRepository.save(new Contact("Mark", "Zuckerburg", "021456378", "markZuck@gmail.com", "CEO")));
            log.info("Loading... " + contactRepository.save(new Contact("Jeff", "Bezos", "049876512","jeffb@outlook.com", "President")));
        };
    }
}
