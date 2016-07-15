package test.java.com.assignment.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public interface IDriverFactory {
	
	public WebDriver create();

	public SaucelabsConfig getConfig();

	public DesiredCapabilities getCapabilities();

	void setWebDriver(WebDriver driver);

	public void setConfig(IRuntimeConfig configSet);

	public void setCapabilities(DesiredCapabilities caps);
	
	public WebDriver getDriver();

}
