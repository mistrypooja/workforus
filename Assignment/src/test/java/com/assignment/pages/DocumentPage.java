package test.java.com.assignment.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import test.java.com.assignment.utility.ElementValidators;
import test.java.com.assignment.utility.GenericUtilities;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.datatransfer.StringSelection;

/**
 * Created by pooja.m on 14/07/2016.
 */
public class DocumentPage {

    private WebDriver driver;
    ElementValidators elementValidators;
    GenericUtilities genericUtilities;

    public final String ADD_DOCUMENT_BUTTON_LOCATOR = "//a[contains(@ng-click,'itemAdd')]";
    public final String DOCUMENT_TYPE_DROPDOWN_LCOATOR = "//select[@ng-model='document.activity_type_id']";
    public final String DUE_DATE_TEXTBOX_ID = "ct-document-due";
    public final String ADD_ASSIGNEE_LOCATOR = "//a[.='Add Assignee']";
    public final String ASSIGNEE_TOP_TEXTBOX_LOCATOR =
            "//form[@name='documentForm']//div[contains(@ng-show,'document.assignee_contact_id[0] || showAssigneeField')]" +
                    "//span[contains(@ng-show,'select.isEmpty')]";
    public final String FIRST_RESULT_LOCATOR = "//a[contains(@class,'ui-select-choices')]";
    public final String ASSIGNEE_TEXTBOX_LOCATOR =
            "//form[@name='documentForm']//div[contains(@ng-show,'document.assignee_contact_id[0] || showAssigneeField')]//input";
    public final String TARGET_CONTACT_TOP_TEXTBOX_LOCATOR = "//form[@name='documentForm']//div[contains(@ng-model,'document.target_contact_id[0]')]//span";
    public final String TARGET_CONTACT_TEXTBOX_LCOATOR = "//form[@name='documentForm']//div[contains(@ng-model,'document.target_contact_id[0]')]//input";
    public final String SAVE_BUTTON_LOCATOR = "//button[@type='submit' and contains(@class,'primary')]";
public final String MENU_LINK_LOCATOR="//table[contains(@class,'ct-table-documents')]//tbody/tr/td[@class='ng-scope']" +
        "//a[contains(@class,'ct-context-menu-toggle')]";
public final String EDIT_LINK_LOCATOR="//table[contains(@class,'ct-table-documents')]//tbody/tr/td[@class='ng-scope']" +
        "//a[contains(@class,'ct-context-menu-toggle')]//following-sibling::ul//a[@ng-click='modalDocument(document, $event);']";

    public DocumentPage(WebDriver driver) {

        this.driver = driver;
        elementValidators = new ElementValidators(driver);
        genericUtilities = new GenericUtilities(driver);

    }

    public void clickAddDocumentLink() {
        elementValidators.waitForElementVisible(By.xpath(ADD_DOCUMENT_BUTTON_LOCATOR));
        genericUtilities.click(By.xpath(ADD_DOCUMENT_BUTTON_LOCATOR));
    }

    public void selectDocumentType(String documentType) {
        new Select(driver.findElement(By.xpath(DOCUMENT_TYPE_DROPDOWN_LCOATOR))).selectByVisibleText(documentType);
    }

    public void setDueDate(String date) {
        driver.findElement(By.id(DUE_DATE_TEXTBOX_ID)).clear();
        driver.findElement(By.id(DUE_DATE_TEXTBOX_ID)).sendKeys(date);
    }

    public void uploadFile(String path) throws AWTException {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("document.getElementById('ct-document-files').style.display='block';");
        driver.findElement(By.id("ct-document-files")).sendKeys(path);

    }


    public void setAssignee(String name) {

        genericUtilities.click(By.xpath(ADD_ASSIGNEE_LOCATOR));
        genericUtilities.click(By.xpath(ASSIGNEE_TOP_TEXTBOX_LOCATOR));
        driver.findElement(By.xpath(ASSIGNEE_TEXTBOX_LOCATOR)).sendKeys(name);
        genericUtilities.click(By.xpath(FIRST_RESULT_LOCATOR));
    }

    public void setTargetContact(String name) {


        genericUtilities.click(By.xpath(TARGET_CONTACT_TOP_TEXTBOX_LOCATOR));
        driver.findElement(By.xpath(TARGET_CONTACT_TEXTBOX_LCOATOR)).sendKeys(name);
        genericUtilities.click(By.xpath(FIRST_RESULT_LOCATOR));
    }

    public void saveForm() {
        genericUtilities.click(By.xpath(SAVE_BUTTON_LOCATOR));
    }

    public void editDocument(){
        genericUtilities.click(By.xpath(MENU_LINK_LOCATOR));
        elementValidators.waitForElementVisible(By.xpath(EDIT_LINK_LOCATOR));
        genericUtilities.click(By.xpath(EDIT_LINK_LOCATOR));
    }


}
