package helper.window;

import java.util.Set;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import helper.logger.LoggerHelper;

public class WindowHelper {
	
	private WebDriver driver;
	Logger log=LoggerHelper.getLogger(WindowHelper.class);
	
	public WindowHelper(WebDriver driver) {
		this.driver=driver;
	}
	
	/**
	 * This will switch to main window
	 */
	public void switchToMainWindow() {
		log.info("Switching to main windows...");
		driver.switchTo().defaultContent();
		log.info("Swtiched to Main Window");
	}
	
	/**
	 * This will switch to targeted window based on index
	 */
	public void switchToWindow(int index) {
		Set<String> windows=driver.getWindowHandles();
		int i=1;
		for(String window:windows) {
			if(i==index) {
				driver.switchTo().window(window);
				log.info("Swtched to :"+index+" Window");
			}else {
				i++;
			}
		
		}
	}
	
	/**
	 * This will Close all tabs opened and switch to main window
	 */
	public void closeAllTabsAndSwitchToMainWindow() {
		Set<String> Windows=driver.getWindowHandles();
		String mainwindow=driver.getWindowHandle();
		
		for(String window:Windows) {
			if(!window.equalsIgnoreCase(mainwindow)) {
				driver.close();
			}
		}
		
		driver.switchTo().window(mainwindow);
		log.info("Switched to main window");
	}
	
	/**
	 * This will navigate forward
	 */
	public void navigateForward() {
		driver.navigate().forward();
		log.info("Navigated forward");
	}
	
	/**
	 * This will navigate backward
	 */
	public void navigateback() {
		driver.navigate().back();
		log.info("Navigated backward");
	}
}
