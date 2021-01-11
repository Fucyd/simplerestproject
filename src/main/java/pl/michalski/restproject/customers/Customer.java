package pl.michalski.restproject.customers;


import pl.michalski.restproject.orders.Order;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Entity
public class Customer {

    private @Id @GeneratedValue Long id;
    private String name;
    private String lastName;
    private UUID customerUuid;

    @OneToMany(mappedBy = "customer")
    private List<Order> order;

    public Customer() {
    }

    public Customer(String name, String lastName, UUID customerUuid) {
        this.name = name;
        this.lastName = lastName;
        this.customerUuid = customerUuid;
    }

    public List<Order> getOrder() {
        return order;
    }

    public void setOrder(List<Order> order) {
        this.order = order;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public UUID getCustomerUuid() {
        return customerUuid;
    }

    public void setCustomerUuid(UUID customerUuid) {
        this.customerUuid = customerUuid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(id, customer.id) && Objects.equals(name, customer.name) && Objects.equals(lastName, customer.lastName) && Objects.equals(customerUuid, customer.customerUuid) && Objects.equals(order, customer.order);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, lastName, customerUuid, order);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", customerUuid=" + customerUuid +
                ", order=" + order +
                '}';
    }
}
