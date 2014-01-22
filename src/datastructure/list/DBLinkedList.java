package datastructure.list;
public class DBLinkedList<T> {
	protected DBNode<T> head;
	protected DBNode<T> tail;
	protected DBNode<T> cur;
	protected int numOfData;
	
	public DBLinkedList() {
		head = new DBNode<T>();
		tail = new DBNode<T>();
		cur = null;
		numOfData = 0;
		
		head.next = tail;
		tail.prev = head;
	}

	public void insert(T data) {
		DBNode<T> newNode = new DBNode<T>(data, tail, tail.prev);
		tail.prev.next = newNode;
		tail.prev = newNode;
		numOfData++;
	}
	public void insertFront(T data) {
		DBNode<T> newNode = new DBNode<T>(data, head.next, head);
		head.next.prev = newNode;
		head.next = newNode;
		numOfData++;
	}
	public T first() {
		if(numOfData == 0) {
			System.out.println("List null!!! first() will return null");
			return null;
		}
		cur = head.next;
		return cur.data;
	}
	public T next() {
		if(cur.next.equals(tail))
			return null;
		cur = cur.next;
		return cur.data;
	}
	public T previous() {
		if(cur.prev.equals(head))
			return null;
		cur = cur.prev;
		return cur.data;
	}
	public T remove() {
		T temp = cur.data;
		cur.prev.next = cur.next;
		cur.next.prev = cur.prev;
		cur = cur.prev;
		numOfData--;
		return temp;
	}
	public int count() {
		return numOfData;
	}
}