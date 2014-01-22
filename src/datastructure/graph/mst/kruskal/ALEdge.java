package datastructure.graph.mst.kruskal;

import datastructure.graph.Vertex;

public class ALEdge {
	private Vertex v1;
	private Vertex v2;
	private int weight;
	
	public Vertex getV1() {
		return v1;
	}
	public Vertex getV2() {
		return v2;
	}
	public int getWeight() {
		return weight;
	}
	public void setV1(Vertex v1) {
		this.v1 = v1;
	}
	public void setV2(Vertex v2) {
		this.v2 = v2;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
}
