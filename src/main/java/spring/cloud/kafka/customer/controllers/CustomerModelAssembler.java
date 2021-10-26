package spring.cloud.kafka.customer.controllers;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import spring.cloud.kafka.customer.models.Customer;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class CustomerModelAssembler implements
    RepresentationModelAssembler<Customer, EntityModel<Customer>> {
	//customer model assembler
    @Override
    public EntityModel<Customer> toModel(Customer customer) {

        return EntityModel.of(customer,
        linkTo(methodOn(CustomerController.class).one(customer.getId())).withSelfRel(),
        linkTo(methodOn(CustomerController.class).all()).withRel("customers"));
    }
}
