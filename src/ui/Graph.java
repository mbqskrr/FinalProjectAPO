package ui;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Graph {
	
	private ArrayList<Node>nodes;
	
	public Graph() {
		nodes = new ArrayList<Node>();
	}
	public boolean loadFile() throws IOException {
		boolean loaded= false;
		File f = new File("data/data.txt");
		FileReader fr = new FileReader(f);
		BufferedReader br = new BufferedReader(fr);
		String line = br.readLine();
		while(line != null) {
			String[] parts = line.split("");
			if(line.charAt(0)!='#') {
			String n1 = parts[0];
			String n2 = parts[1];
			double w = Integer.parseInt(parts[2]);
			}
			line = br.readLine();
		}
		
		br.close();
		fr.close();
		loaded = true;
		return loaded;
	}
		
		

}
