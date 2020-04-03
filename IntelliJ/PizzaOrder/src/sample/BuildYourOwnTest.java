package sample;

import junit.framework.Assert;
import java.util.ArrayList;


/**
 * This class will test the pizzaPrice() method inside the BuildYourOwnPizza.java class.
 * @author Chris Zachariah (cvz2)
 * @author Anthony Topol (at877)
 */
public class BuildYourOwnTest {
    /**
     * This method will be the main J-Unit test for the pizzaPrice() method in the BuildYourOwn Class.
     * It will check all the prices of all the pizzas with all three sizes (small, medium, and large)
     * with all the possible number of toppings (1 - 6).
     */
    @org.junit.Test
    public void pizzaPrice() {
        // now testing size: Small
        ArrayList<String> toppings = new ArrayList<>();

        // test 1 : Build Your Own , Small , 1 topping
        toppings.add("Beef");
        BuildYourOwn small1 = new BuildYourOwn("Build Your Own","Small (10\")",toppings);
        Assert.assertEquals(7,small1.pizzaPrice());

        // test 2 : Build Your Own , Small , 2 toppings
        toppings.add("Cheese");
        BuildYourOwn small2 = new BuildYourOwn("Build Your Own","Small (10\")",toppings);
        Assert.assertEquals(9,small2.pizzaPrice());

        // test 3 : Build Your Own , Small , 3 toppings
        toppings.add("Chicken");
        BuildYourOwn small3 = new BuildYourOwn("Build Your Own","Small (10\")",toppings);
        Assert.assertEquals(11,small3.pizzaPrice());

        // test 4 : Build Your Own , Small , 4 toppings
        toppings.add("Green Pepper");
        BuildYourOwn small4 = new BuildYourOwn("Build Your Own","Small (10\")",toppings);
        Assert.assertEquals(13,small4.pizzaPrice());

        // test 5 : Build Your Own , Small , 5 toppings
        toppings.add("Ham");
        BuildYourOwn small5 = new BuildYourOwn("Build Your Own","Small (10\")",toppings);
        Assert.assertEquals(15,small5.pizzaPrice());

        // test 6 : Build Your Own , Small , 6 toppings
        toppings.add("Mushroom");
        BuildYourOwn small6 = new BuildYourOwn("Build Your Own","Small (10\")",toppings);
        Assert.assertEquals(17,small6.pizzaPrice());

        // now testing size: Medium
        toppings.clear();

        // test 7 : Build Your Own , Medium , 1 topping
        toppings.add("Beef");
        BuildYourOwn medium1 = new BuildYourOwn("Build Your Own","Medium (12\")",toppings);
        Assert.assertEquals(9,medium1.pizzaPrice());

        // test 8 : Build Your Own , Medium , 2 toppings
        toppings.add("Cheese");
        BuildYourOwn medium2 = new BuildYourOwn("Build Your Own","Medium (12\")",toppings);
        Assert.assertEquals(11,medium2.pizzaPrice());

        // test 9 : Build Your Own , Medium , 3 toppings
        toppings.add("Chicken");
        BuildYourOwn medium3 = new BuildYourOwn("Build Your Own","Medium (12\")",toppings);
        Assert.assertEquals(13,medium3.pizzaPrice());

        // test 10 : Build Your Own , Medium , 4 toppings
        toppings.add("Green Pepper");
        BuildYourOwn medium4 = new BuildYourOwn("Build Your Own","Medium (12\")",toppings);
        Assert.assertEquals(15,medium4.pizzaPrice());

        // test 11 : Build Your Own , Medium , 5 toppings
        toppings.add("Ham");
        BuildYourOwn medium5 = new BuildYourOwn("Build Your Own","Medium (12\")",toppings);
        Assert.assertEquals(17,medium5.pizzaPrice());

        // test 12 : Build Your Own , Medium , 6 toppings
        toppings.add("Mushroom");
        BuildYourOwn medium6 = new BuildYourOwn("Build Your Own","Medium (12\")",toppings);
        Assert.assertEquals(19,medium6.pizzaPrice());

        // now testing size: Large
        toppings.clear();

        // test 13 : Build Your Own , Large , 1 topping
        toppings.add("Beef");
        BuildYourOwn large1 = new BuildYourOwn("Build Your Own","Large (14\")",toppings);
        Assert.assertEquals(11,large1.pizzaPrice());

        // test 14 : Build Your Own , Large , 2 toppings
        toppings.add("Cheese");
        BuildYourOwn large2 = new BuildYourOwn("Build Your Own","Large (14\")",toppings);
        Assert.assertEquals(13,large2.pizzaPrice());

        // test 15 : Build Your Own , Large , 3 toppings
        toppings.add("Chicken");
        BuildYourOwn large3 = new BuildYourOwn("Build Your Own","Large (14\")",toppings);
        Assert.assertEquals(15,large3.pizzaPrice());

        // test 16 : Build Your Own , Large , 4 toppings
        toppings.add("Green Pepper");
        BuildYourOwn large4 = new BuildYourOwn("Build Your Own","Large (14\")",toppings);
        Assert.assertEquals(17,large4.pizzaPrice());

        // test 17 : Build Your Own , Large , 5 toppings
        toppings.add("Ham");
        BuildYourOwn large5 = new BuildYourOwn("Build Your Own","Large (14\")",toppings);
        Assert.assertEquals(19,large5.pizzaPrice());

        // test 18 : Build Your Own , Large , 6 toppings
        toppings.add("Mushroom");
        BuildYourOwn large6 = new BuildYourOwn("Build Your Own","Large (14\")",toppings);
        Assert.assertEquals(21,large6.pizzaPrice());
    } // pizzaPrice()
} // BuildYourOwnPizzaTest