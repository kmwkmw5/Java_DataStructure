package datastructure.table;

public class HashFuncByIndex<Key> implements HashFunc<Key> {
	public int getHashValue(Key key) {
		return (Integer)key;
	}
}
