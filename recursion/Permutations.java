package recursion;

import java.util.ArrayList;
import java.util.Scanner;

public class Permutations {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("Word: ");
		String word = in.next();
		System.out.println();

		int counter = 0;

		for (String s : permutations(word)) {
			System.out.println(s);
			counter++;
		}

		System.out.println();
		System.out.println(counter + " permutations");
	}

	public static ArrayList<String> permutations(String word) {
		ArrayList<String> result = new ArrayList<String>();

		if (word.length() == 1) {
			result.add(word);
			return result;
		} else {
			for (int i = 0; i < word.length(); i++) {
				// form a shorter word by removing i'th char
				String shorter = word.substring(0, i) + word.substring(i + 1);

				// generation all permutations of the shorter word
				ArrayList<String> shorterPermutations = permutations(shorter);

				// add the removed character to the front of each permutation of the shorter
				// word
				for (String s : shorterPermutations) {
					result.add(word.charAt(i) + s);
				}
			}
			// return all permutations
			return result;
		}
	}
}