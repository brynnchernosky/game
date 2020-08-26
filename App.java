package FinalProject;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * 
 * Creates the stage and sets the scene for the entire game.
 *
 */

public class App extends Application {

    //public App() {
        // Constructor code goes here.
    //}
	
    @Override
    public void start(Stage stage) throws Exception {
    	PaneOrganizer organizer = new PaneOrganizer();
   		Scene scene = new Scene(organizer.getRoot(), Constants.APP_X, Constants.APP_Y);
    	stage.setMinWidth(Constants.APP_X);
    	stage.setMaxWidth(Constants.APP_X);
    	stage.setMinHeight(Constants.APP_Y);
    	stage.setMaxHeight(Constants.APP_Y);
    	stage.setScene(scene);
    	stage.setTitle("Game!");
     	stage.show();
    }

    public static void main(String[] args) {
        launch(args); // launch is a method inherited from Application
    }
}
