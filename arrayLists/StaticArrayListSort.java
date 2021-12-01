package arrayLists;

import java.util.ArrayList;
import java.util.Collections;

public class StaticArrayListSort {

	public static void main(String[] args) {
		ArrayList<String> names = new ArrayList<>();

		names.add("Bella");
		names.add("Chloe");
		names.add("Tank");
		names.add("Alyssa");

		System.out.println("Before: " + names);

		Collections.sort(names);

		System.out.println("After: " + names);

		System.out.println();

		// lamba expression
		names.forEach((item) -> {
			System.out.println(item);
		});
	}
}
