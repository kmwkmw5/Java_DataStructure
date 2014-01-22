package datastructure.graph;

import datastructure.list.LinkedList;
import datastructure.table.Table;
import datastructure.stack.ArrayBaseStack;
import datastructure.queue.CircularQueue;

public class ALGraph {
	private int numOfVertex;
	private int numOfEdge;
	private Table<Vertex, LinkedList<Vertex>> vtxTable;
	private Table<Vertex, Boolean> visitInfo;
	
	public ALGraph(int nv) {
		numOfVertex = nv;
		numOfEdge = 0;
		vtxTable = new Table<Vertex, LinkedList<Vertex>>(new HashFuncByVertex());
		visitInfo = new Table<Vertex, Boolean>(new HashFuncByVertex());
		
		// vtxTable: LinkedList 초기화, visitInfo: 방문정보 초기화
		int i=0; // nv만큼 할당하고 빠져나오기 위한 변수
		for(Vertex v: Vertex.values()) {
			vtxTable.insert(v, new LinkedList<Vertex>());
			visitInfo.insert(v, false);
			i++;
			if(i==numOfVertex) break;
		}
	}
	
	public int getNumOfVertex() {
		return numOfVertex;
	}
	public int getNumOfEdge() {
		return numOfEdge;
	}
	
	public void addEdge(Vertex fromV, Vertex toV) {
		vtxTable.search(fromV).insert(toV);
		vtxTable.search(toV).insert(fromV);
		numOfEdge++;
	}
	
	public void showGraphEdgeInfo() {
		int i=0;
		for(Vertex v: Vertex.values()) {
			LinkedList<Vertex> vtxList = vtxTable.search(v);
			if(vtxList.count() > 0) {
				System.out.print(v + "와 연결된 정점: ");
				
				System.out.print(vtxList.first() + " ");
				for(int j=1; j<vtxList.count(); j++) {
					System.out.print(vtxList.next() + " ");
				}
				System.out.println();
			}
			i++;
			if(i==numOfVertex) break;
		}
	}
	
	private boolean visitVertex(Vertex visitV) {
		if(!visitInfo.search(visitV)) {
			visitInfo.modify(visitV, true);
			System.out.print(visitV + " ");
			return true;
		}
		else {
			return false;
		}
	}
	
	public void dfsShowGraphVertex(Vertex startV) {
		ArrayBaseStack<Vertex> stack = new ArrayBaseStack<Vertex>();
		Vertex visitV = startV;
		Vertex nextV;
		
		visitVertex(visitV);
		//stack.push(visitV);
		
		while(vtxTable.search(visitV).count() > 0) {
			nextV = vtxTable.search(visitV).first();
			boolean visitFlag = false;
			
			if(visitVertex(nextV)) {
				stack.push(visitV);
				visitV = nextV;
				visitFlag = true;
			}
			else {
				for(int i=1; i<vtxTable.search(visitV).count(); i++) {
					nextV = vtxTable.search(visitV).next();
					if(visitVertex(nextV)) {
						stack.push(visitV);
						visitV = nextV;
						visitFlag = true;
						break;
					}
				}
			}
			
			if(!visitFlag) {
				if(stack.isEmpty())
					break;
				else {
					visitV = stack.pop();
				}
			}
		}
		
		// 탐색 정보 초기화
		int i=0; // nv만큼 할당하고 빠져나오기 위한 변수
		for(Vertex v: Vertex.values()) {
			visitInfo.insert(v, false);
			i++;
			if(i==numOfVertex) break;
		}
		System.out.println();
	}
	
	public void bfsShowGraphVertex(Vertex startV) {
		CircularQueue<Vertex> queue = new CircularQueue<Vertex>();
		Vertex visitV = startV;
		Vertex nextV;
		
		visitVertex(visitV);
		
		while(vtxTable.search(visitV).count() > 0) {
			nextV = vtxTable.search(visitV).first();
			
			if(visitVertex(nextV))
				queue.enqueue(nextV);
			
			for(int i=1; i<vtxTable.search(visitV).count(); i++) {
				nextV = vtxTable.search(visitV).next();
				if(visitVertex(nextV))
					queue.enqueue(nextV);
			}
			
			if(queue.isEmpty())
				break;
			else
				visitV = queue.dequeue();
		}
		

		// 탐색 정보 초기화
		int i=0; // nv만큼 할당하고 빠져나오기 위한 변수
		for(Vertex v: Vertex.values()) {
			visitInfo.insert(v, false);
			i++;
			if(i==numOfVertex) break;
		}
		System.out.println();
	}
}
