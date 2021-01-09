package pl.michalski.restproject.employees;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    List<Employee> findAllByFirstNameAndLastName(String firstName, String lastName);
}
