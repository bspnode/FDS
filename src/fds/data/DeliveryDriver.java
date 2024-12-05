package fds.data;


import fds.order.Orders;

/**
 * DeliveryDriver class is a subclass of Person class. It represents a delivery driver for the food delivery service.
 * The class contains instance variables for the driver's rating, money earned, availability, and rating count.
 * The class contains methods to update the driver's rating, assign the driver to an order, and process an order.
 * The class also contains a showDetails method to display the driver's information
 * @author ISRAEL AGUINIGA
 *
 *
 */
public class DeliveryDriver extends Person{

    double rating;
    double moneyEarned;
    boolean isAvailable;
    int ratingCount;
    Orders order;





    public DeliveryDriver(String name,int age, String address, String phone, String email, String password) {
        super( name, age, address, phone, email, password);
        this.isAvailable = true;//driver is available by default
        this.rating = 0.0; //driver rating is 0 by default
        this.moneyEarned = 0.0; //driver has earned 0 money by default
    }
    //setters--------------------------------------------------------------------
    public void setRating(double rating) {
        this.rating = rating;
    }
    public void setMoneyEarned(double moneyEarned) {
        this.moneyEarned = moneyEarned;
    }
    public void setAvailable(boolean available) {
        isAvailable = available;
    }
    //getters--------------------------------------------------------------------
    public double getRating() {
        return rating;
    }
    public double getMoneyEarned() {
        return moneyEarned;
    }
    public boolean isAvailable() {
        return isAvailable;
    }
    //show details method
    @Override
    public void showDetails() {
        super.showDetails();
        System.out.println("Rating: " + rating);
        System.out.println("Money earned: " + moneyEarned);
        System.out.println("Available: " + isAvailable);
    }
//updateRating method - updates the driver's rating
    public void updateRating(double newRating) {
        rating = ((rating * ratingCount) + newRating) / (++ratingCount);
    }

    public void assignToOrder(Customer customer, double orderAmount) {
        if (isAvailable) {
            isAvailable = false;
            System.out.println("Driver assigned to order for customer: " + customer.getName());
            processOrder(orderAmount);
        } else {
            System.out.println("Driver is not available");
        }
    }
    //processOrder method
    public void processOrder(double orderAmount) {
        this.moneyEarned += orderAmount;
        this.isAvailable = true;
        System.out.println("Order processed. Total earnings: " + this.moneyEarned);
    }

    public boolean isDeliveryDriver()
    {
        return true;
    }


    public void setOrder(Orders order) {
        this.order = order;
    }

    public Orders getOrder() {
        return order;
    }

}
