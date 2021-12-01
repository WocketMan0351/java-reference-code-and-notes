package bmp;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

// BLUE 0-7
// GREEN 8-15
// RED 16-23

public class BMPEditor {

	public static void main(String[] args) {
		System.out.println("Sepia-o-matic - Cody Worthen");
		System.out.println();

		System.out.println("Warning: Your file will be modified!");
		System.out.print("Filename: ");

		Scanner in = new Scanner(System.in);
		String fileName = in.next();
		System.out.println();
		in.close();

		NumberFormat format = NumberFormat.getInstance(Locale.US);

		byte[] tempArray = new byte[4];

		String headerField = "";
		Long byteLength = Long.valueOf(0);
		String reserve1 = "";
		String reserve2 = "";
		int offset = 0;

		int headerSize = 0;
		String widthString = "";
		int width = 0;

		RandomAccessFile file = null;

		int counter = 0;

		try {
			file = new RandomAccessFile(fileName, "rw");

			System.out.println("Loading... (this may take several seconds)");

			boolean done = false;
			while (!done) {
				int next = file.read();
				System.out.println("byte " + counter + ": " + Integer.toBinaryString(next));

				if (file.getFilePointer() >= 2 && file.getFilePointer() <= 5) {
					System.out.println("byte (reversed) " + counter + ": " + Integer.toBinaryString(next));
					System.out.println();
				}

				counter++;

				if (next == -1) {
					done = true;
				} else if (file.getFilePointer() <= 2) {
					headerField += Integer.toHexString(next);
				} else if (file.getFilePointer() >= 7 && file.getFilePointer() <= 8) {
					reserve1 += Integer.toHexString(next);
				} else if (file.getFilePointer() >= 9 && file.getFilePointer() <= 10) {
					reserve2 += Integer.toHexString(next);
				} else if (file.getFilePointer() == 11) {
					offset = next;
				} else if (file.getFilePointer() == 15) {
					headerSize = next;
				} else if (file.getFilePointer() >= 19 && file.getFilePointer() <= 21) {
					widthString += Integer.toString(next);
					if (file.getFilePointer() == 21) {
						width = Integer.parseInt(widthString);
					}
				} else if (file.getFilePointer() > 50) {
					done = true;
				}
			}

			byteLength = file.length();

			file.close();
		} catch (IOException e) {
			System.out.println(e);
			System.exit(0);
		}

		try {
			System.out.println();
			System.out.println("File");
			System.out.println(String.format("%24s 0x%s (BMP File)", "HeaderField:", headerField));
			System.out.println(String.format("%24s %s %s", "Size:", format.format(byteLength), "bytes"));
			System.out.println(String.format("%24s 0x%s", "Reserve-1:", reserve1));
			System.out.println(String.format("%24s 0x%s", "Reserve-2:", reserve2));
			System.out.println(String.format("%24s %s", "Offset:", Integer.toString(offset)));
			System.out.println();

			System.out.println("DIB");
			System.out.println(String.format("%24s %s", "dibHeaderSize:", Integer.toString(headerSize)));
			System.out.println(String.format("%24s %s", "Picture Widdth:", Integer.toString(width)));
		} catch (Exception e) {
			System.out.println(e);
			System.exit(0);
		}

	}

	public static byte[] converting(byte[] value) {
		final int length = value.length;
		byte[] res = new byte[length];
		for (int i = 0; i < length; i++) {
			res[length - i - 1] = value[i];
		}
		return res;
	}
}
