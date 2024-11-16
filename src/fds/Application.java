package fds;

import fds.data.Customer;
import fds.data.DeliveryDriver;
import fds.data.Person;
import fds.item.Drink;

public class Application
{
    public static void main(String[] args)
    {

        //person class

        Person person = new Person("John Doe", 25, "1234 Elm St", "123-456-7890", "1", "password");
        Customer customer = new Customer("Jane Doe", 25, "1234 Elm St", "123-456-7890", "1", "password");
        DeliveryDriver driver = new DeliveryDriver("John Smith", 30, "1234 Elm St", "123-456-7890", "1", "password");




       customer.setBalance(100.0);


        customer.submitOrder(customer.order);
        System.out.println("Balance: " + customer.getBalance());
        //rateOrder method
        Drink drink = new Drink("Coke", 1.50, 140, 12);
        customer.order.add(drink);
        customer.submitOrder(customer.order);
        System.out.println("Balance: " + customer.getBalance());
        customer.rateOrder(driver, 5.0);

    }

}