package searching;

import java.util.Arrays;

public class StaticArraySearch {

	public static void main(String[] args) {
		int[] grades = { 1, 2, 3, 99, 4 };

		int n = 99; // int to search for

		System.out.print(n + " is found at position: ");
		System.out.print(Arrays.binarySearch(grades, n));
	}

}
