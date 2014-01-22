package datastructure.graph;

import datastructure.table.HashFunc;

public class HashFuncByVertex implements HashFunc<Vertex> {
	public int getHashValue(Vertex key) {
		return key.getValue();
	}
}
