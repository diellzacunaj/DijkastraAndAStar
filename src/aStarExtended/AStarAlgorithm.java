package aStarExtended;

import java.util.ArrayList;

public class AStarAlgorithm extends DijkstraAlgorithm
{

	public AStarAlgorithm(Graph g) {
		super(g);
	
	}

	public void getMinimumPath(Vertex node) {
		ArrayList<VertexStar> neighbours = neighbours(node);
	
		for (VertexStar target : neighbours) {
		
			if (getCost(target) > getCost(node) + getWeight(node, target)+getCost2(target)) {
				target.cost=getCost(node) + getWeight(node, target);
				target.finalCost = getCost(node) + getWeight(node, target)+getCost2(target);
			
				target.parent = node;
				queue.insert(target);
			}
		
		}
	}
		
	private int getCost2(VertexStar node)
	{
		return node.cost2;
	}
	
}
