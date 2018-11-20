import static org.junit.Assert.*;

import org.junit.*;

public class AccountTest {

	private SavingsAccount sa;
	private CheckingAccount ca;
	
	@Before
	public void setup() {
		sa = new SavingsAccount(1000.0, 0.01);
		ca = new CheckingAccount(1000.0, 1.0);
	}
	
	@Test
	public void withdrawalTest() {
		double withdrawalAmt = 100.0;
		double saBeginningBal = sa.getBalance();
		double caBeginningBal = ca.getBalance();
		
		sa.withdraw(withdrawalAmt);
		ca.withdraw(withdrawalAmt);
		
		assertEquals(saBeginningBal-withdrawalAmt, sa.getBalance(), 0.0);
		assertEquals(caBeginningBal-withdrawalAmt, ca.getBalance(), 0.0);
		
	}

	@Test
	public void depositTest() {
		double depositAmt = 100.0;
		double saBeginningBal = sa.getBalance();
		double caBeginningBal = ca.getBalance();
		
		sa.deposit(depositAmt);
		ca.deposit(depositAmt);
		
		assertEquals(saBeginningBal + depositAmt, sa.getBalance(), 0.0);
		assertEquals(caBeginningBal + depositAmt, ca.getBalance(), 0.0);
		
	}

}
