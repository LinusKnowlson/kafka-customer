package spring.cloud.kafka.customer.controllers;

@SuppressWarnings("serial")
public class CustomerNotFoundException extends RuntimeException {
	//return error message when cannot find customer id
    public CustomerNotFoundException(Long id) {
        super("Customer " + id + " cannot be found.");
    }
}
