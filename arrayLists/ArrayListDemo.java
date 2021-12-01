package arrayLists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayListDemo {
	public static void main(String[] args) {
		List<Integer> numbers = new ArrayList<Integer>();
		
		// appending elements, returning elements from array list
		numbers.add(5);
		numbers.add(11);
		System.out.println("index 1 is: " + numbers.get(1));
		
		numbers.add(1, 10); // inserts 10 into index 1, pushing everything after index 1 to the right
		System.out.println("index 1 is: " + numbers.get(1));
		System.out.println("doing the above shifted " + numbers.get(2) + " to index 2");
		
		// find the index of a value in an array list
		System.out.println("the index of 11 is " + numbers.indexOf(11));
		
		// remove an element from the list
		System.out.println("the element we're removing is " + numbers.remove(2));
		
		// clear()
		numbers.clear(); 
		
		// isEmpty()
		if (numbers.isEmpty()) {
			System.out.println("EMPTY");
		}
		
		//.contains()
		if (!numbers.contains(666)) {
			System.out.println("666 not found");
		}

		// quickly add elements to the list
		numbers = Arrays.asList(1, 2, 3);
		
		// print a list in one line using these 2 methods
		System.out.println(Arrays.toString(numbers.toArray()));
		
		
		
	}
}
