package aStarExtended;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class Test {
	static List<VertexStar> nodes;
	static List<Edge> edges;

	public static void main(String[] args) {

		nodes = new ArrayList<VertexStar>();
		edges = new ArrayList<Edge>();
	
		

		nodes.add(new VertexStar("A", "A", 1));
		nodes.add(new VertexStar("B", "B",3));
		nodes.add(new VertexStar("C", "C", 5));
		nodes.add(new VertexStar("D", "D", 2));
		
		nodes.add(new VertexStar("E", "E", 4));
		nodes.add(new VertexStar("F", "F", 2));
		nodes.add(new VertexStar("G", "G", 0));
	

		
		
		addLane("Edge_0", "A", "B", 16);
		addLane("Edge_1", "A", "D", 35);
		addLane("Edge_2", "A", "C", 9);
		
		addLane("Edge_3", "B", "E", 25);
		addLane("Edge_4", "B", "D", 12);
		
		addLane("Edge_5", "D", "E", 14);
		addLane("Edge_6", "D", "G", 19);
		addLane("Edge_7", "D", "F", 17);
		
		addLane("Edge_8", "C", "D", 15);
		
		addLane("Edge_9", "C", "F", 22);
		
		addLane("Edge_10", "E", "G", 8);
		addLane("Edge_11", "F", "G", 14);
		

		// Lets check from location Loc_1 to Loc_10
		Graph graph = new Graph(nodes, edges);
		AStarAlgorithm astar = new AStarAlgorithm(graph);
		astar.execute(get("A"));
		LinkedList<VertexStar> path = astar.getPath(get("G"));
		System.out.print("Path: ");
		for (VertexStar vertex : path) {
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
	
	private static VertexStar get(String label) {
		for (VertexStar v: nodes)
			if (v.id.equals(label))
				return v;
		return null;
	}

}
