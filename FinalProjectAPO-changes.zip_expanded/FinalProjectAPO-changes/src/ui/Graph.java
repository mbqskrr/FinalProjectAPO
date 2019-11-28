package ui;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Graph {
	
	private ArrayList<Node>nodes;
	
	private ArrayList<String> cityName;	
	
	private ArrayList<Path>paths;
	
	public Graph() {
		nodes = new ArrayList<Node>();
		cityName = new ArrayList<String>();
		paths = new ArrayList<Path>();
	}
	public boolean loadCityName() throws IOException {
		boolean loaded= false;
		File f = new File("data/CityName.txt");
		FileReader fr = new FileReader(f);
		BufferedReader br = new BufferedReader(fr);
		String line = br.readLine();
		while(line != null) {
			String[] parts = line.split(" ");
			if(line.charAt(0)!='#') {
			String id = parts[0];
			double idI = Integer.parseInt(id);
			String dat = parts[1];
			cityName.add(dat);
			}
			line = br.readLine();
			
		}
		
		br.close();
		fr.close();
		loaded = true;
		return loaded;
	}
	public boolean loadCoordenates() throws IOException {
		boolean loaded= false;
		File f = new File("data/Coordenates.txt");
		FileReader fr = new FileReader(f);
		BufferedReader br = new BufferedReader(fr);
		String line = br.readLine();
		while(line != null) {
			String[] parts = line.split(" ");
			if(line.charAt(0)!='#') {
			String xC = parts[1];
			double x = Double.parseDouble(xC);
			String yC = parts[2];
			double y = Double.parseDouble(yC);
			String idS = parts[0];
			nodes.add(new Node(x, y, idS));
			}
			line = br.readLine();
		}
		
		br.close();
		fr.close();
		loaded = true;
		loadCityName();
		return loaded;
	}
		
	public void merge() {
		for (int i = 0; i < nodes.size(); i++) {
			nodes.get(i).setId(cityName.get(i));
		}
	}
	
	public ArrayList<Node> getNodes() {
		return nodes;
	}
	
	public boolean loadPaths() throws IOException {
		boolean loaded= false;
		File f = new File("data/data.txt");
		FileReader fr = new FileReader(f);
		BufferedReader br = new BufferedReader(fr);
		String line = br.readLine();
		while(line != null) {
			String[] parts = line.split(" ");
			if(line.charAt(0)!='#') {
			String Node1 = parts[0];
			String Node2 = parts[1];
			String weight = parts[2];
			double w = Double.parseDouble(weight);
			paths.add(new Path(Node1,Node2,w));
			}
			line = br.readLine();
		}
		
		br.close();
		fr.close();
		loaded = true;
		loadCityName();
		return loaded;
	}
	
	public ArrayList<Path> getPaths() {
		return paths;
	}
		
}
