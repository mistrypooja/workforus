package test.java.com.assignment.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;

import test.java.com.assignment.config.*;

public class WebdriverListener implements IInvokedMethodListener{
	final IRuntimeConfig config = new SaucelabsConfig(new Config());
	IDriverFactory saucelabsDriver = new SaucelabsDriverFactory(config);
	WebDriver driver=null;
	@Override
	public void beforeInvocation(IInvokedMethod method, ITestResult testResult){		 

		if (method.isTestMethod()){
			
			if(!saucelabsDriver.getConfig().getRunLocal()){
				driver = saucelabsDriver.create();
				saucelabsDriver.setWebDriver(driver);
			}

			else if (saucelabsDriver.getConfig().getRunLocal() && !config.getHeadless()) {
				if(config.getTestableBrowsersList().get(0).equals("firefox")){
					driver = new FirefoxDriver();						
				}
				else if(config.getTestableBrowsersList().get(0).equals("chrome")){
					System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/ChromeServer/chromedriver.exe");
					driver = new ChromeDriver();	        			
				}
				else if(config.getTestableBrowsersList().get(0).equals("ie")){
					System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+"/IEServer/IEDriverServer.exe");
					driver = new InternetExplorerDriver();	        			
				}
			}


				saucelabsDriver.setWebDriver(driver);
			

		}
	}

	@Override
	public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
		
		if (method.isTestMethod()) {
			
			WebDriver driver = saucelabsDriver.getDriver();
			if (driver != null) {
				driver.quit();
			}
			
			
		}
	}
}
