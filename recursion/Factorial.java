package recursion;

import java.util.Scanner;

public class Factorial {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("Enter number to take factorial of: ");
		int input = in.nextInt();
		long factorial = factorial(input);
		System.out.println(factorial);
	}

	public static long factorial(long n) {
		if (n == 1) {
			return 1;
		} else {
			return n * factorial(n - 1);
		}
	}
}
