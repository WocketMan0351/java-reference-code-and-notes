package fileReader;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileWriterDemo {
	public static void main(String[] args) throws IOException {
		File example = new File("/Users/codyworthen/Desktop/Java Review/Files/example.txt");

		Scanner in = new Scanner(example);

		String exampleContent = "";

		// scans example.txt and stores it in a string called exampleContent
		while (in.hasNextLine()) {
			exampleContent = exampleContent.concat(in.nextLine() + "\n");
		}

		// writer writes a string into a new file called newfile.txt
		FileWriter writer = new FileWriter("/Users/codyworthen/Desktop/Java Review/Files/newfile.txt");
		writer.write(exampleContent);

		// prevents memory leaks
		writer.close();
		in.close();

		//

		// READING FROM OUR NEWLY CREATED FILE
		File newFile = new File("/Users/codyworthen/Desktop/Java Review/Files/newfile.txt");

		Scanner in2 = new Scanner(newFile);

		String newFileContent = "";

		// scans newfile.txt and stores it in a string called newFileContent
		while (in2.hasNextLine()) {
			newFileContent = newFileContent.concat(in2.nextLine() + "\n");
		}

		// prints newfile.txt
		System.out.println(newFileContent);

		// prevents memory leaks
		in2.close();
	}
}
