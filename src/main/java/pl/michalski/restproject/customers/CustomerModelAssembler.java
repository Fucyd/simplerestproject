package pl.michalski.restproject.customers;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class CustomerModelAssembler implements RepresentationModelAssembler<Customer, EntityModel<Customer>> {

    @Override
    public EntityModel<Customer> toModel(Customer entity) {
        EntityModel<Customer> customerModel = EntityModel.of(entity,
                linkTo(methodOn(CustomerController.class).oneCustomerById(entity.getId())).withSelfRel(),
                linkTo(methodOn(CustomerController.class).allCustomers()).withRel("customers"));
        return customerModel;
    }
}
