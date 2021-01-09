package pl.michalski.restproject.employees;

public class EmployeeNotFoundException extends RuntimeException {
    public EmployeeNotFoundException(Long id) {
        super("Nie znaleziono pracownika " + id);
    }

    public EmployeeNotFoundException(String firstName, String lastName) {
        super("Nie znaleziono pracownika " + firstName + " " + lastName);
    }
}
