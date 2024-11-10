package fds.item;

//==============================================//
// File: Drink.java                             //
// Author: Austin Tavares                       //
// Date: 11/09/2024                             //
// Purpose: Drink Products (Soda, Water, etc.)  //
//==============================================//

public class Drink extends Food
{
    public Drink(String name, double price, double calories, double weight)
    {
        super(name, price, calories, weight);
    }

    public Drink(Food food)
    {
        super(food);
    }
}