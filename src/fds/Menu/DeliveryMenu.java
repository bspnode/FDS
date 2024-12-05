package fds.Menu;

import fds.data.DeliveryDriver;
import fds.data.Person;
import fds.item.Food;
import fds.order.Orders;

import java.util.*;

public class DeliveryMenu extends BaseMenu {
    // Queue to manage the delivery drivers
    Queue<DeliveryDriver> driverQueue = new LinkedList<DeliveryDriver>();

    // Constructor to initialize DeliveryMenu with a list of Food items
    public DeliveryMenu(ArrayList<Food> menuItems) {
        super(menuItems);
    }

    public DeliveryMenu() {
        super();
    }

    // Method to confirm an order, ensuring the address is correct before processing
    public void confirmOrder(Orders newOrder)
    {
        // Ask if the current address on the order is correct
        System.out.println("Is this still the correct address: " + newOrder.getCustomer().getAddress() + "?");

        // Create a scanner object to capture user input
        Scanner sc = new Scanner(System.in);

        // If the user confirms the address, place the order
        if(sc.nextLine().toLowerCase().equals("yes"))
        {
            orderQueue.add(newOrder); // Add the new order to the order queue
            System.out.println("Order has been placed!"); // Output confirmation
            newOrder.setStatus("Placed"); // Set the order status to "Placed"
        }
        else {
            // If the address is incorrect, prompt the user to enter a new address
            System.out.println("Please update your address:");
            newOrder.getCustomer().setAddress(sc.nextLine()); // Update the address
            orderQueue.add(newOrder); // Add the order to the queue
            System.out.println("Order has been placed!"); // Output confirmation
            newOrder.setStatus("Placed"); // Set the order status to "Placed"
        }
    }

    // Method to print the menu with food items and their prices
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


    public void buildOrder(Person C1)
    {

    }

    public boolean isDelivery()
    {
        return true;
    }
}
