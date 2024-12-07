package fds.data;

import fds.order.Orders;

/**
 * Represents a delivery driver in the food delivery service system.
 * This class extends the {@code Person} class and adds specific attributes and methods
 * for handling delivery operations, such as managing ratings, earnings, and availability.
 *
 * Features:
 * - Tracks the driver's rating, total earnings, availability status, and assigned orders.
 * - Provides methods for updating ratings, assigning orders, processing deliveries, and displaying driver details.
 *
 * @version 11/09/2024
 * @author Israel Aguiniga
 */
public class DeliveryDriver extends Person {

    /** The driver's overall rating, averaged from customer ratings. */
    private double rating;

    /** The total amount of money earned by the driver. */
    private double totalEarnings;

    /** Indicates whether the driver is available for a new order. */
    private boolean isAvailable;

    /** The total number of ratings received by the driver. */
    private int ratingCount;

    /** The current order assigned to the driver. */
    private Orders currentOrder;

    /**
     * Constructs a new {@code DeliveryDriver} object with the specified personal details.
     * By default, the driver is available, with an initial rating of 0.0 and no earnings.
     *
     * @param name      The driver's name.
     * @param age       The driver's age.
     * @param address   The driver's address.
     * @param phone     The driver's phone number.
     * @param email     The driver's email address.
     * @param password  The driver's password.
     */
    public DeliveryDriver(String name, int age, String address, String phone, String email, String password) {
        super(name, age, address, phone, email, password);
        this.isAvailable = true;
        this.rating = 0.0;
        this.totalEarnings = 0.0;
    }

    // Setters ------------------------------------------------------------------

    /**
     * Updates the driver's overall rating.
     *
     * @param rating The new rating to set.
     */
    public void setRating(double rating) {
        this.rating = rating;
    }

    /**
     * Sets the driver's total earnings.
     *
     * @param totalEarnings The total money earned by the driver.
     */
    public void setTotalEarnings(double totalEarnings) {
        this.totalEarnings = totalEarnings;
    }

    /**
     * Updates the driver's availability status.
     *
     * @param available {@code true} if the driver is available; {@code false} otherwise.
     */
    public void setAvailable(boolean available) {
        this.isAvailable = available;
    }

    /**
     * Sets the current order assigned to the driver.
     *
     * @param currentOrder The order assigned to the driver.
     */
    public void setOrder(Orders currentOrder) {
        this.currentOrder = currentOrder;
    }

    // Getters ------------------------------------------------------------------

    /**
     * Retrieves the driver's current rating.
     *
     * @return The driver's rating.
     */
    public double getRating() {
        return rating;
    }

    /**
     * Retrieves the total money earned by the driver.
     *
     * @return The driver's total earnings.
     */
    public double getTotalEarnings() {
        return totalEarnings;
    }

    /**
     * Checks if the driver is available for a new order.
     *
     * @return {@code true} if the driver is available; {@code false} otherwise.
     */
    public boolean isAvailable() {
        return isAvailable;
    }

    /**
     * Retrieves the current order assigned to the driver.
     *
     * @return The assigned {@code Orders} object.
     */
    public Orders getOrder() {
        return currentOrder;
    }

    // Methods ------------------------------------------------------------------

    /**
     * Displays the delivery driver's details, including rating, total earnings, and availability.
     */
    @Override
    public void showDetails() {
        super.showDetails();
        System.out.println("Rating: " + rating);
        System.out.println("Total Earnings: $" + totalEarnings);
        System.out.println("Available: " + isAvailable);
    }

    /**
     * Updates the driver's rating based on a new customer rating.
     * The overall rating is recalculated as a weighted average.
     *
     * @param newRating The new rating provided by a customer (1.0 to 5.0).
     */
    public void updateRating(double newRating) {
        rating = ((rating * ratingCount) + newRating) / (++ratingCount);
    }

    /**
     * Assigns the driver to an order if they are available and processes the order.
     *
     * @param customer     The customer associated with the order.
     * @param orderAmount  The total amount of the order.
     */
    public void assignToOrder(Customer customer, double orderAmount) {
        if (isAvailable) {
            isAvailable = false;
            System.out.println("Driver assigned to order for customer: " + customer.getName());
            processOrder(orderAmount);
        } else {
            System.out.println("Driver is not available");
        }
    }

    /**
     * Processes an order by adding its amount to the driver's total earnings and making them available again.
     *
     * @param orderAmount The total amount of the order to process.
     */
    public void processOrder(double orderAmount) {
        this.totalEarnings += orderAmount;
        this.isAvailable = true;
        System.out.println("Order processed. Total earnings: $" + this.totalEarnings);
    }

    /**
     * Identifies the object as a delivery driver.
     *
     * @return {@code true}, indicating this object is a delivery driver.
     */
    public boolean isDeliveryDriver() {
        return true;
    }
}
