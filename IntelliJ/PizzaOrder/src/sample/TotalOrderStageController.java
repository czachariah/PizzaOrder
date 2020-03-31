package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
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

    public void getOrder(ArrayList<Pizza> order)
    {
        // get the total order
        totalOrder = order;

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
            for(Pizza a : totalOrder)
            {
                totalPrice += a.pizzaPrice();
                Output.appendText(a.toString() + "\n");
            }
            Output.appendText("The total price of the order is: $" + totalPrice + "\n\n");
        }

    } // getOrder()


    public void clearOrder()
    {
        totalOrder.clear();
        Output.appendText("THE ORDER HAS BEEN CLEARED.\n\n");
    } // clearOrder()

    public void goBack(ActionEvent event) throws IOException {
        // set up the loader
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("MainStage.fxml"));
        Parent tableViewParent = loader.load();

        // set up the scene
        Scene tableViewScene = new Scene(tableViewParent);

        // access the controller and send the total order of pizzas
        MainStageController controller = loader.getController();
        controller.getOrder(totalOrder);

        // open the new window and set the scene
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(tableViewScene);
        window.show();
    } // goBack()
} // TotalOrderStageController
