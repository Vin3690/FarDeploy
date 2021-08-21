package helper.browserConfiguration;


import java.util.HashMap;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;




import io.github.bonigarcia.wdm.WebDriverManager;

public class EdgeBrowser {

	private WebDriver createEdgeDriver() {
		HashMap<String, Object> edgePrefs = new HashMap<String, Object>();
		edgePrefs.put("profile.default_content_settings.popups", 0);
		EdgeOptions options = new EdgeOptions();
		options.setCapability("prefs", edgePrefs);
		options.setCapability("useAutomationExtension", false);
		return null;
	}
	
	public WebDriver getEdgeDriver() {
		WebDriverManager.edgedriver().setup();
		return new EdgeDriver();
	}
	
	public static void main(String[] args) {
		EdgeBrowser obj = new EdgeBrowser();
		WebDriver driver = obj.getEdgeDriver();
		driver.get("https://www.zomato.com/Latur");
	}

}
