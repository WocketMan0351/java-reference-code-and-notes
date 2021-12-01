package collections;

// everything in collections is iterable

import java.util.LinkedList;
import java.util.ListIterator;

public class LinkedListDemo {

	// LinkedLists are efficient for adding and removing elements from a list.
	// LinkedLists are inefficient for visiting arbitrary elements of a list because
	// you must do so sequentially

	public static void main(String[] args) {
		LinkedList<Integer> numbers = new LinkedList<>();

		numbers.add(1);
		numbers.add(2);
		numbers.add(3);
		numbers.add(4);

		numbers.getFirst();
		numbers.getLast();

		numbers.addFirst(7); // adds element to the beginning
		numbers.removeFirst(); // removes first element
		numbers.removeLast(); // removes last element

		// think of iterators as a 'cursor' pointing between two elements like a cursor
		// in a word processor
		ListIterator<Integer> iter = numbers.listIterator(); // ListIterator is a generic type

		// traverses all elements in a LinkedList
		while (iter.hasNext()) {
			int num = iter.next();
			System.out.println(num);
		}

		System.out.println();

		// traverses all elements in a LinkedList
		// uses an iterator behind the scenes in the for loop
		for (int num : numbers) {
			System.out.println(num);
		}

		// ListIterator methods
		// iter.next();
		iter.hasNext(); // returns true if iterator isn't at end of list
		iter.hasPrevious(); // returns true if iterator isn't at beginning of list
		iter.set(null); // updates the last element returned by next or previous
		iter.add(null); // adds element before iterator position
	}

}
