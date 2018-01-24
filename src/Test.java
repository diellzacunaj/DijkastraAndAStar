

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Test {
	static List<Vertex> nodes;
	static List<Edge> edges;

	public static void main(String[] args) {

		nodes = new ArrayList<Vertex>();
		edges = new ArrayList<Edge>();
		for (char c = 'A'; c < 'H'; c++) {
			Vertex location = new Vertex(c+"", c+"");
			nodes.add(location);
			//System.out.println(location);
		}
		
		
		addLane("Edge_0", "A", "B", 3);
		addLane("Edge_1", "A", "C", 5);
		addLane("Edge_2", "A", "D", 2);
		addLane("Edge_3", "B", "E", 4);
		addLane("Edge_4", "E", "F", 20);
		addLane("Edge_5", "C", "E", 2);
		addLane("Edge_6", "D", "F", 10);
		addLane("Edge_7", "B", "G", 5);
		addLane("Edge_8", "G", "F", 2);
		
	//	nodes.add(new Vertex("S","S"));
		

	/*//	addLane("Edge_0", "S", "A", 7);
		addLane("Edge_1", "S", "B", 2);
		addLane("Edge_2", "S", "C", 3);
		addLane("Edge_3", "A", "B", 3);
		addLane("Edge_4", "A", "D", 4);
		addLane("Edge_5", "B", "D", 4);
		addLane("Edge_6", "B", "H", 1);
		addLane("Edge_7", "D", "F", 5);
		addLane("Edge_8", "F", "H", 3);
		addLane("Edge_9", "H", "G", 2);
		addLane("Edge_10", "G", "E", 2);
		addLane("Edge_11", "C", "L", 2);
		addLane("Edge_12", "L", "I", 4);
		addLane("Edge_13", "L", "J", 4);
		addLane("Edge_14", "I", "J", 6);
		addLane("Edge_15", "I", "K", 4);
		addLane("Edge_16", "J", "K", 4);
		addLane("Edge_17", "K", "E", 5);*/

		// Lets check from location Loc_1 to Loc_10
		Graph graph = new Graph(nodes, edges);
		DijkstraAlgorithm dijkstra = new DijkstraAlgorithm(graph);
		dijkstra.execute(get("A"));
		LinkedList<Vertex> path = dijkstra.getPath(get("F"));
		System.out.print("Path: ");
		for (Vertex vertex : path) {
			System.out.print(vertex);
		}
		System.out.println();
		
	}

	private static void addLane(String laneId, 
			String sourceLocNo, String destLocNo, int duration) {
		
		Edge lane = 
				new Edge(laneId, get(sourceLocNo), 
						get(destLocNo), duration);
		edges.add(lane);

	}
	
	private static Vertex get(String label) {
		for (Vertex v: nodes)
			if (v.id.equals(label))
				return v;
		return null;
	}

}
