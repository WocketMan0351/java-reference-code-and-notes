package loops;
import java.util.Scanner;

public class RandomInsertion {
	public static void main(String[] args) {
		for (int i = 0; i < 5; i++) {
			System.out.println(insertAtRandom("abcdefghijklmnopqrstuvwxyz", "8"));
		}
	}
	
	public static String insertAtRandom(String str, String toInsert) {
		int n = str.length();
		int r = (int) ((n + 1) * Math.random());
		return str.substring(0, r) + toInsert + str.substring(r);
	}
}
