package datastructure.list;
public class DBNode<T> {
	public T data;
	public DBNode<T> next;
	public DBNode<T> prev;
	
	public DBNode() {
		data = null;
		next = null;
		prev = null;
	}
	public DBNode(T data, DBNode<T> next, DBNode<T> prev) {
		this.data = data;
		this.next = next;
		this.prev = prev;
	}
	public DBNode(DBNode<T> next) {
		this.data = null;
		this.next = next;
		this.prev = null;
	}
	public DBNode(DBNode<T> next, DBNode<T> prev) {
		this.data = null;
		this.next = next;
		this.prev = prev;
	}
	public DBNode(T data) {
		this.data = data;
		this.next = null;
		this.prev = null;
	}
	public DBNode(T data, DBNode<T> next) {
		this.data = data;
		this.next = next;
		this.prev = null;
	}
}