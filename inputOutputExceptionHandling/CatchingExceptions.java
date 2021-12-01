package inputOutputExceptionHandling;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class CatchingExceptions {

	public static void main(String[] args) {
		try {
			String fileName = "input.txt";
			Scanner in = new Scanner(new File(fileName));
			String input = in.next();
			int value = Integer.parseInt(input);
		} catch (FileNotFoundException e) { // check exception, required to either catch or throws
			System.out.println("The file was not found.");
		} catch (NoSuchElementException c) { // unchecked exception, not required to catch or throws
			System.out.println("The file was empty.");
		} catch (NumberFormatException e) { // unchecked exception, not required to catch or throws
			System.out.println("Input was not a number.");
		}
	}

}
