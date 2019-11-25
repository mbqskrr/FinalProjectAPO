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
		System.out.println((double)Math.random()*(1-700)+700);
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		this.stage = stage;
		
		Parent root = FXMLLoader.load(getClass().getResource("Graphs.fxml"));
		
		Scene scene = new Scene(root);
		
		this.stage.setTitle("Graphs");
		this.stage.setScene(scene);
		this.stage.show();
		// Detectar ratón pulsado
        scene.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                // Insertar aquí el código a ejecutar cuando se pulse el ratón
                System.out.println("Mouse pressed X: " +mouseEvent.getX() + " " + mouseEvent.getY());
            }
        });

	}
	
}