import static org.junit.Assert.*;

import org.junit.*;

public class CheckingAccountTest {

	private CheckingAccount ca;
	
	@Before
	public void setup() {
		ca = new CheckingAccount(1000.0,1.0);
	}
	
	@Test
	public void subtractFeeTest() {
		double startingBalance = ca.getBalance();
		double fee = ca.getMonthlyFee();
		
		// Subtract the monthly fee
		ca.subtractFeeFromBalance();
		
		// Assert that balance is as expected
		assertEquals(startingBalance - fee, ca.getBalance(), 0.0);
		
	}

}
