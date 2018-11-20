import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)

@Suite.SuiteClasses({
		CheckingAccountBalanceTest.class,
		SavingsAccountBalanceTest.class
})
public class AccountBalanceCalculatorAppTestSuite {

}
