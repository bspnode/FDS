package fds.data;
//java doc for the class
/**
 * Customer class is a subclass of Person class. It represents a customer for the food delivery service.
 * The class contains an instance variable for the customer's balance and a list of food items in the order.
 * The class contains methods to submit an order, rate an order, and show the customer's details.
 * The class also contains a constructor to create a new customer object.
 * @brief Customer class for the food delivery service
 * @author ISRAEL AGUINIGA
 */

import fds.item.Food;

import java.util.ArrayList;
import java.util.List;

public class Customer extends Person {

    private double balance;
    public List<Food> order;


    //constructor
    public Customer(String name,int age, String address, String phone , String email, String password) {
        super(name,age,  address, phone , email, password);
        this.balance = 0.0; //customer balance is 0 by default
        this.order = new ArrayList<>();

    }
    //setters--------------------------------------------------------------------
    public void setBalance(double balance) {
        this.balance = balance;
    }
    //getters--------------------------------------------------------------------
    public double getBalance() {
        return balance;
    }
    //show details method
    @Override
    public void showDetails() {
        super.showDetails();
        System.out.println("Balance: " + balance);
    }




    //submitOrder method - submits an order for the customer
    public void submitOrder(List<Food> order) {
        if (order == null || order.isEmpty()) {
            System.out.println("Order is empty. Please add items to your order.");
            return;
        }

        double totalCost = 0.0;
        for (Food item : order) {
            totalCost += item.getPrice();
        }

        if (totalCost > balance) {
            System.out.println("Insufficient balance. Please add funds to your account.");
            return;
        }

        balance -= totalCost;
        System.out.println("Order submitted successfully. Total cost: $" + totalCost);
    }

    //rateOrder method - rates the delivery driver and food
    public void rateOrder(DeliveryDriver driver, double rating) {
        if (rating < 1.0 || rating > 5.0) {
            System.out.println("Invalid rating. Please provide a rating between 1 and 5.");
        } else {
            driver.updateRating(rating);
            System.out.println("Order rated with: " + rating + " for driver: " + driver.getName());
            System.out.println("Driver's new rating: " + driver.getRating());
        }
    }


}
