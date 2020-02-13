package com.itacademy.pages.mail;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DraftPage extends BasePage {

    private static final By MAIL_CHECKBOX_LOCATOR = By
            .xpath("//label[@class=\"mail-Toolbar-Item-Checkbox\"]/span");
    private static final By DELETE_DRAFT_BUTTON_LOCATOR = By
            .xpath("//span[contains(@class,\"js-toolbar-item-title-delete\")]");
    private static final By DELETED_TAB_LOCATOR = By.xpath("//a[@data-title='Удалённые']");

    public DraftPage(WebDriver driver) {
        super(driver);
    }

    public void deleteTopMailFromDraftIfEqualsGiven(String subject) {
        if (isTopMailSubjectEqualsGiven(subject)) {
            clickButton(MAIL_CHECKBOX_LOCATOR);
            clickButton(DELETE_DRAFT_BUTTON_LOCATOR);
        }
    }

    public DeletedPage goToDeletedPage() {
        clickButton(DELETED_TAB_LOCATOR);
        return new DeletedPage(driver);
    }
}
