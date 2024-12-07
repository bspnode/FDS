package fds;

import fds.Menu.BaseMenu;
import fds.Menu.DeliveryMenu;
import fds.Menu.OrderMenu;
import fds.data.Customer;
import fds.data.DeliveryDriver;
import fds.data.Person;
import fds.item.Drink;
import fds.item.Food;
import fds.order.Orders;

import java.util.ArrayList;
import java.util.Scanner;

public class Application {
    static ArrayList<Person> people = new ArrayList<>();
    static ArrayList<BaseMenu> menus = new ArrayList<>();

    /**
     * Main method to start the application and interact with the restaurant system.
     * Allows customers to place orders and delivery drivers to manage their tasks.
     */
    public static void main(String[] args) {
        // Creating food items (drinks and dishes)
        Food f1 = new Drink("Coca-Cola", 1.99, 150, 0.5);
        Food f2 = new Drink("Pepsi", 1.89, 140, 0.5);
        Food f3 = new Drink("Lemonade", 2.49, 120, 0.6);
        Food f4 = new Drink("Water", 0.99, 0, 0.7);
        Food f5 = new Drink("Orange Juice", 3.49, 110, 0.6);

        // 5 Dish items (Solid foods)
        Food f6 = new Drink("Cheeseburger", 5.99, 350, 0.4);
        Food f7 = new Drink("Pepperoni Pizza", 8.99, 500, 1.0);
        Food f8 = new Drink("Spaghetti Bolognese", 7.49, 600, 0.8);
        Food f9 = new Drink("Chicken Salad", 6.99, 250, 0.3);
        Food f10 = new Drink("Grilled Cheese Sandwich", 4.49, 400, 0.5);

        // Initializing menus
        BaseMenu orderMenu = new OrderMenu();
        orderMenu.setCuisineType("American");
        orderMenu.addFood(f1);
        orderMenu.addFood(f3);
        orderMenu.addFood(f5);
        orderMenu.addFood(f7);
        orderMenu.addFood(f2);

        BaseMenu deliveryMenu = new DeliveryMenu();
        deliveryMenu.setCuisineType("Takeout American");
        deliveryMenu.addFood(f1);
        deliveryMenu.addFood(f4);
        deliveryMenu.addFood(f6);
        deliveryMenu.addFood(f8);
        deliveryMenu.addFood(f9);
        deliveryMenu.addFood(f10);

        menus.add(orderMenu);
        menus.add(deliveryMenu);

        // Initializing people (customers and drivers)
        Person customer1 = new Customer("John Doe", 25, "1234 Elm St", "123-456-7890", "1", "password");
        Customer customer2 = new Customer("Jane Doe", 25, "1234 Elm St", "123-456-7890", "2", "password");
        DeliveryDriver driver = new DeliveryDriver("John Smith", 30, "1234 Elm St", "123-456-7890", "3", "password");

        people.add(customer1);
        people.add(customer2);
        people.add(driver);

        // Setting driver rating
        driver.setRating(4.2);

        // Main loop for interacting with the system
        String input = "";
        Scanner scanner = new Scanner(System.in);
        while (!input.equalsIgnoreCase("stop")) {
            System.out.println("Would you like to interact with the restaurant? (yes/stop)");
            input = scanner.nextLine().toLowerCase();

            if (input.equals("yes")) {
                login();
                orderMenu.printQueue();
                deliveryMenu.printQueue();
            }
        }
    }

    /**
     * Handles the login process for users to access their accounts.
     */
    public static void login() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter your name:");
        String name = scanner.nextLine();

        for (Person person : people) {
            if (person.getName().equals(name)) {
                System.out.println("Welcome " + person.getName());
                System.out.println("Please enter your password: ");
                if (scanner.nextLine().equals(person.getPassword())) {
                    if (!person.isDeliveryDriver()) {
                        order(person);  // Customer order process
                    } else {
                        DeliveryDriver driver = (DeliveryDriver) person;
                        driverDashboard(driver);  // Driver dashboard
                    }
                }
            }
        }
    }

    /**
     * Allows a customer to place an order from the available menus.
     *
     * @param customer The customer placing the order.
     */
    public static void order(Person customer) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Which menu would you like to order from?");
        for (BaseMenu menu : menus) {
            System.out.println(menu.getCuisineType());
        }

        String choice = scanner.nextLine();
        for (BaseMenu menu : menus) {
            if (choice.equalsIgnoreCase(menu.getCuisineType())) {
                Orders order = customer.buildOrder(menu);
                order.calculateTotal();
                System.out.println("Your total is: $" + order.getTotal());
                // menu.confirmOrder(order);  // Confirm order, if needed
            }
        }
    }

    /**
     * Displays the delivery driver's dashboard with options for managing orders.
     *
     * @param driver The delivery driver accessing the dashboard.
     */
    public static void driverDashboard(DeliveryDriver driver) {
        Scanner scanner = new Scanner(System.in);
        if (driver.isAvailable()) {
            System.out.println("Would you like to receive a new order (1), mark one as delivered (2), or view your rating (3)?");
            int selection = scanner.nextInt();

            if (selection == 1) {
                if (!driver.isAvailable()) {
                    System.out.println("Please complete your current order before receiving a new one.");
                } else {
                    System.out.println("Please select which restaurant you would like to deliver from: ");
                    int index = 1;
                    for (BaseMenu menu : menus) {
                        if (menu.isDelivery()) {
                            System.out.println(index + ": " + menu.getCuisineType());
                            index++;
                        }
                    }

                    int choice = scanner.nextInt();
                    BaseMenu selectedMenu = menus.get(choice - 1);
                    Orders order = selectedMenu.pullOrder();
                    System.out.println("You are delivering to: " + order.getDeliveryAddress() + " Addressed to: " + order.getCustomer().getName());
                    driver.setOrder(order);  // Assign the order to the driver
                }
            } else if (selection == 2) {
                System.out.println("Please enter the status of the order: ");
                scanner.nextLine();  // Clear the newline
                driver.getOrder().setStatus(scanner.nextLine());
            } else if (selection == 3) {
                System.out.println("Your rating is: " + driver.getRating());
            }
        }
    }
}
