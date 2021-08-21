package testscripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import testbase.TestBase;

public class TestcaseDemo extends TestBase{
	
	@Test
	public void test1() {
		Assert.assertTrue(true);
	}
	
	@Test
	public void test2() {
		Assert.assertTrue(false);
	}
	
	@Test
	public void test3() {
		Assert.assertTrue(true);
	}
	
	@Test
	public void test4() {
		Assert.assertTrue(false);
	}

}
