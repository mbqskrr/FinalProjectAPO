package ui;
import java.util.Arrays;

import javafx.fxml.FXML;
import javafx.scene.text.Text;


public class FloydController {

    @FXML
    private Text t;
	
@FXML
void initialize() {
	t.setText("Test");
	String tS = "";
	double[][]matriz = GraphController.getMatrix();
	System.out.println(matriz.length);
	for (int x=0; x < matriz.length; x++) {
		tS+=" "+x+"\t";
		  for (int y=0; y < matriz[x].length; y++) {
			int toChange = (int)matriz[x][y];
			matriz[x][y]=toChange;
			tS +="|"+matriz[x][y]+"|"+"   ";
	}	tS +=""+x;
		  tS+="\n";
	
		
		}
		System.out.println(tS);
	t.setText(tS);
	}

}
