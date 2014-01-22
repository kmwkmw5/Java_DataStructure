package datastructure.queue;

public class CircularQueue<T> implements Queue<T> {
	private int front;
	private int rear;
	private T[] CQueue;
	private static final int QUE_LEN = 100;
	
	@SuppressWarnings("unchecked")
	public CircularQueue() {
		front = 0;
		rear = 0;
		CQueue = (T[])new Object[QUE_LEN];
	}
	
	private int nextPosIdx(int pos) {
		if(pos >= QUE_LEN-1)
			return 0;
		else
			return ++pos;
	}
	
	public boolean isEmpty() {
		if(front == rear)
			return true;
		return false;
	}
	
	public boolean isFull() {
		if(nextPosIdx(rear) == front) {
			return true;
		}
		return false;
	}
	
	public void enqueue(T data) {
		if(isFull()) {
			System.out.println("enqueue() Error: Queue is Full!");
			return;
		}
		rear = nextPosIdx(rear);
		CQueue[rear] = data;
	}

	public T dequeue() {
		if(isEmpty()) {
			System.out.println("dequeue() Error: Queue is Empty! dequeue() will return null!");
			return null;
		}
		front = nextPosIdx(front);
		T temp = CQueue[front];
		CQueue[front] = null;
		return temp;
	}
	
	public T peek() {
		if(isEmpty()) {
			System.out.println("peek() Error: Queue is Empty! peek() will return null!");
			return null;
		}
		T temp = CQueue[nextPosIdx(front)];
		return temp;
	}
}
