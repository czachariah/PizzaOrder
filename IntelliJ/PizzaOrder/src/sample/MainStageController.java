package sample;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;


import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * This class controls the main stage of the GUI.
 * @author Chris Zachariah (cvz2)
 * @author Anthony Topol (at877)
 */
public class MainStageController implements Initializable
{
    ArrayList<Pizza> pizzaOrder = new ArrayList<>();

    public ArrayList<String> toppings = new ArrayList<>();

    public final int EMPTY = 0;
    public final int MINTOPPINGS = 1;
    public final int MAXTOPPINGS = 6;

    @FXML
    public ComboBox<String> PizzaTypeDropDown;

    @FXML
    public ComboBox<String> PizzaSizeDropDown;

    @FXML
    public ImageView PizzaImage;

    @FXML
    public ListView<String> allToppingsList;

    @FXML
    public Button AddToppingButton;

    @FXML
    public Button RemoveToppingButton;

    @FXML
    public Button ClearSelectionButton;

    @FXML
    public ListView<String> ChoiceToppingList;

    @FXML
    public Button AddToOrderButton;

    @FXML
    public Button ShowOrderButton;

    @FXML
    public TextArea OutPutArea;

    /**
     * This method initializes the GUI with the Type: Build-Your-Own , Size: Medium (12") and
     * populates the topping list.
     * @param url is the URL
     * @param rb is the Resource Bundle
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        // populate the toppings list
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
        allToppingsList.setItems(FXCollections.observableArrayList(toppings));

        // set the pizza type to the default: Build-Your-Own
        PizzaTypeDropDown.setValue("Build Your Own");
        pizzaTypeChange();

        // add 2 newlines to the text Area for to get output
        OutPutArea.appendText("\n\n");
    } // initialize()

    /**
     * This method changes the values and items in some lists and fields, and set buttons on/off depending
     * on the type of pizza the user decides to order.
     */
    public void pizzaTypeChange()
    {
        if (PizzaTypeDropDown.getValue().equals("Build Your Own"))
        {
            // make sure the buttons can be used by the user
            AddToppingButton.setDisable(false);
            RemoveToppingButton.setDisable(false);
            ClearSelectionButton.setDisable(false);

            // change the pizza size to the default medium
            PizzaSizeDropDown.getSelectionModel().clearSelection();
            PizzaSizeDropDown.setValue(null);
            PizzaSizeDropDown.setValue("Medium (12\")");

            // change the image to the build-your-own pizza station
            Image BuildYourOwn = new Image("sample/BuildYourOwnPizza.jpg");
            PizzaImage.setImage(BuildYourOwn);

            // clear out the toppings list
            toppings.clear();

            // now display the toppings list
            ChoiceToppingList.setItems(FXCollections.observableArrayList(toppings));
        }
        else if (PizzaTypeDropDown.getValue().equals("Deluxe"))
        {
            // change the pizza size to the default medium
            PizzaSizeDropDown.getSelectionModel().clearSelection();
            PizzaSizeDropDown.setValue(null);
            PizzaSizeDropDown.setValue("Medium (12\")");

            // change the image to the deluxe pizza
            Image deluxePizza = new Image("sample/DeluxePizza.jpg");
            PizzaImage.setImage(deluxePizza);

            // since this is a pre-set pizza, don't let the customer change the ingredients
            AddToppingButton.setDisable(true);
            RemoveToppingButton.setDisable(true);
            ClearSelectionButton.setDisable(true);

            // clear out the toppings list
            toppings.clear();

            // list out the pre-set toppings for the deluxe pizza
            toppings.add("Green Pepper");
            toppings.add("Mushroom");
            toppings.add("Onion");
            toppings.add("Pepperoni");
            toppings.add("Sausage");

            // now display the toppings list
            ChoiceToppingList.setItems(FXCollections.observableArrayList(toppings));
        }
        else
        {
            // change the pizza size to the default medium
            PizzaSizeDropDown.getSelectionModel().clearSelection();
            PizzaSizeDropDown.setValue(null);
            PizzaSizeDropDown.setValue("Medium (12\")");

            // change the image to the hawaiian pizza
            Image hawaiianPizza = new Image("sample/HawaiianPizza.jpg");
            PizzaImage.setImage(hawaiianPizza);

            // since this is a pre-set pizza, don't let the customer change the ingredients
            AddToppingButton.setDisable(true);
            RemoveToppingButton.setDisable(true);
            ClearSelectionButton.setDisable(true);

            // clear out the toppings list
            toppings.clear();

            // list out the pre-set toppings for the hawaiian pizza
            toppings.add("Ham");
            toppings.add("Pineapple");

            // now display the toppings list
            ChoiceToppingList.setItems(FXCollections.observableArrayList(toppings));
        }
    } // pizzaTypeChange()

    /**
     * This method adds toppings to the Build-Your-Own Pizza.
     */
    public void addTopping()
    {
        String toppingChoice = allToppingsList.getSelectionModel().getSelectedItem();
        if (toppingChoice == null)
        {
            OutPutArea.appendText("ERROR: Please first choose a topping from the Toppings List to add to the pizza.\n\n");
        }
        else
        {
            if (toppings.size() < MAXTOPPINGS)
            {
                if (toppings.contains(toppingChoice))
                {
                    OutPutArea.appendText("ERROR: You may only choose a topping at most once.\n\n");
                }
                else
                {
                    toppings.add(toppingChoice);
                    ChoiceToppingList.setItems(FXCollections.observableArrayList(toppings));
                }
            }
            else
            {
                OutPutArea.appendText("ERROR: You may only choose up to 6 toppings.\n\n");
            }
        }
    } // addTopping()

    /**
     * This method removes toppings from the Build-Your-Own Pizza.
     */
    public void removeToppings()
    {
        if (toppings.size() == EMPTY)
        {
            OutPutArea.appendText("ERROR: There are no toppings in the Selected Toppings List to be removed.\n\n");
            return;
        }

        String toppingToRemove = ChoiceToppingList.getSelectionModel().getSelectedItem();
        if (toppingToRemove == null)
        {
            OutPutArea.appendText("ERROR: Please first choose a topping from the Selected Toppings List to remove from the pizza.\n\n");
        }
        else
        {
            toppings.remove(toppingToRemove);
            ChoiceToppingList.setItems(FXCollections.observableArrayList(toppings));
        }
    } // removeToppings()

    /**
     * This method will clear all the selected toppings for the Build-Your-Own Pizza.
     */
    public void clearAllToppings()
    {
        toppings.clear();
        ChoiceToppingList.setItems(FXCollections.observableArrayList(toppings));
    } // clearAllToppings()

    /**
     * This method adds a new Pizza to the main order.
     */
    public void addToOrder()
    {
        String typeOfPizza = PizzaTypeDropDown.getSelectionModel().getSelectedItem();
        String sizeOfPizza = PizzaSizeDropDown.getSelectionModel().getSelectedItem();
        if (toppings.size() < MINTOPPINGS)
        {
            OutPutArea.appendText("ERROR: Need to add at least 1 topping on to the pizza.\n\n");
            return;
        }
        ArrayList<String> pizzaToppings = new ArrayList<>();
        int i = 0;
        while (i < toppings.size())
        {
            pizzaToppings.add(toppings.get(i));
            i++;
        }

        if (typeOfPizza.equals("Deluxe"))
        {
            DeluxePizza newPizza = new DeluxePizza(typeOfPizza,sizeOfPizza,pizzaToppings);
            pizzaOrder.add(newPizza);
            OutPutArea.appendText("Your new pizza has been added to the order.\n\n");

            // set the pizza type to the default: Build-Your-Own
            PizzaTypeDropDown.setValue("Build Your Own");
            pizzaTypeChange();
        }
        else if (typeOfPizza.equals("Hawaiian"))
        {
            HawaiianPizza newPizza = new HawaiianPizza(typeOfPizza,sizeOfPizza,pizzaToppings);
            pizzaOrder.add(newPizza);
            OutPutArea.appendText("Your new pizza has been added to the order.\n\n");

            // set the pizza type to the default: Build-Your-Own
            PizzaTypeDropDown.setValue("Build Your Own");
            pizzaTypeChange();
        }
        else
        {
            BuildYourOwnPizza newPizza = new BuildYourOwnPizza(typeOfPizza,sizeOfPizza,pizzaToppings);
            pizzaOrder.add(newPizza);
            OutPutArea.appendText("Your new pizza has been added to the order.\n\n");

            // set the pizza type to the default: Build-Your-Own
            PizzaTypeDropDown.setValue("Build Your Own");
            pizzaTypeChange();
        }
    } // addToOrder()

    /**
     * This method will change the view of the GUI and load a new stage that will show the entire order and total cost.
     */
    public void OrderView(ActionEvent event) throws IOException
    {
        // set up the loader
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("TotalOrderStage.fxml"));
        Parent tableViewParent = loader.load();

        // set up the scene
        Scene tableViewScene = new Scene(tableViewParent);

        // access the controller and send the total order of pizzas
        TotalOrderStageController controller = loader.getController();
        controller.getOrder(pizzaOrder);

        // open the new window and set the scene
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(tableViewScene);
        window.show();
    } // OrderView()

    public void getOrder(ArrayList<Pizza> order)
    {
        pizzaOrder = order;
    }
} // MainStageController
