import java.awt.DisplayMode;
import java.text.NumberFormat;

public class AccountBalanceCalculatorApp {
	// technically not good form, but doing so for speed during demo
	static CheckingAccount ca = new CheckingAccount(1000.0, 1.0);
	static SavingsAccount sa = new SavingsAccount(1000.0, 0.01);
	static NumberFormat cf = NumberFormat.getCurrencyInstance();

	public static void main(String[] args) {
		System.out.println("Welcome to the Account Balance Calculator App");
		
		
		System.out.println("Starting Balances");
		displayBalances();
		
		System.out.println("Enter the transactions for the month");
		
		String choiceContinue = "y";
		
		while (choiceContinue.equalsIgnoreCase("y")) {
			String transType = Console.getString("Withdraw or Deposit? (w/d)  ",
													"w", "d");
			String acctType = Console.getString("(c)hecking or (s)avings account?  ",
												"c", "s");
			Account a = null;
			if (acctType.equalsIgnoreCase("c")) {
				a = ca;
			}
			else  {
				a = sa;
			}

			double amount = Console.getDouble("Enter amount:  ", 0, Double.POSITIVE_INFINITY);

			if (transType.equalsIgnoreCase("w")) {
				a.withdraw(amount);
			}
			else {
				a.deposit(amount);
			}
			
			choiceContinue = Console.getString("Continue? (y/n)  ", "y", "n");
		}
		
		sa.applyInterestToBalance();
		ca.subtractFeeFromBalance();
		
		System.out.println("Payments and Fees");
		System.out.println("Checking fee:  "+cf.format(ca.getMonthlyFee()));
		System.out.println("Savings interest payment:  "+cf.format(sa.getMonthlyInterestPayment()));
		
		System.out.println();
		System.out.println("Final Balances");
		displayBalances();
		System.out.println("Bye");

	}
	
	private static void displayBalances() {
		
		System.out.println("Checking: "+cf.format(ca.getBalance()));
		System.out.println("Savings:  "+cf.format(sa.getBalance()));
	}

}
