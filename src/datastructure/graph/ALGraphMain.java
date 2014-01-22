package datastructure.graph;

public class ALGraphMain {
	public static void main(String[] args) {
		ALGraph graph = new ALGraph(7);

		graph.addEdge(Vertex.A, Vertex.B);
		graph.addEdge(Vertex.A, Vertex.D);
		graph.addEdge(Vertex.B, Vertex.C);
		graph.addEdge(Vertex.D, Vertex.C);
		graph.addEdge(Vertex.D, Vertex.E);
		graph.addEdge(Vertex.E, Vertex.F);
		graph.addEdge(Vertex.E, Vertex.G);
		
		graph.showGraphEdgeInfo();
		
		graph.dfsShowGraphVertex(Vertex.A);
		graph.dfsShowGraphVertex(Vertex.C);
		graph.dfsShowGraphVertex(Vertex.E);
		graph.dfsShowGraphVertex(Vertex.G);
		System.out.println();
		
		graph.bfsShowGraphVertex(Vertex.A);
		graph.bfsShowGraphVertex(Vertex.C);
		graph.bfsShowGraphVertex(Vertex.E);
		graph.bfsShowGraphVertex(Vertex.G);
	}
}
