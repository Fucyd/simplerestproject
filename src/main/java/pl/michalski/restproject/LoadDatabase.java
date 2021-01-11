package pl.michalski.restproject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.michalski.restproject.customers.Customer;
import pl.michalski.restproject.customers.CustomerRepository;
import pl.michalski.restproject.employees.Employee;
import pl.michalski.restproject.employees.EmployeeRepository;
import pl.michalski.restproject.orders.Order;
import pl.michalski.restproject.orders.OrderRepository;
import pl.michalski.restproject.orders.Status;

import java.util.UUID;

@Configuration
public class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(EmployeeRepository employeeRepository,
                                   OrderRepository orderRepository,
                                   CustomerRepository customerRepository) {
        return args -> {
            employeeRepository.save(new Employee("Bilbo", "Baggins", "burglar"));
            employeeRepository.save(new Employee("Frodo", "Baggins", "thief"));


            orderRepository.save(new Order("MacBook Pro", Status.COMPLETED));
            orderRepository.save(new Order("iPhone", Status.IN_PROGRESS));

            customerRepository.save(new Customer("Bob", "Hofman", UUID.randomUUID()));
            customerRepository.save(new Customer("John", "Fredrick", UUID.randomUUID()));
            customerRepository.save(new Customer("Miami", "Beach", UUID.randomUUID()));
        };
    }
}
