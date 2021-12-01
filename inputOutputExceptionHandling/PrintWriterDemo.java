package inputOutputExceptionHandling;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class PrintWriterDemo {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner console = new Scanner(System.in);

		System.out.print("Input file: ");
		String inputFileName = console.next();
		System.out.print("Output file: ");
		String outputFileName = console.next();

		File inputFile = new File("/Users/codyworthen/Desktop/Java Review/Files/" + inputFileName);
		Scanner in = new Scanner(inputFile);
		PrintWriter out = new PrintWriter("/Users/codyworthen/Desktop/Java Review/Files/" + outputFileName);

		double total = 0;
		while (in.hasNextDouble()) {
			double value = in.nextDouble();
			out.printf("%17.2f \n", value);
			total = total + value;
		}

		out.println();
		out.printf("Total: %10.2f \n", total);

		out.close();
		in.close();
		console.close();
	}

}
