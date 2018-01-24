package aStarExtended;
import java.util.ArrayList;
import java.util.List;

public class Graph {
	
	
	List<VertexStar> vertices;
	List<Edge> edges;
	
	
	public Graph(List<VertexStar> vertices,
	List<Edge> edges)
	{
		this.vertices=vertices;
		this.edges=edges;
	}

}
