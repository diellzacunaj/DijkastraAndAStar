package aStarExtended;

public class VertexStar extends Vertex{

	int cost2;
	int finalCost;
	public VertexStar(String id, String label,int cost2) {
		super(id, label);
		// TODO Auto-generated constructor stub
		this.cost2=cost2;
	}

}
