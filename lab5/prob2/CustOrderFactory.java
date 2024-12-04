package lab5.prob2;

import java.time.LocalDate;

public class CustOrderFactory {

    public static Customer createCustomer(String customerName) {
        return new Customer(customerName);
    }
    public static Order createOrder(Customer customer, LocalDate date) {
        if(customer == null) throw new NullPointerException("Null customer");
        Order order = new Order(date);
        customer.addOrder(order);
        return order;
    }

    public static Item createItem(String itemName) {
        return new Item(itemName);
    }
}
