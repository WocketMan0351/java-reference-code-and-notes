package collections;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class QueueDemo {

	public static void main(String[] args) {
		System.out.println("QUEUE: ");

		// first in, first out
		Queue<Integer> q = new LinkedList<>();

		q.add(1); // adds to the tail of the queue
		q.add(2);
		q.add(3);

		System.out.println(q);

		int head = q.remove(); // removes the head of the queue
		System.out.println(q);

		head = q.peek(); // gets the head of the queue without removing it
		System.out.println(head);

		System.out.println();

		System.out.println("PRIORITY QUEUE: ");

		// priority queues collects elements that also have a priority
		// NOT first in, first out
		// PRIORITY = 1 IS THE MOST URGENT
		PriorityQueue<Integer> pq = new PriorityQueue<>();

		pq.add(3); // adds values to the priority queue
		pq.add(1); // priority 1 is the most urgent
		pq.add(2);

		System.out.println(pq);

		int first = pq.remove(); // removes the most urgent item
		System.out.println("Removed most urgent: " + first);
	}

}
