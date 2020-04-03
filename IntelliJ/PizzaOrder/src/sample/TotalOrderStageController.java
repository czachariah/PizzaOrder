package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

/**
 * This class controls the second stage of the GUI.
 * @author Chris Zachariah (cvz2)
 * @author Anthony Topol (at877)
 */
public class TotalOrderStageController
{
    @FXML
    public Button BackButton;

    @FXML
    public TextArea Output;

    @FXML
    public Button ClearOrderButton;

    public ArrayList<Pizza> totalOrder;

    private Stage stage = null;

    /**
     * This method will take in the Pizza order from the main stage to display the contents and figure out the price.
     * @param order is the current pizza order from the main stage
     */
    public void getOrder(ArrayList<Pizza> order)
    {
        // get the total order
        totalOrder = order;
        // skip to the next line after the opening statement
        Output.appendText("\n\n");

        if (totalOrder == null)
        {
            totalOrder = new ArrayList<>();
        }
        if (totalOrder.size() == 0)
        {
            Output.appendText("There are no pizzas in this order. Total Price: $0\n\n");
        }
        else
        {
            int totalPrice = 0;
            int i = 0;
            for(Pizza a : totalOrder)
            {
                totalPrice += a.pizzaPrice();
                i++;
                Output.appendText("" + i + ".) " +a.toString() + "\n\n");
            }
            Output.appendText("The total price of the order is: $" + totalPrice + "\n\n");
        }
    } // getOrder()

    /**
     * This method clears out the current Pizza order.
     */
    public void clearOrder()
    {
        totalOrder.clear();
        Output.clear();
        Output.appendText("THE ORDER HAS BEEN CLEARED.\n\n");
    } // clearOrder()

    /**
     * This method will close the current window once the customer has looked through their order.
     * @param event is to identify this as an action event
     * @throws IOException an Exception
     */
    public void goBack(ActionEvent event) throws IOException {
        if(stage!=null) {
            stage.close();
        }
    } // goBack()

    /**
     * This method sets the stage of this view.
     * @param stage is the current stage
     */
    public void setStage(Stage stage) {
        this.stage = stage;
    } // setStage()
} // TotalOrderStageController
