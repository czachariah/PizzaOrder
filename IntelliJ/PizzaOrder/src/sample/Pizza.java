package sample;

import java.util.ArrayList;

/**
 * This is the Pizza abstract class which is extended by the other Pizza subclasses.
 * @author Chris Zachariah (cvz2)
 * @author Anthony Topol (at877)
 */
public abstract class Pizza
{
    protected String style;
    protected String size;
    protected ArrayList<String> toppings;

    /**
     * This is the 3-parameter Pizza constructor.
     * @param style is the type of the pizza : Deluxe , Hawaiian , or Build-Your-Own
     * @param size is the size of the Pizza
     * @param toppings is the list of toppings on the Pizza
     */
    public Pizza(String style, String size, ArrayList<String> toppings)
    {
        this.style = style;
        this.size = size;
        this.toppings = toppings;
    } // Pizza(3)

    /**
     * This is the abstract method that will be implemented in all the subclasses.
     * @return the total price of the pizza.
     */
    public abstract int pizzaPrice();

    /**
     * This method prints out all the information about the current Pizza.
     * @return a String of the info on Style, Size ,and Toppings
     */
    public String toString()
    {
        return "Style: " + this.style + " , Size: " + this.size + " , Toppings: " + getToppings() + " , ";
    } // toString()

    /**
     * This method will print out all the toppings on the Pizza.
     * @return a String of all the toppings
     */
    public String getToppings()
    {
        return this.toppings.toString();
    } // getToppings()
} // Pizza

/*


public Pizza(String style, String size)
{
    this.style = style;
    this.size = size;
    this.toppings = null;
} // Pizza(2)
 */