package testbase;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Config.ObjectReader;
import Config.PropertyReader;
import helper.browserConfiguration.BrowserType;
import helper.browserConfiguration.ChromeBrowser;
import helper.browserConfiguration.EdgeBrowser;
import helper.browserConfiguration.FireFoxBrowser;
import helper.javascript.JavascriptHelper;
import helper.logger.LoggerHelper;
import helper.resource.ResourceHelper;
import helper.wait.WaitHelper;
import utilities.ExtentManager;

public class TestBase {

	public WebDriver driver;
	public Logger log = LoggerHelper.getLogger(TestBase.class);
	public static File reportDirectory;

	public static ExtentReports extent;
	public static ExtentTest test;

	@BeforeSuite
	public void beforeSuite() throws Exception {
		extent = ExtentManager.getInstance();
	}

	@BeforeClass
	public void beforeClass() {
		test = extent.createTest(getClass().getSimpleName());
	}

	@BeforeMethod
	public void beforeMethod(Method method) {
		test.log(Status.INFO, method.getName() + "  started...!!!");
	}

	@BeforeTest
	public void beforeTest() throws Exception {
		ObjectReader.reader = new PropertyReader();
		reportDirectory = new File(ResourceHelper.getResourcePath("\\src\\main\\resources\\Screenshots"));
		setUpDriver(ObjectReader.reader.getBrowser());

	}

	@AfterMethod
	public void afterMethod(ITestResult result) throws IOException{
		if (result.getStatus() == ITestResult.FAILURE) {
			test.log(Status.FAIL, result.getThrowable());
			String imagePath = captureScreen(result.getName(),driver);
			test.addScreenCaptureFromPath(imagePath);

		} else if (result.getStatus() == ITestResult.SUCCESS) {
			test.log(Status.PASS, result.getName() + " is Passed");
			String imagePath1 = captureScreen(result.getName(),driver);
			test.addScreenCaptureFromPath(imagePath1);

		} else if (result.getStatus() == ITestResult.SKIP) {
			test.log(Status.SKIP, result.getThrowable());
		}
		extent.flush();
		if(driver!=null){
			driver.quit();
		}
	}
	public WebDriver getBrowser(BrowserType br) throws Exception {
		try {
			switch (br) {

			case Chrome:
				ChromeBrowser chrome = new ChromeBrowser();
				ChromeOptions option = chrome.getChromeOptions();
				return chrome.getChromeDriver(option);

			case Firefox:
				FireFoxBrowser firefox = new FireFoxBrowser();
				FirefoxOptions options = firefox.getFirefoxOptions();
				return firefox.getFirefoxDriver(options);

			case Edge:
				EdgeBrowser edge = new EdgeBrowser();
				return edge.getEdgeDriver();

			default:
				throw new Exception("Driver not found  " + br.name());

			}
		} catch (Exception e) {
			log.info(e.getMessage());
			throw e;
		}
	}

	public void setUpDriver(BrowserType br) throws Exception {
		driver = getBrowser(br);
		log.info("Iniltialize the Web Driver: " + driver.hashCode());
		WaitHelper wait = new WaitHelper(driver);
		wait.setImplicitWait(ObjectReader.reader.getImplicitWait(), TimeUnit.SECONDS);
		wait.pageLoadTime(ObjectReader.reader.getPageLoadTime(), TimeUnit.SECONDS);
		driver.manage().window().maximize();

	}

	public String captureScreen(String filename, WebDriver driver) {
		if (driver == null) {
			log.info("Driver is null...");
			return null;
		}

		File destFile = null;
		Calendar calender = Calendar.getInstance();
		SimpleDateFormat formater = new SimpleDateFormat("dd_mm_yy_hh_mm_ss");
		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			destFile = new File(reportDirectory + "/" + filename + "_" + formater.format(calender.getTime()) + ".png");
			FileUtils.copyFile(srcFile, destFile);
			Reporter.log("<a href='" + destFile.getAbsolutePath() + "'><img src='" + destFile.getAbsolutePath()
					+ "'height='100' width='100'/><a/>");
		} catch (Exception e) {
			e.printStackTrace();

		}
		return destFile.toString();

	}
	
	public void getNavigateScreen(WebDriver driver) throws IOException {
		log.info("Capturing UI of navigating screen");
		String screen=captureScreen("",driver);
		test.addScreencastFromPath(screen);
	}
	
	public void getApplicationUrl(String url) {
		driver.get(url);
		
	}
}
