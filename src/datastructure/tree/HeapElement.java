package datastructure.tree;

public class HeapElement<T> {
	private T data;
	private int priority; // 작을 수록 높은 우선순위
	
	public HeapElement(T data, int priority) {
		this.data = data;
		this.priority = priority;
	}
	public T getData() {
		return data;
	}
	public int getPriority() {
		return priority;
	}
}
