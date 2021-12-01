package collections;

// everything in collections is iterable

import java.util.Map;
import java.util.TreeMap;

public class MapDemo {

	public static void main(String[] args) {
		// maps are useful for counting how often an item occurs
		Map<String, Integer> scores = new TreeMap<>();

		scores.put("Harry", 90); // adds keys and values to the map
		scores.put("Sally", 95); // can also change a key-value association

		int n = scores.get("Sally"); // gives the value of the key if key is present
		Integer n2 = scores.get("Bob"); // n2 is null if the key is not present

		System.out.println(n); // prints the value of the key (95)

		System.out.println();

		// iterates through all map keys and values
		for (String key : scores.keySet()) {
			Integer value = scores.get(key);
			System.out.println(value);
		}

		scores.remove("Sally"); // removes the key and value
	}

}
