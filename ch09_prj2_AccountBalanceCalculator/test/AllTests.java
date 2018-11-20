import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ AccountBalanceCalculatorAppTestSuite.class, AccountBalanceCalculatorTestSuite.class, AccountTest.class,
		CheckingAccountBalanceTest.class, CheckingAccountTest.class, SavingsAccountBalanceTest.class,
		SavingsAccountTest.class, UnitTestOrderTest.class })
public class AllTests {

}
