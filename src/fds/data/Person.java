package fds.data;

import fds.Menu.BaseMenu;
import fds.order.Orders;

/**
 * Person class is a superclass for the Customer and DeliveryDriver classes. It represents a person in the food delivery service.
 * The class contains instance variables for the person's name, age, address, phone, email, and password.
 * The class contains methods to show the person's details and set the person's information.
 * The class also contains a constructor to create a new person object.
 * @brief Person class for the food delivery service
 * @author ISraeL Aguiniga
 */

public class Person {
    //instance variables
    private String name;
    private int age;
    private String address;
    private String phone;
    private String email;
    private String password;



    //constructor
    public Person(String name,int age, String address, String phone , String email, String password) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.password = password;
    }



    //show details method
    public void showDetails() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Address: " + address);
        System.out.println("Phone: " + phone);
        System.out.println("Email: " + email);
        System.out.println("Password: " + password);
    }

    //setters--------------------------------------------------------------------
    public void setName(String name) {
        this.name = name;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setAge(int age) {
        this.age = age;
    }

    //getters--------------------------------------------------------------------
    public String getName() {
        return name;
    }
    public String getAddress() {
        return address;
    }
    public String getPhone() {
        return phone;
    }
    public String getEmail() {
        return email;
    }
    public String getPassword() {
        return password;
    }
    public int getAge() {
        return age;
    }


    public Orders buildOrder(BaseMenu baseMenu) {
        return null;
    }

    public boolean isDeliveryDriver()
    {
        return false;
    }
}
