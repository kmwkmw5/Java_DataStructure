package exercise.queue;
import datastructure.queue.*;

public class CircularQueueMain {

	public static void main(String[] args) {
		CircularQueue<Integer> q = new CircularQueue<Integer>();

		q.enqueue(1);
		q.enqueue(2);
		q.enqueue(3);
		q.dequeue();
		q.enqueue(4);
		q.enqueue(5);
		
		while(!q.isEmpty())
			System.out.print(q.dequeue() + " ");
	}

}
