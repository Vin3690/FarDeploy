package pageobject;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;

import Config.ObjectReader;
import helper.assertion.VerificationHelper;
import helper.logger.LoggerHelper;
import helper.wait.WaitHelper;
import testbase.TestBase;

public class LoginPage {

	private WebDriver driver;
	private final Logger log=LoggerHelper.getLogger(LoginPage.class);
	WaitHelper waitHelper;
	
	
	/**
	 * Page Objects initialized 
	 * 
	 */
	@FindBy(id="LoginWithEmail")
	WebElement LoginWithEmailCheckbox;
	
	@FindBy(xpath="//*[text()='A whole new way to manage software.']")
	WebElement AWholeManageSoftwareText;
	
	@FindBy(xpath="//*[contains(text(),'Install, Update and Control within seconds.')]")
	WebElement InstallUpdateControlText;
	
	@FindBy(id="EmailAddress")
	WebElement EmailAddressTextBox;
	
	@FindBy(id="Password")
	WebElement EmailPasswordTextBox;
	
	@FindBy(xpath="//input[@value='Sign in']")
	WebElement SignInButtn;
	
	@FindBy(xpath="//a[@id=\'aDeployIcon\']")
    WebElement faronicsLogoOfHomePage;
	
	
	
	public LoginPage(WebDriver driver) throws IOException {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		waitHelper=new WaitHelper(driver);
		waitHelper.waitForElement(SignInButtn, ObjectReader.reader.getExplicitWait());
		new TestBase().getNavigateScreen(driver);
	}
	
	public void enterUserEmail(String usemail) {	
	  EmailAddressTextBox.sendKeys(usemail);
		log.info("Email Address entered into Email Address TextBox..!!");
		TestBase.test.log(Status.INFO, "Email Address entered into Email Address TextBox...!!");
	}
	
	public void enterUserPassword(String UserPass) {
		
		EmailPasswordTextBox.sendKeys(UserPass);
		log.info("Email Password entered into Email Password TextBox..!!");
		TestBase.test.log(Status.INFO, "Email Password entered into Email Password TextBox...!!");
	}
	
	public HomePage ClickonSignInButton() throws IOException {
		SignInButtn.click();
		log.info("Clicked on SignIn Button....");
		TestBase.test.log(Status.INFO, "Clicked on SignIn Button...!!");
		return new HomePage(driver);
	}

		
	public boolean verifySuccessLogin() {
		return new VerificationHelper(driver).isDisplayed(faronicsLogoOfHomePage);
	}
	
	
	/**
	 * Single login method..... 
	 * @param uemail
	 * @param upass
	 */
	public void getLogin(String uemail, String upass) {
		EmailAddressTextBox.sendKeys(uemail);
		log.info("Email Address entered into Email Address TextBox..!!");
		TestBase.test.log(Status.INFO, "Email Address entered into Email Address TextBox...!!");
		EmailPasswordTextBox.sendKeys(upass);
		log.info("Email Password entered into Email Password TextBox..!!");
		TestBase.test.log(Status.INFO, "Email Password entered into Email Password TextBox...!!");
		SignInButtn.click();
		log.info("Clicked on SignIn Button");
		TestBase.test.log(Status.INFO, "Clicked on SignIn Button...!!");
	}
}
