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
import fds.data.DeliveryDriver;

import java.util.ArrayList;
import java.util.Scanner;

public class Application
{
    static ArrayList<Person> people = new ArrayList<Person>();
    static ArrayList<BaseMenu> M1 = new ArrayList<>();


    public static void main(String[] args)
    {
        Food f1 = new Drink("Coca-Cola", 1.99, 150, 0.5);  // Drink: Name, Price, Calories, Weight
        Food f2 = new Drink("Pepsi", 1.89, 140, 0.5);
        Food f3 = new Drink("Lemonade", 2.49, 120, 0.6);
        Food f4 = new Drink("Water", 0.99, 0, 0.7);
        Food f5 = new Drink("Orange Juice", 3.49, 110, 0.6);

        // 5 Dish items (Solid foods)
        Food f6 = new Drink("Cheeseburger", 5.99, 350, 0.4); // Dish: Name, Price, Calories, Weight
        Food f7 = new Drink("Pepperoni Pizza", 8.99, 500, 1.0);
        Food f8 = new Drink("Spaghetti Bolognese", 7.49, 600, 0.8);
        Food f9= new Drink("Chicken Salad", 6.99, 250, 0.3);
        Food f10 = new Drink("Grilled Cheese Sandwich", 4.49, 400, 0.5);

        BaseMenu b1 = new OrderMenu();
        b1.setCuisineType("American");
        b1.addFood(f1);
        b1.addFood(f3);
        b1.addFood(f5);
        b1.addFood(f7);
        b1.addFood(f2);

        BaseMenu b2 = new DeliveryMenu();
        b2.setCuisineType("Takeout American");
        b2.addFood(f1);
        b2.addFood(f4);
        b2.addFood(f6);
        b2.addFood(f8);
        b2.addFood(f9);
        b2.addFood(f10);

        M1.add(b1);
        M1.add(b2);

        Person person = new Customer("John Doe", 25, "1234 Elm St", "123-456-7890", "1", "password");
        Customer customer = new Customer("Jane Doe", 25, "1234 Elm St", "123-456-7890", "1", "password");
        DeliveryDriver driver = new DeliveryDriver("John Smith", 30, "1234 Elm St", "123-456-7890", "1", "password");

        people = new ArrayList<Person>();
        people.add(person);
        people.add(customer);
        people.add(driver);

        driver.setRating(4.2);

        String s = "";
        Scanner sc = new Scanner(System.in);
        while(!s.toLowerCase().equals("stop"))
        {
            System.out.println("Would you like to interact with the restaurant?");
            s = sc.nextLine().toLowerCase();
            if(s.equals("yes"));
            login();
            b1.printQueue();
            b2.printQueue();
        }

    }

    public static void login()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter your name:");
        String name = sc.nextLine();
        for(int i = 0; i < people.size(); i++)
        {
            if(people.get(i).getName().equals(name))
            {
                System.out.println("Welcome " + people.get(i).getName());
                System.out.println("Please enter your password: ");
                if(sc.nextLine().equals(people.get(i).getPassword())) {
                    if(!people.get(i).isDeliveryDriver()) {
                        order(people.get(i));
                    }
                    else{
                        DeliveryDriver driver = (DeliveryDriver) people.get(i);
                        driverDashboard(driver);
                    }
                }
            }
        }
    }

    public static void order(Person C1)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Which menu would you like to order from?");
        for(int i  = 0; i < M1.size(); i++)
        {
            System.out.println(M1.get(i).getCuisineType());
        }

        String choice = sc.nextLine();

        for(int i = 0; i < M1.size(); i++)
        {
            if(choice.equalsIgnoreCase(M1.get(i).getCuisineType()))
            {
                Orders o1 = C1.buildOrder(M1.get(i));
                o1.calculateTotal();
                System.out.println("Your total is: $" + o1.getTotal());
                //M1.get(i).confirmOrder(C1.buildOrder(M1.get(i)));
            }
        }
    }

    public static void driverDashboard()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Implement driver dashboard, if they are not busy, assign order, if they are, leave alone" +
                "until they are finished");
        System.out.println("implement other general driver dashboard utilities");
    }

    public static void driverDashboard(DeliveryDriver D1)
    {
        Scanner sc = new Scanner(System.in);
        if(D1.isAvailable()) {
            System.out.println("Would you like to receive a new order(1), mark one as delivered(2), or view your rating(3)?");
            int s = sc.nextInt();
            if(s == 1)
            {
                if(D1.isAvailable() == false)
                {
                    System.out.println("please complete your current order before receiving a new one.");
                }
                else {
                    System.out.println("Please select which restaraunt you would like to deliver from: ");
                    int x = 1;
                    for(int i = 0; i < M1.size(); i++)
                    {
                        if(M1.get(i).isDelivery())
                        {
                            System.out.println(x + ": " + M1.get(i).getCuisineType());
                            x++;
                        }
                    }
                    int L = sc.nextInt();
                    x = 0;
                    for(int i = 0; i < M1.size(); i++)
                    {
                        if(x == L)
                        {
                            Orders o1 = M1.get(i).pullOrder();
                            System.out.println("You are delivering to: " + o1.getAddress() +
                                    " Addressed to: " + o1.getCustomer().getName());
                            D1.setOrder(o1);
                        }
                    }
                }
            }
            else if(s == 2)
            {
                System.out.println("Please enter the status of the order: ");
                D1.getOrder().setStatus(sc.nextLine());
            }
            else if(s == 3)
            {
                System.out.println("Your rating is: " + D1.getRating());
            }
        }
    }
}