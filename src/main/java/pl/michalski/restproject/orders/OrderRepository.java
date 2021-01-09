package pl.michalski.restproject.orders;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface OrderRepository extends JpaRepository<Order, Long> {
    Optional<Order> findByCustomer_CustomerUuid(UUID uuid);
}
