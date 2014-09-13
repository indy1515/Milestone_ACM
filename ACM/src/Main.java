import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		
		String initial = null;
		String destination = null;
		Graph graph = new Graph();
		String current;
		Scanner sc = new Scanner(new File("src/input.txt"));
		
		int nodes = sc.nextInt();
		int edges = sc.nextInt();
		sc.nextInt();
		
		for (int i=0; i<edges; i++) {
			
			current = sc.next();
			String source = current;
			String dest = sc.next();
			int weight = sc.nextInt();
			sc.next();
			graph.addVertex(source, dest, weight);
			graph.addVertex(dest, source, weight);
			
		}
		
		initial = "" + 3;
		destination = "" + 1;
		graph.dijkstra(initial);
		
	}
}