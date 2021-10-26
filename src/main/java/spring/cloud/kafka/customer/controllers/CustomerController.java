package spring.cloud.kafka.customer.controllers;

import spring.cloud.kafka.customer.models.*;
import spring.cloud.kafka.customer.services.CustomerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.*;

@RestController
public class CustomerController {
	
	@Autowired
	CustomerService customerService;
	
    //find all the customers
    @GetMapping("/customers")
    CollectionModel<EntityModel<Customer>> all() {
    	return customerService.all();
    }
    //create new customer
    @PostMapping("/customers")
    Customer newCustomer(@RequestBody Customer newCustomer) {
        return customerService.newCustomer(newCustomer);
    }
    //find data by id
    @GetMapping("/customers/{id}")
    EntityModel<Customer> one(@PathVariable Long id) {
    	return customerService.one(id);
    }
    //update customer
    @PutMapping("/customers/{id}")
    Customer replaceCustomer(@RequestBody Customer newCustomer,
                             @PathVariable Long id) {
        return customerService.replaceCustomer(newCustomer, id);
    }
    //update customer and contact by customer id and contact id
  	@PutMapping("/customers/{id}/contact/{contactId}")
    Customer updateCustomerContact(@PathVariable Long id, @PathVariable Long contactId) {
  		return customerService.replaceCustomer(null, contactId);
    }
  	//delete customer record
    @DeleteMapping("/customers/{id}")
    void deleteCustomer(@PathVariable Long id) {
    	customerService.deleteCustomer(id);
    }
}
