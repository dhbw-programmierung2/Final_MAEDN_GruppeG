package launcher;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

/**
 * Diese Klasse ist verantwortlich, den Launcher auszufuehren.
 * 
 * @author Lukas, Kim, Isabelle, Jonas
 * @version 1.0
 */
public class MainLauncher extends Application {
	
	@Override
	public void start(Stage primaryStage) {
		
		/*
		 * Oeffnen des Launcherfensters.
		 */
		try {
			Parent root = FXMLLoader.load(getClass().getResource("Launcher.fxml")); 
	        primaryStage.setTitle("Auswahlfeld"); 
	        primaryStage.setScene(new Scene(root, 750, 450)); 
	        primaryStage.show(); 
		} catch(Exception e) {
			e.printStackTrace();
		}	
	}
		public static void main(String[] args) {
		launch(args);
	}
}
