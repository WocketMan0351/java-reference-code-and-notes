package inputOutputExceptionHandling;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class WordGuesser {

	public static void main(String[] args) throws FileNotFoundException {
		ArrayList<String> words = readWords();
		String word = pickWord(words);
		String guesses = "";

		Scanner in = new Scanner(System.in);

		System.out.println("Guess a word:");
		System.out.println("(" + word + ")");
		System.out.println();

		in.close();
	}

	private static ArrayList<String> readWords() throws FileNotFoundException {
		ArrayList<String> words = new ArrayList<String>();

		File inputFile = new File("/Users/codyworthen/Documents/Java Review/Files/bip39.txt");
		Scanner in = new Scanner(inputFile);

		while (in.hasNext()) {
			words.add(in.next());
		}

		System.out.println("I know " + words.size() + " words");

		in.close();
		return words;
	}

	private static String pickWord(ArrayList<String> list) {
		return list.get((int) Math.round(Math.random() * list.size())).toLowerCase();
	}

}
