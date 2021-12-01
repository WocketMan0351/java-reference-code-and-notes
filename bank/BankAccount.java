package bank;

public class BankAccount implements Measureable {
	private double balance;

	public BankAccount() {
		balance = 0.0;
	}

	public BankAccount(double initBalance) {
		balance = initBalance;
	}

	public void deposit(double amt) {
		balance = balance + amt;
	}

	public void withdrawal(double amt) {
		balance = balance - amt;
	}

	public void monthEnd() {
		// Nothing to do.
	}

	public double getBalance() {
		return balance;
	}

	@Override
	public double getMeasure() {
		return balance;
	}
}
