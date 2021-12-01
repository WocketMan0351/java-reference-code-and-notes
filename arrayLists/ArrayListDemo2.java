package arrayLists;

import java.util.Arrays;
import java.util.List;

public class ArrayListDemo2 {
	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4);
		
		for (int i = 0; i < numbers.size(); i++) {
			numbers.set(i, numbers.get(i) * 2);
			System.out.print(numbers.get(i) + " ");
		}
		
		System.out.println();
		
		for (int number : numbers) {
			System.out.print(number + " ");
		}
	}
}
