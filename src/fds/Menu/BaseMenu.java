package fds.Menu;

import fds.item.Food; // Importing the Food class
import fds.order.Orders; // Importing the Orders class

import java.util.LinkedList; // Importing LinkedList for queue implementation
import java.util.Queue; // Importing the Queue interface
import java.util.ArrayList; // Importing ArrayList for menu items storage

/**
 * Represents the base class for menu systems in the food delivery service.
 *
 * Features:
 * - Manages a list of menu items and a queue of orders to be processed.
 * - Provides methods for confirming orders, retrieving menu items, and managing the order queue.
 * - Can be extended by specific menu types to implement specialized behavior.
 *
 * @author Jacob Rossel
 * @version 1.0
 * @since 2024-12-07
 */
public abstract class BaseMenu {

    /** A queue to hold orders that need to be processed. */
    protected Queue<Orders> orderQueue;

    /** A list to hold the food items available on the menu. */
    protected ArrayList<Food> menuItems;

    /** The type of cuisine represented by this menu. */
    protected String cuisineType;

    /**
     * Constructs a new {@code BaseMenu} with a specified list of menu items.
     *
     * @param menuItems A list of {@code Food} items to initialize the menu.
     */
    public BaseMenu(ArrayList<Food> menuItems) {
        this.menuItems = menuItems;
        this.orderQueue = new LinkedList<>();
    }

    /**
     * Default constructor for {@code BaseMenu}, initializing empty menu and order queue.
     */
    public BaseMenu() {
        this.menuItems = new ArrayList<>();
        this.orderQueue = new LinkedList<>();
    }

    /**
     * Adds a new order to the order queue for processing.
     *
     * @param newOrder The new {@code Orders} object to add to the queue.
     */
    public void confirmOrder(Orders newOrder) {
        orderQueue.add(newOrder);
    }

    /**
     * Prints the menu items. Implementation should be provided by subclasses.
     */
    public abstract void printMenu();

    /**
     * Retrieves a food item by its index on the menu.
     *
     * @param index The index of the food item (1-based).
     * @return The {@code Food} object at the specified index.
     * @throws IndexOutOfBoundsException if the index is invalid.
     */
    public Food getItem(int index) {
        return menuItems.get(index - 1); // Adjust for 1-based index
    }

    /**
     * Sets the cuisine type for this menu.
     *
     * @param cuisineType A {@code String} representing the cuisine type.
     */
    public void setCuisineType(String cuisineType) {
        this.cuisineType = cuisineType;
    }

    /**
     * Retrieves the cuisine type of this menu.
     *
     * @return A {@code String} representing the cuisine type.
     */
    public String getCuisineType() {
        return cuisineType;
    }

    /**
     * Adds a new food item to the menu.
     *
     * @param food The {@code Food} item to add to the menu.
     */
    public void addFood(Food food) {
        menuItems.add(food);
    }

    /**
     * Adds a new order to the order queue.
     *
     * @param order The {@code Orders} object to add to the queue.
     */
    public void addToQueue(Orders order) {
        orderQueue.add(order);
    }

    /**
     * Prints all orders currently in the queue.
     */
    public void printQueue() {
        for (Orders order : orderQueue) {
            System.out.println(order);
        }
    }

    /**
     * Indicates whether the menu is for a delivery service.
     *
     * @return {@code false} by default; subclasses can override this behavior.
     */
    public boolean isDelivery() {
        return false;
    }

    /**
     * Retrieves and removes the next order in the queue.
     *
     * @return The next {@code Orders} object in the queue, or {@code null} if the queue is empty.
     */
    public Orders pullOrder() {
        if (orderQueue.isEmpty()) {
            System.out.println("There are currently no orders in the queue.");
            return null;
        }
        return orderQueue.poll();
    }
}
