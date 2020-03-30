package sample;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class MainStageController implements Initializable
{
    @FXML
    public ComboBox<String> PizzaTypeDropDown;

    @FXML
    public ListView<String> listView;

    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        List<String> toppings = new ArrayList<>();
        toppings.add("Beef");
        toppings.add("Cheese");
        toppings.add("Chicken");
        toppings.add("Green Pepper");
        toppings.add("Ham");
        toppings.add("Mushroom");
        toppings.add("Onion");
        toppings.add("Pepperoni");
        toppings.add("Pineapple");
        toppings.add("Sausage");
        listView.setItems(FXCollections.observableArrayList(toppings));

        PizzaTypeDropDown.setValue("Build Your Own");
        pizzaTypeChange();
    } // initialize()

    public void pizzaTypeChange()
    {
        System.out.println("Selected value : " + PizzaTypeDropDown.getValue());
    }
} // MainStageController
