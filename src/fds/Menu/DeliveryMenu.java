package fds.Menu;

import fds.data.DeliveryDriver;
import fds.data.Person;
import fds.item.Food;
import fds.order.Orders;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Represents a specialized menu for delivery orders in the food delivery service.
 *
 * Features:
 * - Manages a queue of delivery drivers and processes delivery-specific orders.
 * - Ensures address validation before confirming an order.
 * - Inherits functionality from {@code BaseMenu} and extends it with delivery-specific behavior.
 *
 * @brief Delivery-specific menu system.
 * @author Jacob Rossel
 * @version 1.0
 * @since 2024-12-07
 */
public class DeliveryMenu extends BaseMenu {

    /** A queue to manage the delivery drivers available for assigning orders. */
    private Queue<DeliveryDriver> driverQueue = new LinkedList<>();

    /**
     * Constructs a new {@code DeliveryMenu} with a specified list of food items.
     *
     * @param menuItems A list of {@code Food} items to initialize the delivery menu.
     */
    public DeliveryMenu(ArrayList<Food> menuItems) {
        super(menuItems);
    }

    /**
     * Default constructor for {@code DeliveryMenu}, initializing an empty menu and driver queue.
     */
    public DeliveryMenu() {
        super();
    }

    /**
     * Confirms an order after validating the delivery address.
     * If the address is incorrect, prompts the customer to update it before placing the order.
     *
     * @param newOrder The {@code Orders} object to be confirmed and added to the queue.
     */
    @Override
    public void confirmOrder(Orders newOrder) {
        System.out.println("Is this still the correct address: " + newOrder.getCustomer().getAddress() + "?");

        Scanner sc = new Scanner(System.in); // Scanner for user input
        String response = sc.nextLine().trim().toLowerCase();

        if (response.equals("yes")) {
            orderQueue.add(newOrder);
            System.out.println("Order has been placed!");
            newOrder.setStatus("Placed");
        } else {
            System.out.println("Please update your address:");
            String newAddress = sc.nextLine();
            newOrder.getCustomer().setAddress(newAddress);
            orderQueue.add(newOrder);
            System.out.println("Order has been placed!");
            newOrder.setStatus("Placed");
        }
    }

    /**
     * Prints the menu items along with their prices, formatted in a clear and readable way.
     */
    @Override
    public void printMenu() {
        System.out.println(getCuisineType() + " Menu");
        System.out.println("====");

        for (int i = 1; i <= menuItems.size(); i++) {
            System.out.printf("%d. %-30s : $%.2f%n", i, menuItems.get(i - 1).getName(), menuItems.get(i - 1).getPrice());
        }
    }

    /**
     * Builds an order for a given person. This method is currently not implemented.
     *
     * @param customer The {@code Person} object representing the customer placing the order.
     */
    public void buildOrder(Person customer) {
        // Implementation to be added as required
    }

    /**
     * Indicates whether this menu is for a delivery service.
     *
     * @return {@code true}, as this menu is specifically for delivery orders.
     */
    @Override
    public boolean isDelivery() {
        return true;
    }
}
