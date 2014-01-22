package datastructure.stack;
import datastructure.list.Node;

public class ListBaseStack<T> implements Stack<T> {
	private Node<T> head;
	
	public ListBaseStack() {
		head = new Node<T>();
	}
	
	public boolean isEmpty() {
		if(head.next == null)
			return true;
		return false;
	}
	
	public void push(T data) {
		Node<T> newNode = new Node<T>(data, head.next);
		head.next = newNode;
	}
	
	public T pop() {
		if(isEmpty()) {
			System.out.println("Stack is null! pop() will return null!");
			return null;
		}
		T temp = head.next.data;
		head.next = head.next.next;
		return temp;
	}
	
	public T peek() {
		if(isEmpty()) {
			System.out.println("Stack is null! peek() will return null!");
			return null;
		}
		T temp = head.next.data;
		return temp;
	}
}
