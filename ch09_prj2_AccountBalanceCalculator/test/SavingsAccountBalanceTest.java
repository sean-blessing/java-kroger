import static org.junit.Assert.*;

import org.junit.Test;

public class SavingsAccountBalanceTest {

	@Test
	public void savingsAccountCreateBalanceTest() {
		SavingsAccount sa = new SavingsAccount(1000.0, .01);
		
		assertEquals(1000.0, sa.getBalance(), 0.0);
	}

	@Test
	public void savingsAccountCreateFeesTest() {
		SavingsAccount sa = new SavingsAccount(1000.0, 0.01);
		
		assertEquals(0.01, sa.getMonthlyInterestRate(), 0.0);
	}

}
