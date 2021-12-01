package basics;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadingCharacters {

	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("/Users/codyworthen/Desktop/Java Review/Files/example.txt");

		Scanner in = new Scanner(file);

		// using nothing as a delimiter is a workaround for the in.nextChar() which
		// doesn't exist
		in.useDelimiter("");

		int counter = 0;
		while (in.hasNext() && counter <= 10) {
			char ch = in.next().charAt(0);
			// process each character

			System.out.print(ch);
			counter++;
		}

	}

}
