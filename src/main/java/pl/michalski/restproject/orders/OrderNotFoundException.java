package pl.michalski.restproject.orders;


public class OrderNotFoundException extends RuntimeException {
    public OrderNotFoundException(Long id) {
        super("Nie znaleziono zamówienia o id: " + id);

    }
}
