package ui;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class FloydController {

    @FXML
    private Label shown;

@FXML
void initilize() {
	double[][]matriz = GraphController.getMatrix();
	shown.setText("Test");
	for (int x=0; x < matriz.length; x++) {
		  System.out.print("|");
		  for (int y=0; y < matriz[x].length; y++) {
			int toChange = (int)matriz[x][y];
			matriz[x][y]=toChange;
			shown.setText(""+matriz[x][y]);
		    if (y!=matriz[x].length-1) shown.setText("\t");
		  }
		  shown.setText("|");
	
	}
}
@FXML
void close(ActionEvent event) {
	System.exit(1);
}
}
