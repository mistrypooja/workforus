package test.java.com.assignment.usecase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import test.java.com.assignment.base.IDriverFactory;
import test.java.com.assignment.base.IRuntimeConfig;
import test.java.com.assignment.base.SaucelabsConfig;
import test.java.com.assignment.base.SaucelabsDriverFactory;
import test.java.com.assignment.config.Config;
import test.java.com.assignment.pages.DocumentPage;
import test.java.com.assignment.pages.MasterPage;
import test.java.com.assignment.utility.ElementValidators;
import test.java.com.assignment.utility.GenericUtilities;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * Created by pooja.m on 15/07/2016.
 */
public class EditDocument {
    WebDriver driver = null;
    IRuntimeConfig config = new SaucelabsConfig(new Config());
    IDriverFactory saucelabsDriver = new SaucelabsDriverFactory(config);
    ElementValidators elementValidators;
    GenericUtilities genericUtilities;

    @Test
    public void testAddDocument() throws TimeoutException {
        driver = saucelabsDriver.getDriver();

        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        genericUtilities=new GenericUtilities(driver);
        elementValidators=new ElementValidators(driver);
        MasterPage masterPage = new MasterPage(driver);
        DocumentPage documentPage = new DocumentPage(driver);
        genericUtilities.open(config.getAppUrl());
        masterPage.signIn();
        genericUtilities.open(config.getAppUrl() + "/index.php?q=civicrm/tasksassignments/dashboard#/documents");
        documentPage.editDocument();

        documentPage.selectDocumentType("Joining Document 2");
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_MONTH, 10);
        Date date = cal.getTime();
        DateFormat ndf = new SimpleDateFormat("dd/MM/yyyy");
        String dueDate = ndf.format(date);
        documentPage.setDueDate(dueDate);

        documentPage.saveForm();
        elementValidators.waitForElementNotVisible(By.xpath(documentPage.SAVE_BUTTON_LOCATOR));

    }

}

