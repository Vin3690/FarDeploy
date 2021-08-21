package testscripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import testbase.TestBase;

public class openSite extends TestBase  {
	
	@Test
	public void getSite() {
		driver.get("http://www.book.com");
		
		if(driver.getTitle().equalsIgnoreCase("Facebook")) {
			Assert.assertTrue(true);
		}
		else {
			Assert.assertTrue(false);
		}
		driver.close();
	}

}
