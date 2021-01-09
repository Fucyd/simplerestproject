package pl.michalski.restproject.customers;

public class CustomerNotFoundException extends RuntimeException {
    public CustomerNotFoundException(Long id) {
        super("Couldn't find customer with id: " + id);
    }
}
