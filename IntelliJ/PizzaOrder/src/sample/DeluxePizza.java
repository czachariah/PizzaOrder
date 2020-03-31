package sample;

import java.util.ArrayList;

/**
 * This is the Deluxe Pizza class which extends the Pizza class.
 *  @author Chris Zachariah (cvz2)
 *  @author Anthony Topol (at877)
 */
public class DeluxePizza extends Pizza
{
    public final int DeluxeSmallPrice = 14;
    public final int DeluxeMediumPrice = DeluxeSmallPrice + 2;
    public final int DeluxeLargePrice = DeluxeSmallPrice + 4;

    /**
     * This is the parameterized constructor for the DeluxePizza class.
     * @param style is the type of the pizza : Deluxe
     * @param size is the size of the Deluxe Pizza
     * @param toppings is the list of toppings on the Deluxe Pizza
     */
    public DeluxePizza(String style, String size, ArrayList<String> toppings)
    {
        super(style,size,toppings);
    } // DeluxePizza()

    /**
     * This method will print out the information about the Deluxe Pizza.
     * @return a String of all the Deluxe Pizza info
     */
    @Override
    public String toString()
    {
        return super.toString() + "Price: $" + pizzaPrice();
    } // toString()

    /**
     * This method returns the total price for the Deluxe Pizza.
     * @return an int which represents the total price of the Deluxe Pizza
     */
    public int pizzaPrice()
    {
        if (this.size.equals("Small (10\")"))
        {
            return DeluxeSmallPrice;
        }
        else if (this.size.equals("Medium (12\")"))
        {
            return DeluxeMediumPrice;
        }
        else
        {
            return DeluxeLargePrice;
        }
    } // pizzaPrice()
} // DeluxePizza
