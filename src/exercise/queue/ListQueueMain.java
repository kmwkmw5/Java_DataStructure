package exercise.queue;
import datastructure.queue.*;

public class ListQueueMain {

	public static void main(String[] args) {
		ListQueue<Integer> q = new ListQueue<Integer>();

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
