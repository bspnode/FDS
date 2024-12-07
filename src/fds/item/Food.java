package fds.item;

/**
 * Represents a generic food item to be sold. This is an abstract base class for specific food items.
 *
 * Features:
 * - Stores properties such as name, price, calories, and weight of the food item.
 * - Provides getter and setter methods for each property.
 * - Includes constructors for creating food items and cloning existing food items.
 *
 * @brief Abstract class for food items in the food delivery system.
 * @version 1.0
 * @author
 * Austin Tavares
 */
public abstract class Food {

    /** The name of the food item. */
    private String name;

    /** The price of the food item. */
    private double price;

    /** The calorie count of the food item. */
    private double calories;

    /** The weight of the food item in grams. */
    private double weight;

    /**
     * Constructs a new {@code Food} object with the specified details.
     *
     * @param name     The name of the food item.
     * @param price    The price of the food item.
     * @param calories The calorie count of the food item.
     * @param weight   The weight of the food item in grams.
     */
    public Food(String name, double price, double calories, double weight) {
        this.name = name;
        this.price = price;
        this.calories = calories;
        this.weight = weight;
    }

    /**
     * Constructs a new {@code Food} object by copying the properties of another food item.
     *
     * @param food The food item to copy.
     */
    public Food(Food food) {
        this.name = food.name;
        this.price = food.price;
        this.calories = food.calories;
        this.weight = food.weight;
    }

    /**
     * Default constructor for creating an empty {@code Food} object.
     */
    public Food() {
        // Default constructor
    }

    /**
     * Retrieves the name of the food item.
     *
     * @return The name of the food item.
     */
    public String getName() {
        return name;
    }

    /**
     * Updates the name of the food item.
     *
     * @param name The new name of the food item.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Retrieves the price of the food item.
     *
     * @return The price of the food item.
     */
    public double getPrice() {
        return price;
    }

    /**
     * Updates the price of the food item.
     *
     * @param price The new price of the food item.
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Retrieves the calorie count of the food item.
     *
     * @return The calorie count of the food item.
     */
    public double getCalories() {
        return calories;
    }

    /**
     * Updates the calorie count of the food item.
     *
     * @param calories The new calorie count of the food item.
     */
    public void setCalories(double calories) {
        this.calories = calories;
    }

    /**
     * Retrieves the weight of the food item in grams.
     *
     * @return The weight of the food item in grams.
     */
    public double getWeight() {
        return weight;
    }

    /**
     * Updates the weight of the food item in grams.
     *
     * @param weight The new weight of the food item in grams.
     */
    public void setWeight(double weight) {
        this.weight = weight;
    }

    /**
     * Indicates whether the food item is available.
     *
     * @return {@code true} if the food item is available; {@code false} otherwise.
     */
    public boolean available() {
        return true;
    }
}
