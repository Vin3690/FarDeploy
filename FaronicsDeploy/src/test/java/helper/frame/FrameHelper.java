package helper.frame;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import helper.logger.LoggerHelper;

public class FrameHelper {
	
	private WebDriver driver;
	
	Logger log=LoggerHelper.getLogger(FrameHelper.class);

	/**
	 * Initilizing the page Objects
	 * @param driver
	 */
	public FrameHelper(WebDriver driver) {
		this.driver=driver;
	}
	
	/**
	 * This method will Switch to Frame by index  
	 * @param frameindex
	 */
	
	public void switchFrameByIndex(int frameindex) {
		driver.switchTo().frame(frameindex);
		log.info("Switched to Frame :"+ frameindex );
	}
	
	/**
	 * This method will switchFrameByName by name or Id
	 * @param framename
	 */
	public void switchFrameByName(String framename) {
		driver.switchTo().frame(framename);
		log.info("Switched to Frame :"+framename);
	}
	
	/**
	 * This method will switchFrameByName by element
	 * @param element
	 */
	public void switchFrameByElememnt(WebElement element) {
		driver.switchTo().frame(element);
		log.info("Switched to Frame :"+element.toString());
	}
	


}
