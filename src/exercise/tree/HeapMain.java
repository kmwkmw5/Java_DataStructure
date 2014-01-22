package exercise.tree;
import datastructure.tree.*;

public class HeapMain {
	public static void main(String[] args) {
		Heap<Character> heap = new Heap<Character>();
		
		heap.insert('A', 1);
		heap.insert('B', 2);
		heap.insert('C', 3);
		System.out.println(heap.delete());
		
		heap.insert('D', 1);
		heap.insert('E', 2);
		heap.insert('F', 3);
		
		while(!heap.isEmpty())
			System.out.println(heap.delete());
	}
}
