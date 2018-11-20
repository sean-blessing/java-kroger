
public class Account implements Withdrawable, Balanceable, Depositable {
	private double balance;

	@Override
	public void deposit(double amount) {
		balance += amount;
	}

	@Override
	public double getBalance() {
		return balance;
	}

	@Override
	public void setBalance(double amount) {
		balance = amount;
	}

	@Override
	public void withdraw(double amount) {
		balance -= amount;
	}

}
