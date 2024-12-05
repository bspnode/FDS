package fds.Menu;  // Package declaration for the menu system

import fds.item.Food;  // Importing the Food class from the item package
import fds.order.Orders;  // Importing the Orders class from the order package

import java.util.LinkedList;  // Importing the LinkedList class (used for implementing queues)
import java.util.Queue;  // Importing the Queue interface
import java.util.ArrayList;  // Importing the ArrayList class (used for storing menu items)


public abstract class BaseMenu {  // Declaring an abstract class 'BaseMenu' to serve as the base class for menu systems
    Queue<Orders> orderQueue;  // A queue to hold orders that need to be processed
    ArrayList<Food> menuItems;  // A list to hold the food items on the menu
    String cuisineType;

    // Constructor to initialize the BaseMenu with a list of food items
    public BaseMenu(ArrayList<Food> menuItems) {
        this.menuItems = menuItems;  // Initialize the menuItems list
        this.orderQueue = new LinkedList<Orders>();  // Initialize the orderQueue as a LinkedList
    }

    public BaseMenu()
    {
        this.menuItems = new ArrayList<Food>();
        this.orderQueue = new LinkedList<>();
    }

    // Method to confirm and add a new order to the orderQueue
    public void confirmOrder(Orders newOrder) {
        orderQueue.add(newOrder);  // Add the new order to the orderQueue
    }

    public void printMenu()
    {

    }

    public Food getItem(int i)
    {
        return menuItems.get(i - 1);
    }

    public void setCuisineType(String cuisineType) {
        this.cuisineType = cuisineType;
    }

    public String getCuisineType() {
        return cuisineType;
    }

    public void addFood(Food food){
        menuItems.add(food);
    }

    public void addToQueue(Orders order){
        orderQueue.add(order);
    }

    public void printQueue()
    {
        for(Orders order : orderQueue)
        {
            System.out.println(order);
        }
    }

    public boolean isDelivery()
    {
        return false;
    }

    public Orders pullOrder()
    {
        if(orderQueue.isEmpty()) {
            System.out.println("There are currently no orders in queue");
            return null;
        }
        return orderQueue.poll();
    }
}
