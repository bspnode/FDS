package fds.item;

/**
 * Represents a drink product such as soda, water, etc.
 * Extends the {@code Food} class and inherits its properties.
 * This class allows for the creation of drink items with specific attributes
 * like name, price, calories, and weight.
 *
 * @version 11/09/2024
 * @author Austin Tavares
 */
public class Drink extends Food {

    /**
     * Constructs a new {@code Drink} object with the specified attributes.
     *
     * @param name      The name of the drink.
     * @param price     The price of the drink in dollars.
     * @param calories  The number of calories in the drink.
     * @param weight    The weight of the drink in grams.
     */
    public Drink(String name, double price, double calories, double weight) {
        super(name, price, calories, weight);
    }

    /**
     * Constructs a new {@code Drink} object by copying the properties of a {@code Food} object.
     *
     * @param food  The {@code Food} object to copy.
     */
    public Drink(Food food) {
        super(food);
    }
}
