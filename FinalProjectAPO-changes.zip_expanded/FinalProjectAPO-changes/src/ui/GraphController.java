package ui;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.AdjacencyMatrix;
import model.Edge;
import model.GraphAlgorithms;
import model.IGraph;

public class GraphController {

    @FXML
    private MenuItem dijkstra;

    @FXML
    private MenuItem floyd;

    @FXML
    private Pane pane;
    
    @FXML
    private Label coordenates;
    
    private  Graph g;
    
    private  Node node;
    
    private  Circle c;
    
    private  Text t;
    
    public static double[][]matrix;
    
    private IGraph<String> graph;
    @FXML
    void initialize() {
    	try {
			g = new Graph();
			g.loadCoordenates();
			g.loadPaths();
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
	    		
			}print();
			
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
		for (int i = 0; i < g.getPaths().size()&&!found;i++) {
			if(nd1.getId().equals(g.getPaths().get(i).getN1())){
				if(nd2.getId().equals(g.getPaths().get(i).getN2())){
					tR = ""+g.getPaths().get(i).getWeight();
				}
			}
		}return tR;
	}

	private Node search(String dat) {
		int n = g.getNodes().size();
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
    @FXML
    void runDjkstra(ActionEvent event) {
    	graph =new AdjacencyMatrix<String>();
    	for (int i = 0; i < g.getNodes().size(); i++) {
    		graph.addVertex(g.getNodes().get(i).getId());	
		}
    	for (int i = 0; i < g.getPaths().size(); i++) {
			String n1 =g.getPaths().get(i).getN1();
			String n2 =g.getPaths().get(i).getN2();
			double w = g.getPaths().get(i).getWeight();
			System.out.println("Iteracion"+i+" Nodo 1:"+n1+" Nodo 2: "+n2+" Peso: "+w);
			graph.addEdge(n1, n2,w);			
    	}
    	GraphAlgorithms.dijkstra("Santiago", graph);
    	printGraphMatrix(graph);
    }
    private void printGraphMatrix(IGraph<String> matriz) {
    	System.out.println(graph.getEdges());
    	String[] data=new String[graph.getVertexSize()];;
    	for (int i = 0; i < graph.getVertexSize(); i++) {
    		String toAdd = graph.getEdges().get(i).toString();
    		System.out.println("Dato en la "+i+" "+toAdd);
    		data[i]=toAdd;
		}
    	try {
    		save(data);
			startDijkstra();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

		private void save(String[] data) {
			try {
				String save = "";
				for (int i = 0; i < data.length; i++) {
					save +=data[i]+"\n";
				}
				PrintWriter pw = new PrintWriter(new File("data/DijkstraCoords.txt"));
				pw.write(save);
				pw.close();
			} catch (FileNotFoundException e) {
				
			}
			
		}

	@FXML
    void runFloyd(ActionEvent event) throws Exception {
    	graph =new AdjacencyMatrix<String>();
    	for (int i = 0; i < g.getNodes().size(); i++) {
    		graph.addVertex(g.getNodes().get(i).getId());	
		}
    	for (int i = 0; i < g.getPaths().size(); i++) {
			String n1 =g.getPaths().get(i).getN1();
			String n2 =g.getPaths().get(i).getN2();
			double w = g.getPaths().get(i).getWeight();
			graph.addEdge(n1, n2,w);			
    	}
    	double[][]w =GraphAlgorithms.floydWarshall(graph);
    	matrix = w;
    	startFloyd();
   }

    public static double[][] getMatrix() {
		return matrix;
	}
	public void startDijkstra() throws Exception {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Dijkstra.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setTitle("Dijkstra");
        stage.setScene(new Scene(root1));
        stage.setMaximized(true);
        stage.show();

	}
	public void startFloyd() throws Exception {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Floyd.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setTitle("Floyd");
        stage.setScene(new Scene(root1));
        stage.setResizable(false);
        stage.setHeight(500);
        stage.setWidth(1000);
        stage.show();

	}
	
}
