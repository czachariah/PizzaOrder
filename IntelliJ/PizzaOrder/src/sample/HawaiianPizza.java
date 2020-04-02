package sample;

import java.util.ArrayList;

/**
 * This is the Hawaiian Pizza class which extends the Pizza class.
 * @author Chris Zachariah (cvz2)
 * @author Anthony Topol (at877)
 */
public class HawaiianPizza extends Pizza
{
    public final int HAWAIIAN_SMALL_PRICE = 8;
    public final int HAWAIIAN_MEDIUM_PRICE = HAWAIIAN_SMALL_PRICE + 2;
    public final int HAWAIIAN_LARGE_PRICE = HAWAIIAN_SMALL_PRICE + 4;

    /**
     * This is the parameterized constructor for the HawaiianPizza class.
     * @param style is the type of the pizza : Hawaiian
     * @param size is the size of the Hawaiian Pizza
     * @param toppings is the list of toppings on the Hawaiian Pizza
     */
    public HawaiianPizza(String style, String size, ArrayList<String> toppings)
    {
        super(style,size,toppings);
    } // HawaiianPizza()

    /**
     * This method will print out the information about the Hawaiian Pizza.
     * @return a String of all the Hawaiian Pizza info
     */
    @Override
    public String toString()
    {
        return super.toString() + "Price: $" + pizzaPrice();
    } // toString()

    /**
     * This method returns the total price for the Hawaiian Pizza.
     * @return an int which represents the total price of the Hawaiian Pizza
     */
    public int pizzaPrice()
    {
        if (this.size.equals("Small (10\")"))
        {
            return HAWAIIAN_SMALL_PRICE;
        }
        else if (this.size.equals("Medium (12\")"))
        {
            return HAWAIIAN_MEDIUM_PRICE;
        }
        else
        {
            return HAWAIIAN_LARGE_PRICE;
        }
    } // pizzaPrice()
} // HawaiianPizza
