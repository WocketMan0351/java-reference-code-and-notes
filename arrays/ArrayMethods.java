package arrays;

import java.util.Arrays;
import java.util.List;

public class ArrayMethods {
	public static void main(String[] args) {
		int[] grades1 = {1, 2, 3, 72, 5};
		int[] grades2 = {1, 2, 3, 72, 5};
		
		if (Arrays.equals(grades1, grades2)) {	// method to check if Arrays are equal in size
			System.out.println("equal");		// and contain the same corresponding elements
		}
		
		// method to fill an array with a value
		int[] numbers = new int[3];
		Arrays.fill(numbers, 3);
		System.out.println(Arrays.toString(numbers));
		
		// Arrays.asList
		List<int[]> scores = Arrays.asList(numbers);
	}
}
