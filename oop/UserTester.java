package oop;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserTester {
	public static void main(String[] args) {
		List<User> users = new ArrayList<User>();

		Scanner in = new Scanner(System.in);

		System.out.print("How many users would you like to add? ");
		int numberOfUsers = in.nextInt();
		int counter = 0;
		System.out.println();

		do {
			System.out.print("Enter user name: ");

			User staged = new User();
			staged.setFirstName(in.next());
			staged.setLastName(in.next());
			users.add(staged);

			counter++;
		} while (counter < numberOfUsers);

		System.out.println();
		System.out.println("Successfully added " + users.size() + " users!");
		System.out.print("Display all users? (Y) or (N): ");
		String displayAll = in.next();
		System.out.println();

		switch (displayAll.toLowerCase()) {
		case "y":
			for (int i = 0; i < users.size(); i++) {
				System.out.println(i + 1 + ") " + users.get(i).getFullName());
			}

		default:
			break;
		}

		System.out.println();
		System.out.println("Done.");

		in.close();

	}

}
