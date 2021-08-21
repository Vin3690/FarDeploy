package Config;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import helper.browserConfiguration.BrowserType;
import helper.resource.ResourceHelper;

public class PropertyReader implements ConfigReader {
	
	public static Properties pro;
	public FileInputStream file;

	public PropertyReader() {
		try {
		    String filepath=ResourceHelper.getResourcePath("\\src\\main\\resources\\configfile\\config.properties");
		    FileInputStream file=new FileInputStream(new File(filepath));
		    pro=new Properties();
		    pro.load(file);
		    
		}catch(Exception e) {
			
			e.printStackTrace();	
		}
	}
	
	
	public int getImplicitWait() {
		return Integer.parseInt(pro.getProperty("implicitwait"));
	}

	public int getExplicitWait() {
		return Integer.parseInt(pro.getProperty("explicitwait"));
	}

	public int getPageLoadTime() {
		return Integer.parseInt(pro.getProperty("pageloadtime"));
	}

	public BrowserType getBrowser() {
		return BrowserType.valueOf(pro.getProperty("browsertype"));
	}


	public String getUrl() {
		return pro.getProperty("applicationUrl");
	}


	public String getuserEmail() {
		return pro.getProperty("UserEmail");
	}


	public String getuserPassword() {
		return pro.getProperty("UserPassword");
	}
}
