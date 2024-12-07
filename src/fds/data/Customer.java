package fds.data;

import fds.Menu.BaseMenu;
import fds.item.Food;
import fds.order.Orders;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Represents a customer in the food delivery service system.
 * This class extends the {@code Person} class and adds functionality specific to customers,
 * such as maintaining a balance, managing food orders, and rating delivery drivers.
 *
 * Features:
 * - Stores the customer's balance and a list of ordered food items.
 * - Provides methods to submit an order, rate a delivery driver, and display customer details.
 *
 * @author Israel Aguiniga
 * @version 11/09/2024
 */
public class Customer extends Person {

    /** The customer's current balance. */
    private double balance;

    /** The list of food items in the customer's current order. */
    private List<Food> currentOrder;

    /**
     * Constructs a new {@code Customer} object with the specified details.
     * The customer's balance is initialized to 0.0 by default, and the order list is empty.
     *
     * @param name      The customer's name.
     * @param age       The customer's age.
     * @param address   The customer's address.
     * @param phone     The customer's phone number.
     * @param email     The customer's email address.
     * @param password  The customer's password.
     */
    public Customer(String name, int age, String address, String phone, String email, String password) {
        super(name, age, address, phone, email, password);
        this.balance = 0.0;
        this.currentOrder = new ArrayList<>();
    }

    // Setters ------------------------------------------------------------------

    /**
     * Updates the customer's balance.
     *
     * @param balance The new balance to set.
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }

    // Getters ------------------------------------------------------------------

    /**
     * Retrieves the customer's current balance.
     *
     * @return The customer's balance.
     */
    public double getBalance() {
        return balance;
    }

    // Methods ------------------------------------------------------------------

    /**
     * Displays the customer's details, including their balance.
     */
    @Override
    public void showDetails() {
        super.showDetails();
        System.out.println("Balance: " + balance);
    }

    /**
     * Builds an order for the customer by selecting items from a given menu.
     * The customer can choose items by their index, and the order is finalized once they input -1.
     *
     * @param menu The menu from which the customer can select food items.
     * @return The finalized {@code Orders} object.
     */
    public Orders buildOrder(BaseMenu menu) {
        Orders customerOrder = new Orders(this, "", 0);
        menu.printMenu();
        System.out.println("Type in which items you would like, one at a time.");
        System.out.println("Type -1 when you are finished.");

        Scanner scanner = new Scanner(System.in);
        int menuItemIndex = scanner.nextInt();

        while (menuItemIndex != -1) {
            customerOrder.addToOrder(menu.getItem(menuItemIndex));
            menuItemIndex = scanner.nextInt();
        }

        customerOrder.calculateTotal();
        return customerOrder;
    }

    /**
     * Rates a delivery driver based on the customer's experience.
     * The rating must be between 1.0 and 5.0.
     *
     * @param driver The delivery driver to rate.
     * @param rating The rating value, between 1.0 and 5.0.
     */
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
