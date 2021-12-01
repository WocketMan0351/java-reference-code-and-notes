package basics;
import java.util.Scanner;
import java.text.NumberFormat;


public class CareerMedianSalary {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		final char DOLLARSIGN = '$';
		
		String input = "";
		String maxCareer = "";
		String minCareer = "";
		String recentCareer = "";
		String intValue = "";
		
		int counter = 0;
		int numberOfEntries = 0;
		int maxSalary = 0;
		int minSalary = 999999;
		int recentValue = 0;
		
		boolean numeric = true;
		
		do {
			System.out.print("Enter {title} [SPACE] ${salary}: ");
			input = in.nextLine().trim();
			
			int i = input.indexOf(DOLLARSIGN);
			
			if (input.isEmpty()) {
				System.out.printf("Maximum Salary: $%s for title: %s %n", NumberFormat.getNumberInstance().format(maxSalary), maxCareer);
				System.out.printf("Minimum Salary: $%s for title: %s", NumberFormat.getNumberInstance().format(minSalary), minCareer);
			}
			else if (i == 0) {
				System.out.println("Invalid input: missing title.");
			}
			else if (!input.contains("$")) {
				System.out.println("Invalid input: missing dollarsign.");
			}
			else if (!input.contains(",")) {
				System.out.println("Invalid input: missing comma.");
			}
			else {
				if (i != -1) {
					numberOfEntries++;
					
					for (int c = 0; c < input.length(); c++) {
						if (input.charAt(c) == ',') {
							counter++;
						}
						else if (counter> numberOfEntries) {
							System.out.println("Invalid input, too many commas.");
						}
					}
					
					recentCareer = input.substring(0, i);
					intValue = input.substring(i + 1).replace(",", "");
					
					for (int n = 0; n < intValue.length(); n++) {
						if (!Character.isDigit(intValue.charAt(n))) {
							numeric = false;
							System.out.println("Invalid input, salary isn't a number."); break;
						}
					}
					
					if (numeric && counter <= numberOfEntries) {
						recentValue = Integer.parseInt(intValue);
					}
				}
				
				if (counter <= numberOfEntries) {
					if (recentValue > maxSalary) {
						maxSalary = recentValue;
						maxCareer = recentCareer;
					}
					
					if (recentValue < minSalary) {
						minSalary = recentValue;
						minCareer = recentCareer;
					}
				}
			}
			
		} while (!input.isEmpty());
	}
}
