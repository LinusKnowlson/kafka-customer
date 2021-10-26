package spring.cloud.kafka.customer.services;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;

import spring.cloud.kafka.customer.models.Customer;

public interface CustomerIF 
{
	public abstract CollectionModel<EntityModel<Customer>> all();
	public abstract Customer newCustomer(Customer newCustomer);
	public abstract EntityModel<Customer> one(Long id);
	public abstract Customer replaceCustomer(Customer newCustomer,Long id);
	public abstract Customer updateCustomerContact(Long id, Long contactId);
	public abstract void deleteCustomer(Long id);
}
