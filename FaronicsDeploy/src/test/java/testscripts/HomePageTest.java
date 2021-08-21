package testscripts;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import Config.ObjectReader;
import helper.logger.LoggerHelper;
import pageobject.HomePage;
import pageobject.LoginPage;
import testbase.TestBase;

public class HomePageTest extends TestBase{
	
	private final Logger log=LoggerHelper.getLogger(HomePageTest.class);
	LoginPage login;
	
	@Test(description="Test the homepage..!!!")
	public void testHomepage() throws IOException {
		getApplicationUrl(ObjectReader.reader.getUrl());
		login=new LoginPage(driver);
		login.enterUserEmail(ObjectReader.reader.getuserEmail());
		login.enterUserPassword(ObjectReader.reader.getuserPassword());
		login.ClickonSignInButton();
		
		HomePage homepage=new HomePage(driver);
		homepage.closeDownloadagentpopup();
		homepage.downloadAgent();
		homepage.clickOnuserIcon();
		homepage.clickOnSignOutbtn();
		
//		log.info("User successfully logout to the application..!! ");
//		TestBase.test.log(Status.INFO, "User successfully logout to the application..!! ");
	}

}
