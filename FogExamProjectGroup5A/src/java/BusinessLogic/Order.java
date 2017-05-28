
package BusinessLogic;

/**
 * Holds the order objects,
 * under construction.
 * 
 * @author Kasper and Anton
 */
public class Order {
    
    private String customerEmail;
    private String orderDetails;

    public Order(String customerEmail, String orderDetails) {
        this.customerEmail = customerEmail;
        this.orderDetails = orderDetails;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public String getOrderDetails() {
        return orderDetails;
    }
    
    
    
}
