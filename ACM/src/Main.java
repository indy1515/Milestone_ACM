import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	private static Graph createGraphFromArray(int g[][]) {
		Graph graph = new Graph();
		for (int i=0; i<g.length; i++) {
			for (int j=0; j<g[i].length; j++) {
				if (g[i][j] > 0) {
					graph.addEdge(""+i, ""+j, g[i][j]);
				}
			}
		}
		return graph;
	}

	public static void main(String[] args) throws FileNotFoundException {
		
		String initial = null;
		String destination = null;
		Graph graph = new Graph();
		Scanner sc = new Scanner(new File("src/input.txt"));
		
		int nodes = sc.nextInt();
		int edges = sc.nextInt();
		
		initial = "" + 1;
		destination = "" + nodes;
		
		//store data as array g[][]
		int g[][] = new int[nodes+1][nodes+1];
		for (int i=0; i<edges; i++) {
			
			int source = sc.nextInt();
			int dest = sc.nextInt();
			int weight = sc.nextInt();
			g[source][dest] = weight;
			g[dest][source] = weight;
			
		}
		//generate new graph
		graph = createGraphFromArray(g);
		
		String shortestPath = graph.dijkstra(initial, destination);
		System.out.println(shortestPath);
		int weightOri = Integer.parseInt(shortestPath.split(" ")[0].trim());
		String path[] = shortestPath.substring(shortestPath.indexOf(" ")+1).split("-");
		
		int weightArr[] = new int[path.length-1];
		
		for (int i = 0; i < path.length-1; i++) {
			
			//double specific part of the path
			int source = Integer.parseInt(path[i]);
			int dest = Integer.parseInt(path[i+1]);
			g[source][dest] *= 2;
			g[dest][source] *= 2;
			
			//generate new graph and find new shortest path
			Graph newGraph = createGraphFromArray(g);
			String newPath = newGraph.dijkstra(initial, destination);
			System.out.println(newPath);
			weightArr[i] = Integer.parseInt(newPath.split(" ")[0].trim());
			
			//change g[][] back to original
			g[source][dest] /= 2;
			g[dest][source] /= 2;
			
		}
		
		System.out.println(Arrays.toString(weightArr));
		
	}
	
	public static void print2DArr(int arr[][]) {
		
		System.out.println();
		for (int a[] : arr) {
			System.out.println(Arrays.toString(a));
		}
		
	}
}