package fds.data;
//java doc for the class
/**
 * Customer class is a subclass of Person class. It represents a customer for the food delivery service.
 * The class contains an instance variable for the customer's balance and a list of food items in the order.
 * The class contains methods to submit an order, rate an order, and show the customer's details.
 * The class also contains a constructor to create a new customer object.
 * @brief Customer class for the food delivery service
 * @author ISRAEL AGUINIGA
 */

import fds.Menu.BaseMenu;
import fds.item.Food;
import fds.order.Orders;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Customer extends Person {

    private double balance;
    public List<Food> order;


    //constructor
    public Customer(String name,int age, String address, String phone , String email, String password) {
        super(name,age,  address, phone , email, password);
        this.balance = 0.0; //customer balance is 0 by default
        this.order = new ArrayList<>();

    }
    //setters--------------------------------------------------------------------
    public void setBalance(double balance) {
        this.balance = balance;
    }
    //getters--------------------------------------------------------------------
    public double getBalance() {
        return balance;
    }
    //show details method
    @Override
    public void showDetails() {
        super.showDetails();
        System.out.println("Balance: " + balance);
    }




    //submitOrder method - submits an order for the customer
    public Orders buildOrder(BaseMenu menu) {
        Orders o1 = new Orders(this, "", 0);
        menu.printMenu();
        System.out.println("Type in which items you would like, one at a time\nType -1 when you are finished");
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        while(x != -1)
        {
            o1.addToOrder(menu.getItem(x));
            x = sc.nextInt();
        }
        o1.calculateTotal();
        return o1;
    }

    //rateOrder method - rates the delivery driver and food
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
