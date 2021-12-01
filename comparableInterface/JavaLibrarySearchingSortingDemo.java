package comparableInterface;

import java.util.ArrayList;
import java.util.Collections;

public class JavaLibrarySearchingSortingDemo {

	public static void main(String[] args) {
		Country country1 = new Country("Belgium", 30510);
		Country country2 = new Country("Thailand", 514000);
		Country country3 = new Country("Uruguay", 176220);

		ArrayList<Country> countries = new ArrayList<>();
		countries.add(country1);
		countries.add(country2);
		countries.add(country3);

		Collections.sort(countries);
		System.out.println(countries);

		System.out.println(country1.compareTo(country2));
	}

}
