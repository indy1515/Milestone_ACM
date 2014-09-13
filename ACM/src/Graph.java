import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Graph {
	
	private Map<String, Vertex> vertices = new HashMap<String, Vertex> ();
	public PriorityQueue<Vertex> pq = new PriorityQueue<Vertex>(200, new Vertex());
	
	public void addVertex(String source, String dest, int weight) {
		Vertex v = getVertex(source);
		Vertex w = getVertex(dest);
		v.adjacentD.add(new Edge(w, weight));
		w.adjacentD.add(new Edge(v, weight));
	}
	
	private Vertex getVertex(String name) {
		Vertex v = (Vertex) vertices.get(name);
		if(v == null) {
			v = new Vertex(name);
			vertices.put(name, v);
		}
		return v;
	}
	
	public void dijkstra (String init) {
		Vertex current;
		Vertex start = (Vertex) vertices.get(init);
		start.setWeight(0);
		pq.add(start);
		int handled = 0;
		while (handled < vertices.size()) {
			current = pq.poll();
			//weight associated with the current vertex
			int vertWeight = current.getWeight();
			if(current.known == false) {
				handled++;
				current.known = true;
				compAdjEdges(current, vertWeight);
//				System.out.format("%-15s", current.name);
				System.out.format("%-4d", (int)current.weight);
				printPath(current);
				System.out.println();
			}
		}
	}
	
//	public void dijkstra (String init, String dest) {
//		Vertex current;
//		Vertex start = (Vertex) vertices.get(init);
//		Vertex end = (Vertex) vertices.get(dest);
//		start.setWeight(0);
//		pq.add(start);
//		int handled = 0;
//		while (handled < vertices.size()) {
//			current = pq.poll();
//			//weight associated with the current vertex
//			int vertWeight = current.getWeight();
//			compAdjEdges(current, vertWeight);
//			if (current.equals(end)) {
//				System.out.format("%-15s", current.name);
//				System.out.format("total weight: %-8d", (int)current.weight);
//				printPath(current);
//				System.out.println();
//				break;
//			}
//		}
//	}
	
	public void compAdjEdges(Vertex s, int w) {
		Vertex source = s;
		int vertWeight = w;
		int tempDist;
		int origDist;
		/* Each adjacent edge to the source Vertex,
		* (if it has not yet been handled) 
		* has a weight which is added to the current pathWeight.
		* If this pathWeight is smaller than the one associated with
		* the given edge's vertex (destination.getWeight())
		* then the vertex's weight is updated and this path is 
		* added to the priority queue
		*/
		for(Edge e : source.adjacentD) {
			Edge curEdge = e;
			Vertex curVer = e.getDestination();
			origDist = curVer.getWeight();
			if (curVer.known == false) {
				tempDist = curEdge.getWeight();
				tempDist = tempDist + vertWeight;
				if (tempDist < origDist) {
					curVer.setWeight(tempDist);
					curVer.previous = source;
					pq.add(curVer);
				}
			}
		}
	}

	public void printPath(Vertex c) {
		Vertex current = c;
		if (current.previous != null) {
			printPath(current.previous);
			System.out.print("-");
			System.out.print(current.name);
		}
		if (current.previous == null) {
			System.out.print(current.name);
		}
	}
	
}