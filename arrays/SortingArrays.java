package arrays;

import java.util.Arrays;

public class SortingArrays {
	public static void main(String[] args) {
		int[] grades = { 1, 2, 3, 99, 4 };
		Arrays.sort(grades);
		System.out.println(Arrays.toString(grades));

		int[] numbers = { 1, 2, 3, 99, 4 };
		Arrays.parallelSort(numbers); // best for working with very large arrays
		System.out.println(Arrays.toString(numbers));

	}
}
