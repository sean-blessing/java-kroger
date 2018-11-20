
public class CheckingAccount extends Account {

	private double monthlyFee;

	public CheckingAccount(double amount, double monthlyFee) {
		setBalance(amount);
		this.monthlyFee = monthlyFee;
	}

	public double getMonthlyFee() {
		return monthlyFee;
	}

	public void setMonthlyFee(double monthlyFee) {
		this.monthlyFee = monthlyFee;
	}
	
	public void subtractFeeFromBalance() {
		setBalance(getBalance() - monthlyFee);
	}
}
