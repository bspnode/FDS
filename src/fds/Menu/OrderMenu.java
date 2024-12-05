package fds.Menu;

import fds.item.Food;
import fds.order.Orders;

import java.util.ArrayList;

public class OrderMenu extends BaseMenu {

    // Constructor to initialize OrderMenu with a list of Food items
    public OrderMenu(ArrayList<Food> menuItems) {
        super(menuItems);
    }

    public OrderMenu() {
        super();
    }

    // Method to confirm a new order by adding it to the order queue
    public void confirmOrder(Orders newOrder)
    {
        // Add the new order to the order queue
        orderQueue.add(newOrder);

        // Output a confirmation message
        System.out.println("Order has been placed!");

        // Set the status of the new order to "Placed"
        newOrder.setStatus("Placed");
    }

    // Method to print out the menu with food items and their prices
    public void printMenu() {
        System.out.println(cuisineType + " Menu");
        System.out.println("====");

        // Loop through the menu items and display their names and prices
        for(int i = 1; i <= menuItems.size(); i++)
        {
            // Print the item number, name, and price
            System.out.printf("%d. %-30s : $%.2f%n", i, menuItems.get(i-1).getName(), menuItems.get(i-1).getPrice());
        }
    }
}
