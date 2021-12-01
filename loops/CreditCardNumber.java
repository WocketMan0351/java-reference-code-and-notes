package loops;
import java.util.Scanner;

public class CreditCardNumber {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		System.out.print("Card Number: ");
		String creditCardNumber = in.nextLine();
		
		int i = 0;
		while (i < creditCardNumber.length()) {
			char ch = creditCardNumber.charAt(i);
			if (ch == ' ' || ch == '-') {
				String before = creditCardNumber.substring(0, i);
				String after = creditCardNumber.substring(i + 1);
				creditCardNumber = before + after;
			}
			else {
				i++;
			}
		}
		
		System.out.println(creditCardNumber);
	}
}
