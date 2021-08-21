package testscripts;

import org.testng.annotations.Test;

import testbase.TestBase;

public class TestScreenshot extends TestBase{
	
	@Test
	public void testScreen() {
		driver.get("https://qatest.deepfreeze.com/");
		captureScreen("Screenshot Test", driver);
		driver.close();
		
	}

}
