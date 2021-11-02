package spring.cloud.kafka.customer.services;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.stereotype.Service;

import spring.cloud.kafka.customer.controllers.CustomerModelAssembler;
import spring.cloud.kafka.customer.controllers.CustomerNotFoundException;
import spring.cloud.kafka.customer.models.Customer;
import spring.cloud.kafka.customer.repositories.CustomerRepository;
@Service
public class CustomerService implements CustomerIF
{
	private final CustomerRepository repository;
    private final CustomerModelAssembler assembler;
    
    public CustomerService(CustomerRepository repository, CustomerModelAssembler assembler) 
    {
    	this.repository = repository;
        this.assembler = assembler;
    }
    
	@Override
	public CollectionModel<EntityModel<Customer>> all() {
		// TODO Auto-generated method stub
		List<EntityModel<Customer>> customers = repository.findAll().stream()
	            .map(assembler::toModel)
	            .collect(Collectors.toList());
	        return CollectionModel.of(customers,
	        linkTo(methodOn(CustomerService.class).all()).withSelfRel());
	}

	@Override
	public Customer newCustomer(Customer newCustomer) {
		// TODO Auto-generated method stub
		return repository.save(newCustomer);
	}

	@Override
	public EntityModel<Customer> one(Long id) {
		// TODO Auto-generated method stub
		Customer customer = repository.findById(id)
	            .orElseThrow(() -> new CustomerNotFoundException(id));
	        return assembler.toModel(customer);
	}

	@Override
	public Customer replaceCustomer(Customer newCustomer, Long id) {
		// TODO Auto-generated method stub
		return repository.findById(id)
                .map(customer -> {
                    customer.setCompanyName(newCustomer.getCompanyName());
                    customer.setAddress(newCustomer.getAddress());
                    customer.setCountry(newCustomer.getCountry());
                    return repository.save(customer);
                })
                .orElseGet(() -> {
                    newCustomer.setId(id);
                    return repository.save(newCustomer);
                });
	}

	@Override
	public void deleteCustomer(Long id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
	}

	@Override
	public Customer updateCustomerContact(Long id, Long contactId) {
		// TODO Auto-generated method stub
		Customer customer = repository.findById(id).orElseThrow(RuntimeException::new);
        customer.setContact(contactId);
        return repository.save(customer);
	}
}
