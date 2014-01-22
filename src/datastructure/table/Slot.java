package datastructure.table;

public class Slot<Key, Value> {
	public enum Status {EMPTY, DELETED, INUSE}
	
	private Key key;
	private Value value;
	private Status status;
	
	public Slot() {
		key = null;
		value = null;
		status = Status.EMPTY;
	}
	public Slot(Key key, Value value, Status status) {
		this.key = key;
		this.value = value;
		this.status = status;
	}
	
	public Key getKey() {
		return key;
	}
	public Value getValue() {
		return value;
	}
	public Status getStatus() {
		return status;
	}
	
	public void setKey(Key key) {
		this.key = key;
	}
	public void setValue(Value value) {
		this.value = value;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
}
