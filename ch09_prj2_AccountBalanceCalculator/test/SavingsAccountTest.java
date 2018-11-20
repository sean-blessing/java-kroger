import static org.junit.Assert.*;

import org.junit.*;

public class SavingsAccountTest {

	private SavingsAccount sa;
	
	@Before
	public void setup() {
		sa = new SavingsAccount(1000.0,0.01);
	}
	@Test
	public void addInterestTest() {
		double balance = sa.getBalance();
		double monthlyInterestRate = sa.getMonthlyInterestRate();
		double expIntPmt = balance * monthlyInterestRate;
		
		sa.applyInterestToBalance();
		
		assertEquals(expIntPmt, sa.getMonthlyInterestPayment(), 0.0);

		assertEquals(balance+expIntPmt, sa.getBalance(), 0.0);
		
	}

}
