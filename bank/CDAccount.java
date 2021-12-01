package bank;

public class CDAccount extends BankAccount {
	private double rate;
	private int termRemaining;

	/**
	 * @param rate,           a double, the monthly interest rate in percentage
	 *                        (i.e. 2.5 = 2.5%)
	 * @param term,           an int, the number of months until the CD matures
	 * @param initialBalance, a double, the one and only deposit
	 */
	public CDAccount(double rate, int term, double initialBalance) {
		this.rate = rate / 100.0;
		termRemaining = term;
		deposit(initialBalance);
	}

	/**
	 * Computers whether or not to apply a 10% early withdrawal penalty.
	 * 
	 * @param amt, a double
	 */
	public void withdrawal(double amt) {
		if (termRemaining > 0) {
			System.out.printf("%s $%.2f %s $%.2f %s\n", "Early CD Withdrawl:", getBalance() * 0.1, "penalty,",
					getBalance() * 0.9, "cashed out.");
			super.withdrawal(getBalance() * 0.9);
			super.withdrawal(getBalance());
		} else {
			System.out.printf("%s $%.2f %s\n", "Mature CD Withdrawl: No penalty,", getBalance(), "cashed out.");
			super.withdrawal(getBalance());
		}

	}

	/**
	 * deposits the monthly interest accrued
	 */
	public void monthEnd() {
		if (termRemaining > 0) {
			termRemaining--;
		}
		deposit(rate * getBalance());
	}

	/**
	 * @return a string containing the balance, term remaining, and interest rate
	 */
	@Override
	public String toString() {
		return String.format("CD: Balance=$%.2f, Term=%d, Rate=%.1f%s", getBalance(), termRemaining, rate * 100, "%");
	}

}