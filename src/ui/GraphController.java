package ui;

import java.io.IOException;
import java.util.Arrays;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;

public class GraphController {

    @FXML
    private MenuItem dijkstra;

    @FXML
    private MenuItem floyd;

    @FXML
    private Pane pane;
    
    @FXML
    private Label coordenates;
    
    private Graph g;
    
    private Node node;
    
    private Circle c;
    
    private Text t;
    
    @FXML
    void initialize() {
    	try {
			g = new Graph();
			g.loadCoordenates();
			int n= g.getNodes().size();
			for (int i = 0; i < n; i++) {
	    		node = g.getNodes().get(i);
	    		double x = node.getX();
	    		double y = node.getY();
	    		t = new Text(x-12, y-12, g.getNodes().get(i).getId());
	    		c = new Circle(x, y, 10,Color.RED);
	        	g.loadCoordenates();
	        	String n1,n2;
	        	double x1=0,x2=0,y1=0,y2=0;
	        	int tam = g.getPaths().size();
	        	for (int i1 = 0; i < tam; i++) {
	        		System.out.println("Int");
	    			n1 = g.getPaths().get(i1).getN1();
	    			n2 = g.getPaths().get(i1).getN2();
	    			System.out.println(n1+" "+n2);
	    			if(n1.equals(g.getNodes().get(i1).getId())) {
	    				 x1 = g.getNodes().get(i1).getX();
	    				 y1 = g.getNodes().get(i1).getY();
	    			if((n2.equals(g.getNodes().get(i1).getId()))) {
	    				 x2 = g.getNodes().get(i1).getX();
	    				 y2 = g.getNodes().get(i1).getY();
	    			}
	    			}
	    			Line linea = new Line(x1, y1, x2, y2);
	    			pane.getChildren().add(linea);
	        	}
	    		pane.getChildren().add(c);
	    		pane.getChildren().add(t);
	    		
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	

    	
    }

  
}
