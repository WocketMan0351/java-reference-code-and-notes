package trycatch;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TryCatchExample {
	public static void main(String[] args) {
		int[] a = { 1, 2, 3 };

		try {
			String filename = "/Users/codyworthen/Documents/Java Review/Files/example.txt";
			Scanner in = new Scanner(new File(filename));
			String input = in.next();
			int value = Integer.parseInt(input);
		} catch (FileNotFoundException fnfe) {
			System.out.println("The file was not found.");
		} catch (NumberFormatException nfe) {
			System.out.println("Input was not a number!");
		} finally {
			System.out.println("Finally -- this code is always executed.");
		}
	}
}

// CHECKED EXCEPTIONS: Something has gone wrong beyond your control.
//					   Program will not compile unless you indicate how to handle checked exceptions.

// UNCHECKED EXCEPTIONS: Descendants of RuntimeException indicate errors in your code.
//						 Compiler does NOT check whether you handle these or not.
