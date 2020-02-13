package com.itacademy.pages.mail;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class DeletedPage extends BasePage {

    private static final By INCOMING_TAB_LOCATOR = By.xpath("//a[@data-title='Входящие']");
    private static final By FOLDER_CLEAR_LOCATOR = By.xpath("//a[@action=\"folder.clear\"]");
    private static final By CLEAR_CONFIRMATION_BUTTON_LOCATOR = By
            .xpath("//button[@data-dialog-action=\"dialog.submit\"]");
    private static final By DELETED_TAB_EMPTY_LOCATOR = By
            .xpath("//div[@class=\"b-messages__placeholder-item\"]");

    public DeletedPage(WebDriver driver) {
        super(driver);
    }

    public void clearDeletedTab() {
        clickButton(FOLDER_CLEAR_LOCATOR);
        clickButton(CLEAR_CONFIRMATION_BUTTON_LOCATOR);
    }

    public MailPage returnToMailPage() {
        clickButton(INCOMING_TAB_LOCATOR);
        return new MailPage(driver);
    }

    public String getDeletedTabEmptyMessage() {
        return getElementText(DELETED_TAB_EMPTY_LOCATOR);
    }

    public boolean isDeletedTabEmpty() {
        Boolean elementCondition = false;
        try {
            elementCondition = driver.findElement(DELETED_TAB_EMPTY_LOCATOR).isDisplayed();
        } catch (NoSuchElementException e) {
            return elementCondition;
        }
        return elementCondition;
    }
}
