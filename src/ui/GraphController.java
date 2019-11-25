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
			g.loadPaths();
			int n= g.getNodes().size();
			for (int i = 0; i < n; i++) {
	    		node = g.getNodes().get(i);
	    		double x = node.getX();
	    		double y = node.getY();
	    		t = new Text(x-12, y-12, g.getNodes().get(i).getId());
	    		c = new Circle(x, y, 10,Color.RED);
	    		pane.getChildren().add(c);
	    		pane.getChildren().add(t);
	    		print();
	    		
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	

    	
    }

	private void print() throws IOException {
    	String n1,n2;
    	int tam = g.getPaths().size();
    	for (int i = 0; i < tam; i++) {
			n1 = g.getPaths().get(i).getN1();
			n2 = g.getPaths().get(i).getN2();
			System.out.println(n1+" "+n2);
			search(n1,n2);
			}
    	}

	private void search(String n1, String n2) {
		Node nd1 = search(n1);
		Node nd2 = search(n2);
		if(nd1==null||  nd2==null) {
			System.out.println("Aqui esta");
		}else {
			double x1=0,y1=0,x2=0,y2=0;
			x1 = nd1.getX();
			y1 = nd1.getY();
			x2 = nd2.getX();
			y2 = nd2.getX();
			System.out.println("x1: "+x1+"x2: "+x2+"y1: "+y1+"y2: "+y2);
			Line l = new Line(x1, y1, x2, y2);
			pane.getChildren().add(l);
		}
		
		
		
	}

	private Node search(String dat) {
		int n = g.getNodes().size();
		Node n1=null;
		for (int i = 0; i < n ; i++) {
			if(dat.equals(g.getNodes().get(i).getId())) {
				n1=g.getNodes().get(i);
			}
		}
		return n1;
	}
		  
}
