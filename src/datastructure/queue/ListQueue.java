package datastructure.queue;
import datastructure.list.Node;

public class ListQueue<T> {
	private Node<T> front;
	private Node<T> rear;
	
	public ListQueue() {
		front = null;
		rear = null;
	}
	
	public boolean isEmpty() {
		if(front == null && rear == null)
			return true;
		return false;
	}
	
	public void enqueue(T data) {
		Node<T> newNode = new Node<T>(data);
		if(isEmpty()) {
			front = newNode;
			rear = newNode;
		}
		else {
			rear.next = newNode;
			rear = newNode;
		}
	}

	public T dequeue() {
		if(isEmpty()) {
			System.out.println("dequeue() Error: Queue is Empty! dequeue() will return null!");
			return null;
		}
		T temp = front.data;
		front = front.next;
		if(front == null)
			rear = null;
		return temp;
	}
	
	public T peek() {
		if(isEmpty()) {
			System.out.println("peek() Error: Queue is Empty! peek() will return null!");
			return null;
		}
		T temp = front.data;
		return temp;
	}
}
