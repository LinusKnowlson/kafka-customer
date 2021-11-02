package spring.cloud.kafka.customer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.boot.CommandLineRunner;
import org.springframework.web.client.RestTemplate;

import java.util.function.Consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;

import spring.cloud.kafka.customer.models.Customer;

@SpringBootApplication
public class CustomerApplication {
	
	private static final Logger log = LoggerFactory.getLogger(CustomerApplication.class);
	//url to get info of a customer from localhost
	private static final String url = "http://localhost:8080/customers/1"; 

	public static void main(String[] args) {
		SpringApplication.run(CustomerApplication.class, args);
	}
	
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}
	
	@Bean
	public Consumer<Customer> consume() {
		return input -> log.info(input.toString());
	}
	
	@Bean
	public CommandLineRunner run(RestTemplate restTemplate, StreamBridge streamBridge) throws Exception {
		return args -> {
			Customer customer = restTemplate.getForObject(url, Customer.class);
			if(customer != null) {
				log.info(customer.toString());
			}
		};
	}
}
