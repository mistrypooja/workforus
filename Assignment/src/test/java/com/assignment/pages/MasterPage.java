package test.java.com.assignment.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import test.java.com.assignment.utility.ElementValidators;
import test.java.com.assignment.utility.GenericUtilities;

/**
 * Created by pooja.m on 13/07/2016.
 */
public class MasterPage {

    private WebDriver driver;
    ElementValidators elementValidators;
    GenericUtilities genericUtilities;

    public final String USERNAME_TEXTBOX_ID="edit-name";
    public final String PASSWORD_TEXTBOX_ID="edit-pass";
    public final String SUBMIT_BUTTON_ID="edit-submit";

    public final String USERNAME="civihr_admin";
    public final String PASSWORD="civihr_admin";

    public MasterPage(WebDriver driver ){

        this.driver = driver;
        elementValidators= new ElementValidators( driver);
        genericUtilities= new GenericUtilities(driver);

    }

    public void signIn(){

        driver.findElement(By.id(USERNAME_TEXTBOX_ID)).sendKeys(USERNAME);
        driver.findElement(By.id(PASSWORD_TEXTBOX_ID)).sendKeys(PASSWORD);
        driver.findElement(By.id(SUBMIT_BUTTON_ID)).submit();

    }
}
