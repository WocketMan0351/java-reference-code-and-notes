package trycatch;

import java.util.Scanner;

public class tryWithResources {

	public static void main(String[] args) {
		try (Scanner in = new Scanner("/Users/codyworthen/Documents/Java Review/Files/example.txt")) {
			while (in.hasNextLine()) {
				String input = in.nextLine();
				System.out.println(input);
				System.out.println();
			}
		} // in.close() is automatically closed here!
	}

}
