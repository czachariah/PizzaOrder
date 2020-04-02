package sample;

import java.util.ArrayList;

/**
 * This is the Build-Your-Own Pizza class which extends the Pizza class.
 * @author Chris Zachariah (cvz2)
 * @author Anthony Topol (at877)
 */
public class BuildYourOwnPizza extends Pizza
{
    public final int BUILD_YOUR_OWN_SMALL_PRICE = 5;
    public final int BUILD_YOUR_OWN_MEDIUM_PRICE = BUILD_YOUR_OWN_SMALL_PRICE + 2;
    public final int BUILD_YOUR_OWN_LARGE_PRICE = BUILD_YOUR_OWN_SMALL_PRICE + 4;
    public final int PRICE_PER_TOPPING = 2;

    /**
     * This is the parameterized constructor for the HawaiianPizza class.
     *  @param style is the type of the pizza : Build-Your-Own
     * @param size is the size of the Build-Your-Own Pizza
     * @param toppings is the list of toppings on the Build-Your-Own Pizza
     */
    public BuildYourOwnPizza (String style, String size, ArrayList<String> toppings)
    {
        super(style,size,toppings);
    } // BuildYourOwnPizza()

    /**
     * This method will print out the information about the Build-Your-Own Pizza.
     * @return a String of all the Build-Your-Own Pizza info
     */
    @Override
    public String toString()
    {
        return super.toString() + "Price: $" + pizzaPrice();
    } // toString()

    /**
     * This method returns the total price for the Build-Your-Own Pizza.
     * @return an int which represents the total price of the Build-Your-Own Pizza
     */
    public int pizzaPrice()
    {
        if (this.size.equals("Small (10\")"))
        {
            return BUILD_YOUR_OWN_SMALL_PRICE + (this.toppings.size() * PRICE_PER_TOPPING);
        }
        else if (this.size.equals("Medium (12\")"))
        {
            return BUILD_YOUR_OWN_MEDIUM_PRICE + (this.toppings.size() * PRICE_PER_TOPPING);
        }
        else
        {
            return BUILD_YOUR_OWN_LARGE_PRICE + (this.toppings.size() * PRICE_PER_TOPPING);
        }
    } // pizzaPrice()
} // BuildYourPizza
