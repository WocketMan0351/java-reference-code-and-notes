package recursion;

import java.util.Arrays;

public class RecursiveArrayMin {

	public static void main(String[] args) {
		int[] array = { 99, 888, 62, 77, 91, 927, 409, 1, 127, 8000 };

		System.out.println(Arrays.toString(array));
		System.out.println(min(array));
	}

	public static int min(int[] array) {
		return min(array, 0, array.length - 1);
	}

	public static int min(int[] array, int start, int end) {
		if (start == end) {
			return array[start];
		}

		if (array[start] <= array[end]) {
			end -= 1;
		}

		else {
			start += 1;
		}

		return min(array, start, end);
	}

}
