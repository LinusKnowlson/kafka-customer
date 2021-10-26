package spring.cloud.kafka.customer.services;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import spring.cloud.kafka.customer.controllers.ContactModelAssembler;
import spring.cloud.kafka.customer.controllers.ContactNotFoundException;
import spring.cloud.kafka.customer.models.Contact;
import spring.cloud.kafka.customer.repositories.ContactRepository;
@Service
public class ContactService implements ContactIF
{
	private final ContactRepository repository;
    private final ContactModelAssembler assembler;
    
    //constructor of the contact service
    public ContactService(ContactRepository repository, ContactModelAssembler assembler) {
        this.repository = repository;
        this.assembler = assembler;
    }
    
	@Override
	public CollectionModel<EntityModel<Contact>> all() {
		// TODO Auto-generated method stub
		 List<EntityModel<Contact>> contacts = repository.findAll().stream() 
	                .map(assembler::toModel) 
	                .collect(Collectors.toList());
	        return CollectionModel.of(contacts, linkTo(methodOn(ContactService.class).all()).withSelfRel());
	}

	@Override
	public ResponseEntity<?> newContact(Contact newContact) {
		// TODO Auto-generated method stub
		EntityModel<Contact> entityModel = assembler.toModel(repository.save(newContact));
        return ResponseEntity 
                .created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri()) 
                .body(entityModel);
	}

	@Override
	public EntityModel<Contact> one(Long id) {
		// TODO Auto-generated method stub
		Contact contact = repository.findById(id) 
                .orElseThrow(() -> new ContactNotFoundException(id));
        return assembler.toModel(contact);
	}

	@Override
	public ResponseEntity<?> replaceContact(Contact newContact, Long id) {
		// TODO Auto-generated method stub
		Contact updatedContact = repository.findById(id) 
                .map(contact -> {
                    contact.setName(newContact.getName());
                    contact.setPhone(newContact.getPhone());
                    contact.setPosition(newContact.getPosition());
                    contact.setEmail(newContact.getEmail());
                    return repository.save(contact);
                }) 
                .orElseGet(() -> {
                    newContact.setId(id);
                    return repository.save(newContact);
                });

        EntityModel<Contact> entityModel = assembler.toModel(updatedContact);

        return ResponseEntity 
                .created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri()) 
                .body(entityModel);
	}

	@Override
	public ResponseEntity<?> deleteContact(Long id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
        return ResponseEntity.noContent().build();
	}
	
}
