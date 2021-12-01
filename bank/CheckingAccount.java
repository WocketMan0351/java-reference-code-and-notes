package bank;

public class CheckingAccount extends BankAccount {
	private int maxWithdraw;
	private int withdrawalCount;

	/**
	 * @param withdrawLimit,  an int, sets the maximum withdrawal allowed
	 * @param initialBalance, a double, initializes the account with a balance
	 */
	CheckingAccount(int withdrawLimit, double initialBalance) {
		maxWithdraw = withdrawLimit;
		withdrawalCount = 0;
		deposit(initialBalance);
	}

	/**
	 * @param amt, a double, the amount to withdraw increments withdrawLimit by 1,
	 *             charges fees if withdrawLimit is exceeded
	 */
	public void withdrawal(double amt) {
		super.withdrawal(amt);
		withdrawalCount++;
		if (withdrawalCount > 3) {
			super.withdrawal(1.0);
		}
	}

	/**
	 * resets the withdrawalCount to 0
	 */
	public void monthEnd() {
		withdrawalCount = 0;
	}

	/**
	 * @return a string containing the balance, allowed withdrawals, and # of
	 *         withdrawals made this month
	 */
	@Override
	public String toString() {
		return String.format("Checking: Balance=$%.2f, Allowed Withdrawals=3, #Withdrawals=%d", getBalance(),
				withdrawalCount);
	}
}
