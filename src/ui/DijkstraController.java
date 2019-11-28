package ui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.Pane;

public class DijkstraController {

    @FXML
    private MenuItem closeButton;

    @FXML
    private Pane newPane;

    @FXML
    void back(ActionEvent event) {
    	Alert e = new Alert(AlertType.INFORMATION);
    	e.setContentText("Este boton deberia cerrar la ventana pero no funciona, porfavor usa la X");
    	e.show();
    }
    @FXML
   void initialize() {
    	GraphController.dibujarNodos(newPane);
    }

}
