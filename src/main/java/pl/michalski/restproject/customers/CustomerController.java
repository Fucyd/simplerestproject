package pl.michalski.restproject.customers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class CustomerController {
    private CustomerRepository customerRepository;
    private CustomerModelAssembler customerModelAssembler;
    @Autowired
    public CustomerController(CustomerRepository customerRepository, CustomerModelAssembler customerModelAssembler) {
        this.customerRepository = customerRepository;
        this.customerModelAssembler = customerModelAssembler;
    }


    @GetMapping("/customers")
    public CollectionModel<EntityModel<Customer>> allCustomers(){
        List<EntityModel<Customer>> customers = customerRepository.findAll().stream()
                .map(customerModelAssembler::toModel)
                .collect(Collectors.toList());
        return CollectionModel.of(customers,
                linkTo(methodOn(CustomerController.class).allCustomers()).withSelfRel());
    }

    @GetMapping("/customers/{id}")
    public EntityModel<?> oneCustomerById(@PathVariable Long id) {
            Customer customer = customerRepository.findById(id)
                    .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,
                            "Customer Not Found", new CustomerNotFoundException(id)));


        return customerModelAssembler.toModel(customer);
    }
}
