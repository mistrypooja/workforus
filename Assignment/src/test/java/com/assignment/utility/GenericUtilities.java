package test.java.com.assignment.utility;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GenericUtilities {

    WebDriverWait wait = null;
    ElementValidators elementValidators;

    private WebDriver driver;
    public String textContainsLocator = "//%s[contains(.,'%s')]";
    public String text_locator = "//%s[.='%s']";
    public final String SUBMIT_LINK_ID = "submit";

    public enum ValidationType {EMAIL, SECRET_CODE}

    ;
    public final String mailinatorSubjectLocator = "//div[contains(@onclick, 'showTheMessage')]//div[contains(.,'%s')]";
    public final String MAILINATOR_EMAIL_TEXTBOX_LOCATOR = "inboxfield";

    public GenericUtilities(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
        elementValidators = new ElementValidators(driver);
    }

    public String generateRandomEmail() {
        long time = new java.util.Date().getTime();
        return "test" + time + "@mailinator.com";
    }

    public boolean refreshPage(By locatorToLookFor) throws InterruptedException {
        for (int i = 1; i <= 10; i++) {
            if (elementValidators.isElementPresent(locatorToLookFor)) {
                return true;
            } else
                Thread.sleep(5000);
            driver.navigate().refresh();
        }
        return false;
    }

    public void scrollUntilElementVisible(By locator) throws InterruptedException {
        for (int i = 1; i <= 5; i++) {
            if (elementValidators.isElementVisible(locator)) {
                break;
            } else {
                JavascriptExecutor jse = (JavascriptExecutor) driver;
                jse.executeScript("window.scrollBy(0,500)", "");
                Thread.sleep(500);
            }
        }
    }

    public void scroll(String pixels, boolean isUp) {

        JavascriptExecutor jse = (JavascriptExecutor) driver;

        if (isUp) {

            jse.executeScript(String.format("window.scrollBy(0,-%s)", pixels), "");
        } else
            jse.executeScript(String.format("window.scrollBy(0,%s)", pixels), "");
    }

    public void scrollInView(By locator) throws InterruptedException {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(locator));
        Thread.sleep(500);
    }

    public void safeClick(By locator) {

        elementValidators.waitForElementPresent(locator);
        driver.findElement(locator).sendKeys(Keys.ENTER);

    }

    public void click(By locator) {

        elementValidators.waitForElementPresent(locator);
        driver.findElement(locator).click();

    }

    public void hideJcfClass(String id) {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript(String.format("document.getElementById('%s').removeAttribute('class')", id));

    }


    public int getCount(By locator) {

        List<WebElement> elements = driver.findElements(locator);
        int count = 0;
        for (WebElement element : elements) {
            count++;
        }
        return count;

    }

    public void open(String url) {

        driver.get(url);
    }

    public String getURL() {

        return driver.getCurrentUrl();
    }

}
