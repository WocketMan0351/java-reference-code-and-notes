package bank;

import java.util.ArrayList;
import java.util.Scanner;

public class Banking {

	public static void main(String[] args) {
		char option = ' ';

		System.out.println("Banking Application – Cody Worthen");

		ArrayList<BankAccount> accounts = new ArrayList<BankAccount>();
		accounts.add(new CheckingAccount(3, 100.0));
		accounts.add(new SavingsAccount(100.0, 2.5, 200.0));
		accounts.add(new CDAccount(7.5, 60, 10000.00));
		accounts.add(new SavingsAccount(100.0, 2.5, 300.0));
		accounts.add(new CheckingAccount(3, 400.0));
		accounts.add(new CDAccount(5.0, 2, 5000.00));

		while (option != 'Q') {
			option = printMenu();
			switch (option) {
			case 'L':
				listAll(accounts);
				break;
			case 'D':
				makeDeposit(accounts);
				break;
			case 'W':
				makeWithdrawal(accounts);
				break;
			case 'M':
				doMonthEnd(accounts);
				break;
			case 'Q':
				break;
			default:
				System.out.println("Select D, W, M or Q");
			}
		}
	}

	public static char printMenu() {
		Scanner in = new Scanner(System.in);

		System.out.println("\nL)ist All D)eposit W)ithdraw M)onth end Q)uit");
		return in.nextLine().toUpperCase().charAt(0);
	}

	public static void makeDeposit(ArrayList<BankAccount> accounts) {
		Scanner in = new Scanner(System.in);

		System.out.print("Account Number ");
		int acctNum = in.nextInt();

		BankAccount targetAccount = accounts.get(acctNum);

		System.out.print("Amount ");
		double amount = in.nextDouble();

		targetAccount.deposit(amount);
		System.out.printf("*** New balance: %.2f\n", targetAccount.getBalance());
	}

	public static void makeWithdrawal(ArrayList<BankAccount> accounts) {
		Scanner in = new Scanner(System.in);

		System.out.print("Account Number ");
		System.out.println();
		int acctNum = in.nextInt();

		BankAccount targetAccount = accounts.get(acctNum);

		System.out.print("Amount ");
		double amount = in.nextDouble();

		targetAccount.withdrawal(amount);
		System.out.printf("*** New balance: %.2f\n", targetAccount.getBalance());
	}

	public static void doMonthEnd(ArrayList<BankAccount> accounts) {
		for (int acct = 0; acct < accounts.size(); acct++) {
			BankAccount b = accounts.get(acct);
			b.monthEnd();
			System.out.printf("%2d: %7.2f\n", acct, b.getBalance());
		}
	}

	public static void listAll(ArrayList<BankAccount> accounts) {
		for (int acct = 0; acct < accounts.size(); acct++) {
			BankAccount b = accounts.get(acct);
			System.out.println(b);
		}
	}
}
