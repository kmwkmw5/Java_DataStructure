package datastructure.stack;

public interface Stack<T> {
	public boolean isEmpty();
	
	public void push(T data);
	public T pop();
	public T peek();
}
