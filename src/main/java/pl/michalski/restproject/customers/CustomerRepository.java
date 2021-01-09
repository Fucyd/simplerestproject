package pl.michalski.restproject.customers;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.michalski.restproject.orders.Order;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Optional<Customer> findByOrder_Id(Long id);
}
