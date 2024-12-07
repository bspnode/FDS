package fds.order;

import fds.data.Person;
import fds.item.Food;

import java.util.ArrayList;

/**
 * Represents an order in the food delivery system.
 * Each order is associated with a customer, contains a list of food items, and has details like total cost, order ID, address, and status.
 *
 * @author
 * @version 1.0
 * @since 2024-12-07
 */
public class Orders {
    // List of food items in the order
    private ArrayList<Food> foodItems;

    // Customer associated with the order
    private Person customer;

    // Total cost of the order
    private double totalCost;

    // Unique identifier for the order
    private String orderID;

    // Delivery address for the order
    private String deliveryAddress;

    // Status of the order (e.g., "Placed", "Delivered")
    private String status;

    /**
     * Constructs a new order with the specified customer, order ID, and initial total cost.
     *
     * @param customer The customer who placed the order.
     * @param orderID  A unique identifier for the order.
     * @param totalCost The initial total cost of the order.
     */
    public Orders(Person customer, String orderID, double totalCost) {
        this.foodItems = new ArrayList<>();
        this.customer = customer;
        this.orderID = orderID;
        this.totalCost = totalCost;
    }

    /**
     * Prints the details of each food item in the order.
     */
    public void printOrder() {
        for (Food food : foodItems) {
            System.out.println(food.toString());
        }
    }

    /**
     * Adds a food item to the order and updates the total cost.
     *
     * @param food The food item to add to the order.
     */
    public void addToOrder(Food food) {
        foodItems.add(food);
        totalCost += food.getPrice();
    }

    /**
     * Recalculates the total cost of the order based on the current list of food items.
     */
    public void calculateTotal() {
        totalCost = 0;
        for (Food food : foodItems) {
            totalCost += food.getPrice();
        }
    }

    // Getters and Setters

    /**
     * @return The list of food items in the order.
     */
    public ArrayList<Food> getFoodItems() {
        return foodItems;
    }

    /**
     * @return The customer who placed the order.
     */
    public Person getCustomer() {
        return customer;
    }

    /**
     * @return The total cost of the order.
     */
    public double getTotalCost() {
        return totalCost;
    }

    /**
     * @return The unique identifier for the order.
     */
    public String getOrderID() {
        return orderID;
    }

    /**
     * @return The delivery address for the order.
     */
    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    /**
     * Updates the delivery address for the order.
     *
     * @param deliveryAddress The new delivery address.
     */
    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    /**
     * @return The current status of the order.
     */
    public String getStatus() {
        return status;
    }

    /**
     * Updates the status of the order.
     *
     * @param status The new status of the order (e.g., "Placed", "Delivered").
     */
    public void setStatus(String status) {
        this.status = status;
    }

    public String getTotal() {
        return "" + totalCost;
    }
}
