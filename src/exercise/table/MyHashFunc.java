package exercise.table;

import datastructure.table.HashFunc;

public class MyHashFunc<Key> implements HashFunc<Key> {
	public int getHashValue(Key key) {
		return (Integer)key % 100;
	}
}
