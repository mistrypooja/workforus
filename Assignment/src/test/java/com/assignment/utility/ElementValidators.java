package test.java.com.assignment.utility;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class ElementValidators {

	WebDriverWait wait = null;

	private WebDriver driver;
	public String textContainsLocator="//%s[contains(.,'%s')]";
	public String text_locator="//%s[.='%s']";
	public final String SUBMIT_LINK_ID="submit";
	public enum ValidationType {EMAIL,SECRET_CODE};
	public final String mailinatorSubjectLocator="//div[contains(@onclick, 'showTheMessage')]//div[contains(.,'%s')]";
	public final String MAILINATOR_EMAIL_TEXTBOX_LOCATOR="inboxfield";

	public ElementValidators(WebDriver driver){
		this.driver = driver;
		wait = new WebDriverWait(driver, 10);
	}



	public boolean isElementPresent(By by) {

		try {
			driver.findElement(by).isDisplayed();
			return true;
		} catch (Exception e) {
			System.out.print(e);
			return false;
		}
	}

	public boolean isElementPresent(By by, int timeout) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, timeout);
			wait.until(ExpectedConditions.presenceOfElementLocated(by));
			driver.findElement(by);
			return true;
		} catch (Exception e) {
			System.out.print(e);
			return false;
		}
	}		

	public boolean isElementVisible(By by, int timeout) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, timeout);
			wait.until(ExpectedConditions.visibilityOfElementLocated(by));
			driver.findElement(by);
			return true;
		} catch (Exception e) {
			System.out.print(e);
			return false;
		}
	}

	public boolean isElementVisible(By by) {
		try {			
			driver.findElement(by);
			return true;
		} catch (Exception e) {
			System.out.print(e);
			return false;
		}
	}	

	public boolean waitForAlertPresent() throws InterruptedException {
		boolean presentFlag = false;
		for (int i=1;i<=60;i++)
		{
			try 
			{
				presentFlag = true;
			} catch (NoAlertPresentException ex) 
			{		   
				ex.printStackTrace();
			}
			Thread.sleep(1000);
		}
		return presentFlag;
	}


	public void waitForElementPresent(By locator){

		wait.until(ExpectedConditions.presenceOfElementLocated(locator));

	}


	public void waitForElementVisible(By locator){

		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

	}

	public void waitForElementNotVisible(By locator){

		wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));

	}

	public void waitForStalenessOf(WebElement element){
		wait.until(ExpectedConditions.stalenessOf(element));
	}

}
