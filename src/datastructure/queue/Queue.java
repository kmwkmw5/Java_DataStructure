package datastructure.queue;

public interface Queue<T> {
	public boolean isEmpty();
	public boolean isFull();
	
	public void enqueue(T data);
	public T dequeue();
	public T peek();
}
