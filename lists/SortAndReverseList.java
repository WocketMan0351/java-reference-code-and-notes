package lists;

import java.util.List;
import java.util.Arrays;
import java.util.Collections;

public class SortAndReverseList {
	public static void main(String[] args) {
		List<Integer> grades = Arrays.asList(2, 11, 5, 7);
		
		// sorts in ascending order
		Collections.sort(grades);
		
		for (int grade : grades) {
			System.out.print(grade + " ");
		}
		
		System.out.println();
		
		// sorts in descending order
		Collections.reverse(grades);
		
		for (int grade : grades) {
			System.out.print(grade + " ");
		}
	}
}
