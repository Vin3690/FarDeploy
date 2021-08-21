package testscripts;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import Config.ObjectReader;
import helper.logger.LoggerHelper;
import pageobject.LoginPage;
import testbase.TestBase;

public class LoginTest extends TestBase {
	
	private final Logger log=LoggerHelper.getLogger(LoginTest.class);
	
	@Test(description="Login test with valid description")
	public void testLoginToApplication() throws IOException {
		getApplicationUrl(ObjectReader.reader.getUrl());
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserEmail(ObjectReader.reader.getuserEmail());
		loginpage.enterUserPassword(ObjectReader.reader.getuserPassword());
		loginpage.ClickonSignInButton();
		loginpage.verifySuccessLogin();
		
		log.info("User successfully log in to application..!!!");
		
		
	}

}
