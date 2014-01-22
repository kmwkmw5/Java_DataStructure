package datastructure.stack;
import java.util.ArrayList;

public class ArrayBaseStack<T> implements Stack<T> {
	private ArrayList<T> stackArr;
	private int topIndex;
	
	public ArrayBaseStack() {
		stackArr = new ArrayList<T>();
		topIndex = -1;
	}
	
	public boolean isEmpty() {
		if(topIndex == -1)
			return true;
		return false;
	}
	
	public void push(T data) {
		topIndex++;
		stackArr.add(topIndex, data);
	}
	
	public T pop() {
		if(isEmpty()) {
			System.out.println("Stack is null! pop() will return null!");
			return null;
		}
		T temp = stackArr.get(topIndex);
		topIndex--;
		return temp;
	}
	
	public T peek() {
		if(isEmpty()) {
			System.out.println("Stack is null! peek() will return null!");
			return null;
		}
		T temp = stackArr.get(topIndex);
		return temp;
	}
}
