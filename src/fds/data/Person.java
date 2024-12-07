package fds.data;

import fds.Menu.BaseMenu;
import fds.order.Orders;

/**
 * Represents a generic person in the food delivery service system.
 * This class serves as a base class for specific roles such as {@code Customer} and {@code DeliveryDriver}.
 *
 * Features:
 * - Stores personal information such as name, age, address, phone, email, and password.
 * - Provides getter and setter methods for personal details.
 * - Includes placeholder methods for role-specific behavior, such as building an order or checking if the person is a delivery driver.
 *
 * @version 11/09/2024
 * @brief Base class for individuals in the food delivery service.
 * @author Israel Aguiniga
 */
public class Person {

    /** The person's name. */
    private String name;

    /** The person's age. */
    private int age;

    /** The person's address. */
    private String address;

    /** The person's phone number. */
    private String phone;

    /** The person's email address. */
    private String email;

    /** The person's password. */
    private String password;

    /**
     * Constructs a new {@code Person} object with the specified personal details.
     *
     * @param name     The person's name.
     * @param age      The person's age.
     * @param address  The person's address.
     * @param phone    The person's phone number.
     * @param email    The person's email address.
     * @param password The person's password.
     */
    public Person(String name, int age, String address, String phone, String email, String password) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.password = password;
    }

    /**
     * Displays the person's details.
     */
    public void showDetails() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Address: " + address);
        System.out.println("Phone: " + phone);
        System.out.println("Email: " + email);
        System.out.println("Password: " + password);
    }

    // Setters ------------------------------------------------------------------

    /**
     * Updates the person's name.
     *
     * @param name The new name to set.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Updates the person's age.
     *
     * @param age The new age to set.
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * Updates the person's address.
     *
     * @param address The new address to set.
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Updates the person's phone number.
     *
     * @param phone The new phone number to set.
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * Updates the person's email address.
     *
     * @param email The new email address to set.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Updates the person's password.
     *
     * @param password The new password to set.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    // Getters ------------------------------------------------------------------

    /**
     * Retrieves the person's name.
     *
     * @return The person's name.
     */
    public String getName() {
        return name;
    }

    /**
     * Retrieves the person's age.
     *
     * @return The person's age.
     */
    public int getAge() {
        return age;
    }

    /**
     * Retrieves the person's address.
     *
     * @return The person's address.
     */
    public String getAddress() {
        return address;
    }

    /**
     * Retrieves the person's phone number.
     *
     * @return The person's phone number.
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Retrieves the person's email address.
     *
     * @return The person's email address.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Retrieves the person's password.
     *
     * @return The person's password.
     */
    public String getPassword() {
        return password;
    }

    // Role-Specific Placeholder Methods ----------------------------------------

    /**
     * Placeholder method for building an order.
     * This method is expected to be overridden by subclasses such as {@code Customer}.
     *
     * @param baseMenu The menu used to build the order.
     * @return {@code null} by default.
     */
    public Orders buildOrder(BaseMenu baseMenu) {
        return null;
    }

    /**
     * Indicates whether the person is a delivery driver.
     * This method is expected to be overridden by subclasses such as {@code DeliveryDriver}.
     *
     * @return {@code false} by default.
     */
    public boolean isDeliveryDriver() {
        return false;
    }
}
