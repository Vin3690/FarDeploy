package helper.javascript;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import helper.logger.LoggerHelper;

public class JavascriptHelper {
	
	private WebDriver driver;
	private Logger log=LoggerHelper.getLogger(JavascriptHelper.class);
	
	public JavascriptHelper(WebDriver driver) {
		this.driver=driver;
	}
	
	
	public Object executeScript(String script) {
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		return jse.executeScript(script);
	}
	
	public Object executeScript(String script, Object...args) {
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		return jse.executeScript(script, args);
	}
    /**
     * This method will scroll page to WebElement
     * @param element
     */
	public void scrollToElement(WebElement element) {
		log.info("Scroll to WebElement..");
		executeScript("window.scrollTo(arguments[0],arguments[1])",element.getLocation().x,element.getLocation().y);
	}
	
    /**
     * This method will scroll page to WebElement and then click 
     * @param element
     */
	public void scrollToElementAndClick(WebElement element) {
		scrollToElement(element);
		element.click();
		log.info("Element is clicked :"+element.toString());
	}
	
    /**
     * This method will scroll into View
     * @param element
     */
	public void scrollIntoView(WebElement element) {
		log.info("Scroll till web element");
		executeScript("arguments[0].scrollIntoView()",element);
	}
    
	/**
     * This method will scroll into View and then Click
     * @param element
     */
	public void scrollIntoViewAndClick(WebElement element) {
		scrollIntoView(element);
		element.click();
		log.info("Element is clicked :"+element.toString());
	}
	
	/**
     * This method will scroll scroll down vertically
     * @param element
     */
	public void scrollDownVertically() {
		log.info("Scrolling down vertically");
		executeScript("window.scrollTo(0,document.body.scrollHeight)");
	}
	
	/**
     * This method will scroll scroll up vertically
     * @param element
     */
	public void scrollUpVertically() {
		log.info("Scrolling up vertically");
		executeScript("window.scrollTo(0,-document.body.scrollHeight)");
	}
	
	/**
     * This method will scroll scroll down by pixel
     */
	public void scrollDownByPixel(int pixel) {
		executeScript("window.scrollBy(0,"+pixel+")");
	}
	
	/**
     * This method will scroll scroll up by pixel
     */
	public void scrollUpByPixel(int pixel) {
		executeScript("window.scrollBy(0,-"+pixel+")");
	}

	/**
     * This method will zoom page by 100%
     */
	public void zoomInBy100Percentage() {
		executeScript("document.body.style.zoom='100%'");
	}
	
	/**
     * This method will zoom page by 60%
     */
	public void zoomInBy40Percentage() {
		executeScript("document.body.style.zoom='40%'");
	}
	
	/**
     * This method will click element
     */
	public void clickElement(WebElement element) {
		executeScript("arguments[0].click();",element);
		
	}
}

