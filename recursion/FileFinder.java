package recursion;

import java.io.File;
import java.util.Scanner;

public class FileFinder {

	static int counter = 0;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("Desktop, Documents, or Downloads? ");
		String parent = in.nextLine();

		System.out.print("Child directory in " + parent + ": ");
		String child = in.nextLine();

		System.out.print("File Extension: ");
		String ext = in.nextLine();

		in.close();

		System.out.println("/Users/codyworthen/" + parent + "/" + child);
		File startingDirectory = new File("/Users/codyworthen/" + parent + "/" + child);

		find(startingDirectory, ext);

		System.out.println(counter + " " + ext + " files found.");
	}

	public static void find(File aFile, String extension) {
		if (aFile.isDirectory()) {
			for (File child : aFile.listFiles()) {
				find(child, extension);
			}
		} else {
			String fileName = aFile.toString();
			if (fileName.endsWith(extension)) {
				System.out.println(fileName);
				counter++;
			}
		}
	}
}
