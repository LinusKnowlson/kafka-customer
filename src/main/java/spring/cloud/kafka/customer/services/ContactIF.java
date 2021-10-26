package spring.cloud.kafka.customer.services;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;

import spring.cloud.kafka.customer.models.Contact;

public interface ContactIF 
{
	public abstract CollectionModel<EntityModel<Contact>> all();
	public abstract ResponseEntity<?> newContact(Contact newContact);
	public abstract EntityModel<Contact> one(Long id);
	public abstract ResponseEntity<?> replaceContact(Contact newContact,Long id);
	public abstract ResponseEntity<?> deleteContact(Long id);
}
