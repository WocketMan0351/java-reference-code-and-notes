package collections;

import java.util.Stack;

public class StackDemo {

	public static void main(String[] args) {
		// last in, first out
		Stack<String> s = new Stack<>();

		s.push("A"); // adds to the top of the stack
		s.push("B");
		s.push("C");

		String peek = s.peek(); // gets the top of the stack without removing it
		System.out.println("peek: " + peek);

		System.out.println();

		while (s.size() > 0) {
			String pop = s.pop();
			System.out.print(pop + " "); // removes the top of the stack
		}
	}

}
