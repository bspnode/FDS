package fds.item;

/**
 * Food class is a generic class for food items to be sold.
 * @author Austin Tavares
 * @brief Generic Food Items (to be sold)
 * @since 1.0
 */
public abstract class Food
{
    private String  name;
    private double  price;
    private double  calories;
    private double  weight;

    public Food(String name, double price, double calories, double weight)
    {
        this.name = name;
        this.price = price;
        this.calories = calories;
        this.weight = weight;
    }

    public Food(Food food)
    {
        name = food.name;
        price = food.price;
        calories = food.calories;
        weight = food.weight;
    }

    public Food()
    {

    }

    public String getName()
    {
        return name;
    }

    public double getPrice()
    {
        return price;
    }

    public double getCalories()
    {
        return calories;
    }

    public double getWeight()
    {
        return weight;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setPrice(double price)
    {
        this.price = price;
    }

    public void setCalories(double calories)
    {
        this.calories = calories;
    }

    public void setWeight(double weight)
    {
        this.weight = weight;
    }

    public boolean available()
    {
        return true;
    }

}