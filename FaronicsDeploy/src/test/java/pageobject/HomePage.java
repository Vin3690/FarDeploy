package pageobject;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;

import Config.ObjectReader;
import helper.logger.LoggerHelper;
import helper.wait.WaitHelper;
import testbase.TestBase;

public class HomePage {
	
	private WebDriver driver;
	private final Logger log=LoggerHelper.getLogger(LoginPage.class);
	WaitHelper waitHelper;
	
	@FindBy(id="downloadagentclosebtn")
	WebElement downloadagentclosebtn;
	
	@FindBy(id="downloadAgent")
	WebElement downloadAgent;
	
	@FindBy(xpath="//i[@class='fa fa-user-circle']")
	WebElement usericon;
	
	@FindBy(xpath="//*[contains(text(),'Sign Out')]")
	WebElement Signoutbtn;
	
	
	
	public HomePage(WebDriver driver) throws IOException {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		waitHelper=new WaitHelper(driver);
		//waitHelper.waitForElement(SignInButtn, ObjectReader.reader.getExplicitWait());
		new TestBase().getNavigateScreen(driver);
	}
	
	public void closeDownloadagentpopup() {
		downloadagentclosebtn.click();
		log.info("Closing Download agent pop up....!!");
		TestBase.test.log(Status.INFO, "Closing Download agent pop up....!!");
	}
	
	public void downloadAgent() {
		downloadAgent.click();
		log.info(" Downloading deploy agent ....!!");
		TestBase.test.log(Status.INFO, "Downloading deploy agent ....!!");
	}
	
	public void clickOnuserIcon() {
		usericon.click();
		log.info(" Clicked on user icon....!!");
		TestBase.test.log(Status.INFO, "Clicked on user icon....!!");
	}
	
	public void clickOnSignOutbtn() {
		Signoutbtn.click();
		log.info(" User signout successfully...!!!");
		TestBase.test.log(Status.INFO, "User signout successfully...!!!");
	}

}
