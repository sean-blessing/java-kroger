import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class UnitTestOrderTest {

	@BeforeClass
	public static void beforeClass() {
		System.out.println("beforeClass called");
	}

	@Before
	public void before() {
		System.out.println("before called");
	}

	@Test
	public void test1() {
		System.out.println("test1 called");
	}

	@Test
	public void test2() {
		System.out.println("test2 called");
	}
	@Test
	public void test3() {
		System.out.println("test3 called");
	}
	@After
	public void after() {
		System.out.println("after called");
	}
	@AfterClass
	public static void afterClass() {
		System.out.println("afterClass called");
	}
}
