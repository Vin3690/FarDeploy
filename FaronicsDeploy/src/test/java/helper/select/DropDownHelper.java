package helper.select;

import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import helper.logger.LoggerHelper;

public class DropDownHelper {
	
	WebDriver driver;
	private Logger log=LoggerHelper.getLogger(DropDownHelper.class);
	
	public DropDownHelper(WebDriver driver) {
		this.driver=driver;
		log.info("DropDownHelper objects has been initialized...");
	}
	
	public void selectUsingValue(WebElement element, String value) {
		Select select=new Select(element);
		select.selectByValue(value);
		log.info("Element selected from dropdown box by value... and value is : "+value);
		
	}
	
	public void selectUsingIndex(WebElement element, int index) {
		Select select=new Select(element);
		select.selectByIndex(index);
		log.info("Element selected from dropdown box by index... and index is : "+index);
		
	}
	
	public void selectUsingVisibleText(WebElement element, String visibleText) {
		Select select=new Select(element);
		select.selectByVisibleText(visibleText);
		log.info("Element selected from dropdown box by visible text... and visible text is : "+visibleText);
		
	}
	
	public void deselectUsingValue(WebElement element, String value) {
		Select select=new Select(element);
		select.deselectByValue(value);
		log.info("Deselected element from dropdown box by value... and value is : "+value);
		
	}
	
	public void deselectUsingIndex(WebElement element, int index) {
		Select select=new Select(element);
		select.deselectByIndex(index);
		log.info("Deselected element from dropdown box by index... and index is : "+index);
		
	}
	
	public void deselectUsingVisibleText(WebElement element, String visibletext) {
		Select select=new Select(element);
		select.deselectByVisibleText(visibletext);
		log.info("Deselected element from dropdown box by visibletext... and visibletext is : "+visibletext);
		
	}

	
	public List<String> getAllDropDownData(WebElement element){
		
		Select select=new Select(element);
		List<WebElement> elementList=select.getOptions();
		List<String> valueList=new LinkedList<String>();
		for(WebElement ele:elementList) {
			log.info(ele.getText());
			valueList.add(ele.getText());
		}
		return valueList;
	}  
}
