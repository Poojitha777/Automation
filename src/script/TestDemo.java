package script;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import generic.BaseTest;
import generic.Result;


public class TestDemo extends BaseTest {
	
	@Test
	public void test()
	{
		Reporter.log("Test.....", true);
	}
	@Test
	public void testA()
	{
		Reporter.log("TestA.....", true);
		Assert.fail();
	}
	@Test
	public void testB()
	{
		Reporter.log("TestB.....", true);
		Assert.fail();
	}
	

}
