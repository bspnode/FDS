package fds.Menu;

import fds.item.Food;
import fds.order.Orders;

import java.util.ArrayList;

/**
 * Represents a menu system for standard (non-delivery) orders in the food delivery service.
 *
 * Features:
 * - Allows customers to browse and place orders from a menu of food items.
 * - Manages orders in a queue and updates their status upon confirmation.
 *
 * @brief Standard order menu system.
 * @author Jacob Rossel
 * @version 1.0
 * @since 2024-12-07
 */
public class OrderMenu extends BaseMenu {

    /**
     * Constructs a new {@code OrderMenu} with a specified list of food items.
     *
     * @param menuItems A list of {@code Food} items to initialize the order menu.
     */
    public OrderMenu(ArrayList<Food> menuItems) {
        super(menuItems);
    }

    /**
     * Default constructor for {@code OrderMenu}, initializing an empty menu and order queue.
     */
    public OrderMenu() {
        super();
    }

    /**
     * Confirms a new order by adding it to the order queue and updating its status.
     *
     * @param newOrder The {@code Orders} object to be confirmed and added to the queue.
     */
    @Override
    public void confirmOrder(Orders newOrder) {
        orderQueue.add(newOrder); // Add the new order to the queue
        System.out.println("Order has been placed!"); // Output confirmation
        newOrder.setStatus("Placed"); // Set the order status to "Placed"
    }

    /**
     * Prints the menu items along with their prices, formatted in a clear and readable way.
     */
    @Override
    public void printMenu() {
        System.out.println(getCuisineType() + " Menu");
        System.out.println("====");

        for (int i = 1; i <= menuItems.size(); i++) {
            // Print the item number, name, and price
            System.out.printf("%d. %-30s : $%.2f%n", i, menuItems.get(i - 1).getName(), menuItems.get(i - 1).getPrice());
        }
    }
}
