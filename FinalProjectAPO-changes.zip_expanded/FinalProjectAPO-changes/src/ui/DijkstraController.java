package ui;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;

public class DijkstraController {

    @FXML
    private MenuItem closeButton;

    @FXML
    private Pane pane;

    private  Graph g;
    
    private  Node node;
    
    private  Circle c;
    
    private  Text t;
    
    private ArrayList<Path> p;
    
    @FXML
    void back(ActionEvent event) {
    	Alert e = new Alert(AlertType.INFORMATION);
    	e.setContentText("Este boton deberia cerrar la ventana pero no funciona, porfavor usa la X");
    	e.show();
    }
    @FXML
   void initialize() {
    	try {
    		p = new ArrayList<Path>();
			g = new Graph();
			g.loadCoordenates();
			g.merge();
			int n= g.getNodes().size();
			for (int i = 0; i < n; i++) {
	    		node = g.getNodes().get(i);
	    		double x = node.getX();
	    		double y = node.getY();
	    		t = new Text(x-12, y-12, g.getNodes().get(i).getId());
	    		c = new Circle(x, y, 10,Color.RED);
	    		pane.getChildren().add(c);
	    		pane.getChildren().add(t);    	
	    		
			}
			load();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
    	}
    
    void load() {
		try {
			File f = new File("data/DijkstraCoords.txt");
			FileReader fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);
			String line = br.readLine();
			while(line != null) {
				String[] parts = line.split(" ");
				String Node1 = parts[0];
				String Node2 = parts[1];
				String weight = parts[2];
				double w = Double.parseDouble(weight);
				p.add(new Path(Node1, Node2, w));
				line = br.readLine();
			}
			br.close();
			fr.close();
			print();
		} catch (IOException e) {
			e.printStackTrace();
		}

		}
 
    private void print() throws IOException {
    	String n1,n2;
    	int tam = p.size();
    	for (int i = 0; i < tam; i++) {
			n1 = p.get(i).getN1();
			n2 = p.get(i).getN2();
			search(n1,n2);
			}
    	}

	private void search(String n1, String n2) {
		Node nd1 = search(n1);
		Node nd2 = search(n2);
			double x1=0,y1=0,x2=0,y2=0;
			x1 = nd1.getX();
			y1 = nd1.getY();
			x2 = nd2.getX();
			y2 = nd2.getY();
			double pmX = ((Math.abs(x1+x2))/2);
			double pmY = ((Math.abs(y1+y2))/2);
			String toAdd = addText(nd1,nd2);
			Line l = new Line(x1, y1, x2, y2);
			Text t = new Text(pmX, pmY,toAdd);
			pane.getChildren().add(l);
			pane.getChildren().add(t);

			
	}


	private String addText(Node nd1, Node nd2) {
		boolean found = false;
		String tR = "RT";
		for (int i = 0; i < p.size()&&!found;i++) {
			if(nd1.getId().equals(p.get(i).getN1())){
				if(nd2.getId().equals(p.get(i).getN2())){
					tR = ""+p.get(i).getWeight();
				}
			}
		}return tR;
	}

	private Node search(String dat) {
		int n = p.size();
		Node n1=null;
		boolean found = false;
		for (int i = 0; i < n &&!found;i++) {
			String toS = g.getNodes().get(i).getId();
			if(dat.equalsIgnoreCase(toS)) {
				n1=g.getNodes().get(i);
				found = true;
			}
		}
		return n1;
	}
}
