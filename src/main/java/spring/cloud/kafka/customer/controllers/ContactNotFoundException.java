package spring.cloud.kafka.customer.controllers;

@SuppressWarnings("serial")
public class ContactNotFoundException extends RuntimeException {
	//return error message when cannot find contact id
    public ContactNotFoundException(Long id) {
        super("Could not find contact " + id);
    }
}