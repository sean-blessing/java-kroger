import static org.junit.Assert.*;

import org.junit.Test;

public class CheckingAccountBalanceTest {

	@Test
	public void checkingAccountCreateBalanceTest() {
		CheckingAccount ca = new CheckingAccount(1000.0, 1.0);
		
		assertEquals(1000.0, ca.getBalance(), 0.0);
	}

	@Test
	public void checkingAccountCreateFeesTest() {
		CheckingAccount ca = new CheckingAccount(1000.0, 1.0);
		
		assertEquals(1.0, ca.getMonthlyFee(), 0.0);
	}

}
