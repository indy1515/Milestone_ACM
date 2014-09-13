import java.util.Comparator;
import java.util.LinkedList;

public class Vertex implements Comparator<Vertex>{
	public String name;
	public LinkedList<Edge> adjacentD;
	public LinkedList<Vertex> adjacentT;
	public int weight;
	public Vertex previous; //previous vertex on shortest path
	public boolean known;
	public int defaultWeight = Integer.MAX_VALUE;
	
	public Vertex() {
		name = null;
		weight = defaultWeight;
		previous = null;
		known = false;
	}

	public Vertex(String argName) {
		this.name = argName;
		adjacentD = new LinkedList<Edge>();
		adjacentT = new LinkedList<Vertex>();
		weight = defaultWeight;
		previous = null;
		known = false;
	}
	
	public int getWeight() {
		return weight;
	}
	
	public void setWeight(int w) {
		weight = w;
	}
	
	public int compare(Vertex v1, Vertex v2) {
		int w1 = v1.getWeight();
		int w2 = v2.getWeight();
		if(w1 > w2)
			return 1;
		else if (w1 < w2)
			return -1;
		else
			return 0;
	}
	
}