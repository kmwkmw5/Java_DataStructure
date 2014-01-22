package exercise.stack;
import datastructure.stack.*;

public class ListBaseStackMain {
	public static void main(String[] args) {
		ListBaseStack<Integer> stack = new ListBaseStack<Integer>();

		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.pop();
		stack.pop();
		stack.push(4);
		stack.push(5);
		
		while(!stack.isEmpty()) {
			System.out.print(stack.pop() + " ");
		}
	}
}
