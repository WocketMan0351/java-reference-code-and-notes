package ram;

public class EnhancedBankAccount {
	private int accountNumber;
	private double balance;

	public EnhancedBankAccount(int accountNumber) {
		this.accountNumber = accountNumber;
		balance = 0;
	}

	public EnhancedBankAccount(int accountNumber, double initialBalance) {
		this.accountNumber = accountNumber;
		balance = initialBalance;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public void deposit(int amount) {
		balance += amount;
	}

	public void withdraw(int amount) {
		balance -= amount;
	}

	public double getBalance() {
		return balance;
	}
}
