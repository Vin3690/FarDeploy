package Config;

import helper.browserConfiguration.BrowserType;

public interface ConfigReader {
	
	public int getImplicitWait();
	public int getExplicitWait();
	public int getPageLoadTime();
	public BrowserType getBrowser();
	public String getUrl();
	public String getuserEmail();
	public String getuserPassword();
	
	

}
