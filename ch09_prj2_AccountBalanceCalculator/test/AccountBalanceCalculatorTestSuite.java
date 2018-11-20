import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
	AccountTest.class,
	SavingsAccountTest.class,
	CheckingAccountTest.class
})
public class AccountBalanceCalculatorTestSuite {

}
