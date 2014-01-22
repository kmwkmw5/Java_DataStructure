package datastructure.table;

public class Table<Key, Value> {
	private static final int MAX_TBL = 100;
	
	private Slot<Key, Value>[] tbl;
	private HashFunc<Key> hf;
	
	@SuppressWarnings("unchecked")
	public Table() {
		tbl = (Slot<Key, Value>[])new Slot[MAX_TBL];
		for(int i=0; i<tbl.length; i++) {
			tbl[i] = new Slot<Key, Value>();
		}
		this.hf = new HashFuncByIndex<Key>();
	}
	@SuppressWarnings("unchecked")
	public Table(HashFunc<Key> hf) {
		tbl = (Slot<Key, Value>[])new Slot[MAX_TBL];
		for(int i=0; i<tbl.length; i++) {
			tbl[i] = new Slot<Key, Value>();
		}
		this.hf = hf;
	}
	
	public void insert(Key key, Value value) {
		int hv = hf.getHashValue(key);
		tbl[hv].setKey(key);
		tbl[hv].setValue(value);
		tbl[hv].setStatus(Slot.Status.INUSE);
	}
	
	public Value delete(Key key) {
		int hv = hf.getHashValue(key);
		if(tbl[hv].getStatus() != Slot.Status.INUSE)
			return null;
		else {
			tbl[hv].setStatus(Slot.Status.DELETED);
			return tbl[hv].getValue();
		}
	}
	
	public void modify(Key key, Value value) {
		int hv = hf.getHashValue(key);
		if(tbl[hv].getStatus() == Slot.Status.INUSE)
			tbl[hv].setValue(value);
	}
	
	public Value search(Key key) {
		int hv = hf.getHashValue(key);
		if(tbl[hv].getStatus() != Slot.Status.INUSE)
			return null;
		else {
			return tbl[hv].getValue();
		}
	}
}
