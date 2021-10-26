package spring.cloud.kafka.customer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.function.Consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;

import spring.cloud.kafka.customer.models.Customer;

@SpringBootApplication
public class CustomerApplication {
	
	private static final Logger log = LoggerFactory.getLogger(CustomerApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(CustomerApplication.class, args);
	}
	
	@Bean
	public Consumer<Customer> consume() {
		return input -> log.info(input.toString());
	}

}
