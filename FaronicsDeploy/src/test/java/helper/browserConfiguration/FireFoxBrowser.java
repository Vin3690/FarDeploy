package helper.browserConfiguration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FireFoxBrowser {
	
	public FirefoxOptions getFirefoxOptions() {

		DesiredCapabilities firefox = DesiredCapabilities.firefox();

		FirefoxProfile profile = new FirefoxProfile();
		profile.setAcceptUntrustedCertificates(true);
		profile.setAssumeUntrustedCertificateIssuer(true);
		
		firefox.setCapability(FirefoxDriver.PROFILE, profile);
		firefox.setCapability("marionette", true);

		FirefoxOptions firefoxOptions = new FirefoxOptions(firefox);
		// Linux
		if (System.getProperty("os.name").contains("Linux")) {
			firefoxOptions.addArguments("--headless", "window-size=1024,768", "--no-sandbox");
		}
		return firefoxOptions;
	}

	public WebDriver getFirefoxDriver(FirefoxOptions cap) {

		if (System.getProperty("os.name").contains("Mac")) {
			WebDriverManager.firefoxdriver().setup();
			return new FirefoxDriver(cap);
		} else if (System.getProperty("os.name").contains("Window")) {
			WebDriverManager.firefoxdriver().setup();
			return new FirefoxDriver(cap);
		} else if (System.getProperty("os.name").contains("Linux")) {
			WebDriverManager.firefoxdriver().setup();
			return new FirefoxDriver(cap);
		}
		return null;
	}
	
	public static void main(String[] args) {
		FireFoxBrowser obj = new FireFoxBrowser();
		WebDriver driver = obj.getFirefoxDriver(obj.getFirefoxOptions());
		driver.get("https://www.zomato.com/");
	}



}
