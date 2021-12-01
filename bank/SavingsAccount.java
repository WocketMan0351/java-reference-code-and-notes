package bank;

public class SavingsAccount extends BankAccount {
	private double rate;
	private double minimumBalance;

	/*
	 * @param minimum, a double, the minimum amount required to yield the interest
	 * rate
	 * 
	 * @param rate, a double, the monthly interest rate
	 * 
	 * @param initialBalance, a double, initializes the account with a balance
	 */
	SavingsAccount(double minimum, double rate, double initialBalance) {
		minimumBalance = minimum;
		this.rate = rate / 100.0;
		deposit(initialBalance);
	}

	/**
	 * deposits the monthly interest accrued
	 */
	public void monthEnd() {
		if (getBalance() >= minimumBalance) {
			deposit(rate * getBalance());
		}
	}

	/**
	 * @return a string containing the balance and minimum balance required to
	 *         accrue interest
	 */
	public String toString() {
		return String.format("Savings: Balance=$%.2f, Minimum=$%.2f, Rate=%.1f%s", getBalance(), minimumBalance,
				rate * 100, "%");
	}
}
