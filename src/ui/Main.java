package ui;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class Main extends Application{
	
	private Stage stage;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		this.stage = stage;
		
		Parent root = FXMLLoader.load(getClass().getResource("Graphs.fxml"));
		
		Scene scene = new Scene(root);
		
		this.stage.setTitle("Graphs");
		this.stage.setScene(scene);
		this.stage.setMaximized(true);
		this.stage.show();

	}
	
}