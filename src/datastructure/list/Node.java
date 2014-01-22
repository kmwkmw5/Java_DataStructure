package datastructure.list;
public class Node<T> {
	public T data;
	public Node<T> next;
	
	public Node() {
		data = null;
		next = null;
	}
	public Node(T data, Node<T> next) {
		this.data = data;
		this.next = next;
	}
	public Node(Node<T> next) {
		this.data = null;
		this.next = next;
	}
	public Node(T data) {
		this.data = data;
		this.next = null;
	}
}