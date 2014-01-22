package datastructure.table;

public interface HashFunc<Key> {
	public int getHashValue(Key key);
}
