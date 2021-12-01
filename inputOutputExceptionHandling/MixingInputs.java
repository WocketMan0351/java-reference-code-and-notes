package inputOutputExceptionHandling;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MixingInputs {

	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("/Users/codyworthen/Desktop/Java Review/Files/words+numbers.txt");

		Scanner in = new Scanner(file);

		while (in.hasNext()) {
			String countryName = in.nextLine();
			int countryPopulation = in.nextInt();
			in.next(); // consumes the \n following each int so the in.nextLine() reads a countryName
			// string and not an int

			System.out.println(countryName);
			System.out.println(countryPopulation);
		}
	}

}
