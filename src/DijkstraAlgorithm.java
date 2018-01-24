import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

import edu.princeton.cs.algs4.MinPQ;

public class DijkstraAlgorithm {

	List<Vertex> vertices;
	List<Edge> edges;
	private HashSet<Vertex> settledNodes;
	private MinPQ<Vertex> queue;

	public DijkstraAlgorithm(Graph g) {
		vertices = new ArrayList<>(g.vertices);
		edges = new ArrayList<>(g.edges);
		settledNodes = new HashSet<>();
		queue = new MinPQ<>();
	}
	public void execute(Vertex source) {
		source.cost = 0;
		queue.insert(source);
		while (queue.size() > 0) {
			Vertex node = queue.delMin();
			settledNodes.add(node);
			getMinimumPath(node);
		}
	}
	public void getMinimumPath(Vertex node) {
		ArrayList<Vertex> neighbours = neighbours(node);
		for (Vertex target : neighbours) {
			if (getCost(target) > getCost(node) + getWeight(node, target)) {
				target.cost = getCost(node) + getWeight(node, target);
				target.parent = node;
				queue.insert(target);
			}
		}
	}
	public LinkedList<Vertex> getPath(Vertex dest) {
		if (dest == null) {
			return null;
		}
		LinkedList<Vertex> stack = new LinkedList<Vertex>();

		Vertex step = dest;
		stack.push(step);
		while (step.parent != null) {
			stack.push(step.parent);
			step = step.parent;
		}
		System.out.println("Cost:" + dest.cost);
		return stack;
	}
	private int getWeight(Vertex node, Vertex target) {
		for (Edge edge : edges) {
			if (edge.source.equals(node) && edge.destination.equals(target)) {
				return edge.weight;
			}
		}
		throw new RuntimeException("Error on getting weight.");
	}

	private int getCost(Vertex node) {

		if (node.cost == null)
			return Integer.MAX_VALUE;
		else
			return node.cost;
	}

	public ArrayList<Vertex> neighbours(Vertex node) {
		ArrayList<Vertex> neighbours = new ArrayList<>();
		for (Edge edge : edges) {
			if (edge.source.equals(node) && !settledNodes.contains(edge.destination)) {
				neighbours.add(edge.destination);
			}
		}
		return neighbours;
	}
}
