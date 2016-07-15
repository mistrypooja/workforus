package test.java.com.assignment.base;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import test.java.com.assignment.config.Config;

public class SaucelabsDriverFactory implements IDriverFactory{

	static IRuntimeConfig config=new SaucelabsConfig(new Config());
	static DesiredCapabilities capabillities = null;
	
	String jobId = null;
	ThreadLocal<WebDriver> threadDriver = null;
	WebDriver driver = null;    
	private static ThreadLocal<WebDriver> webDriver = new ThreadLocal<WebDriver>();	

	public SaucelabsDriverFactory (IRuntimeConfig config){
		this.config=config;
	}	

	public WebDriver create() {		
		try {
			driver = new RemoteWebDriver(new URL(
					"http://"+config.getSaucelabsUserName()+":"+config.getSaucelabsKey()+"@ondemand.saucelabs.com:80/wd/hub"),
					getCapabilities());
		} catch (MalformedURLException e){
			e.printStackTrace();
		}
		return driver;		
	}

	public WebDriver getDriver() {
		return webDriver.get();
	}

	public SaucelabsConfig getConfig(){
		return (SaucelabsConfig) config;
	}

	public DesiredCapabilities getCapabilities(){
		return capabillities;			
	}

	public void setWebDriver(WebDriver driver){
		webDriver.set(driver);		       
	}

	public void setConfig(IRuntimeConfig configSet){
		config=configSet;		 
	}

	public void setCapabilities(DesiredCapabilities caps){
		capabillities=caps;		 
	}

}
