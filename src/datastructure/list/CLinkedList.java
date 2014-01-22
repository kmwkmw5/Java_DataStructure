package datastructure.list;
public class CLinkedList<T> {
	protected Node<T> tail;
	protected Node<T> cur;
	protected Node<T> before;
	protected int numOfData;
	
	public CLinkedList() {
		tail = null;
		cur = null;
		before = null;
		numOfData = 0;
	}

	public void insert(T data) {
		Node<T> newNode = new Node<T>(data);
		
		if(tail==null) {
			newNode.next = newNode;
			tail = newNode;
			cur = tail.next;
		}
		else {
			newNode.next = tail.next;
			tail.next = newNode;
			tail = newNode; // 유일한 차이점
		}

		numOfData++;
	}
	public void insertFront(T data) {
		Node<T> newNode = new Node<T>(data);
		
		if(tail==null) {
			newNode.next = newNode;
			tail = newNode;
			cur = tail.next;
		}
		else {
			newNode.next = tail.next;
			tail.next = newNode;
		}

		numOfData++;
	}
	public T first() {
		if(numOfData == 0) {
			System.out.println("List null!!! first() will return null");
			return null;
		}
		before = tail;
		cur = before.next;
		return cur.data;
	}
	public T next() {
		if(cur.next.equals(null))
			return null;
		before = cur;
		cur = before.next;
		return cur.data;
	}
	public T remove() {
		if(cur == tail) {
			if(numOfData == 1)
				tail = null;
			else
				tail = before;
		}
		T temp = cur.data;
		before.next = cur.next;
		cur = before;
		numOfData--;
		return temp;
	}
	public int count() {
		return numOfData;
	}
}