package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * This is the Main class used to run the GUI.
 * @author Chris Zachariah (cvz2)
 * @author Anthony Topol (at877)
 */
public class Main extends Application {

    /**
     * This method sets up the main stage of the GUI and run it.
     * @param primaryStage is the main stage to run
     * @throws Exception an exception
     */
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("MainStage.fxml"));
        primaryStage.setTitle("Chris and Tony's Pizzeria");
        primaryStage.setScene(new Scene(root, 972, 740));
        primaryStage.setResizable(false);
        primaryStage.show();
    } // start()

    /**
     * This method launches the GUI.
     * @param args arguments
     */
    public static void main(String[] args) {
        launch(args);
    } // main()
} // Main
