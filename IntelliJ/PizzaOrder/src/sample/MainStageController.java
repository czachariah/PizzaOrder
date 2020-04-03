package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Modality;
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
    public final int WIDTH = 975;
    public final int LENGTH = 630;

    ArrayList<Pizza> pizzaOrder = new ArrayList<>();

    public ArrayList<String> toppings = new ArrayList<>();
    public ArrayList<String> selectedToppings = new ArrayList<>();

    public final int EMPTY = 0;
    public final int MIN_TOPPINGS = 1;
    public final int MAX_TOPPINGS = 6;

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
        // set the pizza type to the default: Build-Your-Own
        PizzaTypeDropDown.setValue("Build Your Own");
        pizzaTypeChange();

        allToppingsList.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        ChoiceToppingList.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
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

            // re-populate
            toppings.clear();

            // make sure to give the customer their selection
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

            // clear out the toppings list
            selectedToppings.clear();

            // now display the toppings list
            ChoiceToppingList.setItems(FXCollections.observableArrayList(selectedToppings));
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

            // clear out the toppings list
            toppings.clear();
            selectedToppings.clear();

            // don't let the customers get any choice to change the toppings (all pre-selected)
            allToppingsList.setItems(FXCollections.observableArrayList(toppings));

            // list out the pre-set toppings for the deluxe pizza
            selectedToppings.add("Green Pepper");
            selectedToppings.add("Mushroom");
            selectedToppings.add("Onion");
            selectedToppings.add("Pepperoni");
            selectedToppings.add("Sausage");

            // now display the toppings list
            ChoiceToppingList.setItems(FXCollections.observableArrayList(selectedToppings));
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

            // clear out the toppings list
            toppings.clear();
            selectedToppings.clear();

            // don't let the customers get any choice to change the toppings (all pre-selected)
            allToppingsList.setItems(FXCollections.observableArrayList(toppings));

            // list out the pre-set toppings for the hawaiian pizza
            selectedToppings.add("Ham");
            selectedToppings.add("Pineapple");

            // now display the toppings list
            ChoiceToppingList.setItems(FXCollections.observableArrayList(selectedToppings));
        }
    } // pizzaTypeChange()

    /**
     * This method adds toppings to the Build-Your-Own Pizza.
     */
    public void addTopping()
    {
        ObservableList<String> toppingChoice = allToppingsList.getSelectionModel().getSelectedItems();
        if (toppingChoice == null || toppingChoice.size() == 0)
        {
            OutPutArea.clear();
            OutPutArea.appendText("ERROR: Please first choose a topping from the Toppings List to add to the pizza.");
        }
        else
        {
            ArrayList<String> temp = new ArrayList<>();
            for (String s: toppingChoice)
            {
                temp.add(s);
            }

            while(selectedToppings.size() < MAX_TOPPINGS && temp.size() != 0)
            {
                selectedToppings.add(temp.get(0));
                ChoiceToppingList.setItems(FXCollections.observableArrayList(selectedToppings));
                toppings.remove(temp.remove(0));
                allToppingsList.setItems(FXCollections.observableArrayList(toppings));
            }

            if (temp.size() != 0)
            {
                OutPutArea.clear();
                OutPutArea.appendText("ERROR: You may only choose up to 6 toppings.");
                temp.clear();
            }
        }
    } // addTopping()

    /**
     * This method removes toppings from the Build-Your-Own Pizza.
     */
    public void removeToppings()
    {
        ObservableList<String> toppingChoice = ChoiceToppingList.getSelectionModel().getSelectedItems();
        if (selectedToppings.size() == EMPTY)
        {
            OutPutArea.clear();
            OutPutArea.appendText("ERROR: There are no toppings in the Selected Toppings List to be removed.");
            return;
        }

        if (toppingChoice == null || toppingChoice.size() == 0)
        {
            OutPutArea.clear();
            OutPutArea.appendText("ERROR: Please first choose a topping from the Selected Toppings List to remove from the pizza.");
        }
        else
        {
            ArrayList<String> temp = new ArrayList<>();
            for (String s: toppingChoice)
            {
                temp.add(s);
            }

            while (temp.size() != 0)
            {
                selectedToppings.remove(temp.get(0));
                ChoiceToppingList.setItems(FXCollections.observableArrayList(selectedToppings));
                toppings.add(temp.remove(0));
                allToppingsList.setItems(FXCollections.observableArrayList(toppings));
            }
        }
    } // removeToppings()

    /**
     * This method will clear the current selection and set everything back to the default.
     */
    public void clearCurrentSelection()
    {
        // set the pizza type to the default: Build-Your-Own
        PizzaTypeDropDown.setValue("Build Your Own");
        pizzaTypeChange();
    } // clearCurrentSelection()

    /**
     * This method adds a new Pizza to the main order.
     */
    public void addToOrder()
    {
        String typeOfPizza = PizzaTypeDropDown.getSelectionModel().getSelectedItem();
        String sizeOfPizza = PizzaSizeDropDown.getSelectionModel().getSelectedItem();
        if (selectedToppings.size() < MIN_TOPPINGS)
        {
            OutPutArea.clear();
            OutPutArea.appendText("ERROR: Need to add at least 1 topping on to the pizza.");
            return;
        }
        ArrayList<String> pizzaToppings = new ArrayList<>();
        int i = 0;
        while (i < selectedToppings.size())
        {
            pizzaToppings.add(selectedToppings.get(i));
            i++;
        }

        if (typeOfPizza.equals("Deluxe"))
        {
            Deluxe newPizza = new Deluxe(typeOfPizza,sizeOfPizza,pizzaToppings);
            pizzaOrder.add(newPizza);
            OutPutArea.clear();
            OutPutArea.appendText("Your new pizza has been added to the order.");

            // set the pizza type to the default: Build-Your-Own
            PizzaTypeDropDown.setValue("Build Your Own");
            pizzaTypeChange();
        }
        else if (typeOfPizza.equals("Hawaiian"))
        {
            Hawaiian newPizza = new Hawaiian(typeOfPizza,sizeOfPizza,pizzaToppings);
            pizzaOrder.add(newPizza);
            OutPutArea.clear();
            OutPutArea.appendText("Your new pizza has been added to the order.");

            // set the pizza type to the default: Build-Your-Own
            PizzaTypeDropDown.setValue("Build Your Own");
            pizzaTypeChange();
        }
        else
        {
            BuildYourOwn newPizza = new BuildYourOwn(typeOfPizza,sizeOfPizza,pizzaToppings);
            pizzaOrder.add(newPizza);
            OutPutArea.clear();
            OutPutArea.appendText("Your new pizza has been added to the order.");

            // set the pizza type to the default: Build-Your-Own
            PizzaTypeDropDown.setValue("Build Your Own");
            pizzaTypeChange();
        }
    } // addToOrder()

    /**
     * This method will change the view of the GUI and load a new stage that will show the entire order and total cost.
     */
    public void OrderView() throws IOException
    {
        // set up the loader
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("TotalOrderStage.fxml"));
        Parent tableViewParent = loader.load();

        // access the controller and pass the reference to the total order of pizzas
        TotalOrderStageController controller = loader.getController();
        controller.getOrder(pizzaOrder);
        loader.setController(controller);

        // set up the scene
        Scene tableViewScene = new Scene(tableViewParent,WIDTH,LENGTH);

        // make new stage
        Stage newStage = new Stage();
        newStage.setTitle("Pizza Orders");
        controller.setStage(newStage);

        // make and show the new popup window
        newStage.initModality(Modality.WINDOW_MODAL);
        newStage.setScene(tableViewScene);
        newStage.showAndWait();

    } // OrderView()
} // MainStageController