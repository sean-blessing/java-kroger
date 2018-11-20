
public class SavingsAccount extends Account {
	private double monthlyInterestRate;
	private double monthlyInterestPayment;
	
	public SavingsAccount(double amount, double monthlyInterestRate) {
		setBalance(amount);
		this.monthlyInterestRate = monthlyInterestRate;
	}

	public double getMonthlyInterestRate() {
		return monthlyInterestRate;
	}

	public void setMonthlyInterestRate(double monthlyInterestRate) {
		this.monthlyInterestRate = monthlyInterestRate;
	}

	public double getMonthlyInterestPayment() {
		return monthlyInterestPayment;
	}

	public void setMonthlyInterestPayment(double monthlyInterestPayment) {
		this.monthlyInterestPayment = monthlyInterestPayment;
	}
	
	public void applyInterestToBalance() {
		setMonthlyInterestPayment(getBalance() * monthlyInterestRate);
		setBalance(getBalance() + monthlyInterestPayment);
	}
	
}
