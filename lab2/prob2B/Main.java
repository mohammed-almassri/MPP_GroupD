
package prob2B;
public class Main {
    public static void main(String[] args) {
        Order order = new Order("Order1");
        OrderLine orderLine1 = new OrderLine(order);
        OrderLine orderLine2 = new OrderLine(order);

        order.addOrderLine(orderLine1);
        order.addOrderLine(orderLine2);

        System.out.println("Order Number: " + order.getOrderNumber());
        System.out.println("Order Lines: " + order.getOrderLines().size());
    }
}