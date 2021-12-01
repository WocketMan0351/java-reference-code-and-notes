package comparableInterface;

import java.util.Arrays;
import java.util.Comparator;

public class ComparatorDemo {
	public static void main(String[] args) {
		String[] words = { "Mary", "had", "a", "litle", "lamb" };
		Arrays.sort(words, (v, w) -> v.length() - w.length());
		System.out.println(Arrays.toString(words));
		System.out.println();

		Country[] countries = new Country[3];
		countries[0] = new Country("Uruguya", 176220);
		countries[1] = new Country("Thailand", 513120);
		countries[2] = new Country("Belgium", 30510);

		// doesn't require Country to implement Comparable
		Arrays.sort(countries, (Comparator.comparing(c -> c.getArea())));
		System.out.println(Arrays.toString(countries));
	}
}
