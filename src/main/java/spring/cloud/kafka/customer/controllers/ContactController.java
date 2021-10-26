package spring.cloud.kafka.customer.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import spring.cloud.kafka.customer.models.*;
import spring.cloud.kafka.customer.services.ContactService;

@RestController
public class ContactController {

	@Autowired
	ContactService contactService;
    
    //find all contacts
    @GetMapping("/contacts")
    CollectionModel<EntityModel<Contact>> all() {
    	return contactService.all();
    }
    //create new contact
    @PostMapping("/contacts")
    ResponseEntity<?> newContact(@RequestBody Contact newContact) {
    	return contactService.newContact(newContact);
    }
    //find contact by id
    @GetMapping("/contacts/{id}")
    EntityModel<Contact> one(@PathVariable Long id) {
    	return contactService.one(id);
    }
    //update contact by id
    @PutMapping("/contacts/{id}")
    ResponseEntity<?> replaceContact(@RequestBody Contact newContact, @PathVariable Long id) {
    	return contactService.replaceContact(newContact, id);
    }
    //delete contact by id
    @DeleteMapping("/contacts/{id}")
    ResponseEntity<?> deleteContact(@PathVariable Long id) {
    	return contactService.deleteContact(id);
    }
}