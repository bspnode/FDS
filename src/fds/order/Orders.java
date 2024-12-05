package fds.order;

import fds.data.Person;
import fds.item.Food;

import java.util.ArrayList;

public class Orders {
    // List of foods in the order
    ArrayList<Food> order = new ArrayList<>();

    // Customer associated with the order
    Person customer;

    // Total cost of the order
    double total;

    // Unique identifier for the order
    String orderID;

    // Delivery address for the order
    String address;

    // Status of the order (e.g., "Placed", "Delivered")
    String status;

    // Constructor to initialize the order with given values
    public Orders(Person customer, String orderID, double total) {
        this.order = order;
        this.customer = customer;
        this.orderID = orderID;
        this.total = total;
    }

    // Method to print the details of each item in the order
    public void printOrder(){
        // Loop through each item in the order and print it
        for(int i = 0; i < order.size(); i++){
            System.out.println(order.get(i).toString());
        }
    }

    // Getter method to retrieve the list of food items in the order
    public ArrayList<Food> getOrder() {
        return order;
    }

    // Getter method to retrieve the customer who placed the order
    public Person getCustomer(){
        return customer;
    }

    // Getter method to retrieve the total cost of the order
    public double getTotal(){
        return total;
    }

    // Getter method to retrieve the unique order ID
    public String getOrderID(){
        return orderID;
    }

    // Setter method to update the delivery address
    public void setAddress(String address) {
        this.address = address;
    }

    // Getter method to retrieve the delivery address
    public String getAddress() {
        return address;
    }

    // Setter method to update the order status
    public void setStatus(String status) {
        this.status = status;
    }

    // Getter method to retrieve the current status of the order
    public String getStatus() {
        return status;
    }

    public void addToOrder(Food f){
        order.add(f);
        total += f.getPrice();
    }

    public void calculateTotal(){
        total = 0;
        for(int i = 0; i < order.size(); i++){
            total += order.get(i).getPrice();
        }
    }
}
