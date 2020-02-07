package com.itacademy.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MailPageYandex extends BasePage {

    private static final By WRITE_MAIL_BUTTON_LOCATOR = By.xpath("//a[@href=\"#compose\"]");
    private static final By ADDRESS_INPUT_LOCATOR = By.name("to");
    private static final By SUBJECT_INPUT_LOCATOR = By.xpath("//div/input[@type=\"text\"]");
    private static final By MAIL_TEXT_INPUT_LOCATOR = By.xpath("//div[@role=\"textbox\"]");
    private static final By SEND_BUTTON_LOCATOR = By
            .xpath("//div[@data-key=\"view=compose-send-button-complex\"]/button");
    private static final By SENT_TAB_LOCATOR = By.xpath("//a[@data-title='Отправленные']");
    private static final By DELETED_TAB_LOCATOR = By.xpath("//a[@data-title='Удалённые']");
    private static final By DRAFT_TAB_LOCATOR = By.xpath("//a[@href='#draft']/span");
    private static final By MAIL_CHECKBOX_LOCATOR = By
            .xpath("//label[@class=\"mail-Toolbar-Item-Checkbox\"]/span");
    private static final By DELETE_BUTTON_LOCATOR = By.xpath("//span[contains(text(),\"Удалить\")]");
    private static final By EXIT_MAIL_BUTTON_LOCATOR = By
            .xpath("//div[@data-key=\"view=compose-cancel-button\"]");
    private static final By CONFIRM_EXIT_BUTTON_LOCATOR = By.xpath("//button[@data-action=\"save\"]");
    private static final By REFRESH_BUTTON_LOCATOR = By
            .xpath("//span[@data-click-action=\"mailbox.check\"]");
    private static final By ERROR_ADDRESS_MESSAGE_LOCATOR = By
            .xpath("//div[@data-key=\"view=compose-field-to-error\"]");

    public MailPageYandex(WebDriver driver) {
        super(driver);
    }

    public void sendNewMail(String address, String mailText) {
        clickButton(WRITE_MAIL_BUTTON_LOCATOR);
        inputMailAddress(address);
        inputMailSubject(mailText);
        inputMailText(mailText);
        clickButton(SEND_BUTTON_LOCATOR);
    }

    public void sendNotFullMail(String address) {
        clickButton(WRITE_MAIL_BUTTON_LOCATOR);
        inputMailAddress(address);
        clickButton(SEND_BUTTON_LOCATOR);
    }

    public void createDraftMail(String mailText) {
        clickButton(WRITE_MAIL_BUTTON_LOCATOR);
        inputMailSubject(mailText);
        inputMailText(mailText);
        exitDraftMail();
    }

    public void deleteTopMailFromIncomingIfEqualsGiven(String subject) {
        if (isTopMailSubjectEqualsGiven(subject)) {
            clickButton(MAIL_CHECKBOX_LOCATOR);
            clickButton(DELETE_BUTTON_LOCATOR);
        }
    }

    private void inputMailAddress(String address) {
        sendKeysToElement(ADDRESS_INPUT_LOCATOR, address);
    }

    private void inputMailSubject(String subject) {
        sendKeysToElement(SUBJECT_INPUT_LOCATOR, subject);
    }

    private void inputMailText(String mailText) {
        sendKeysToElement(MAIL_TEXT_INPUT_LOCATOR, mailText);
    }

    public void exitDraftMail() {
        clickButton(EXIT_MAIL_BUTTON_LOCATOR);
        clickButton(CONFIRM_EXIT_BUTTON_LOCATOR);
    }

    public SentPageYandex goToSentPage() {
        clickButton(SENT_TAB_LOCATOR);
        return new SentPageYandex(driver);
    }

    public DeletedPageYandex goToDeletedPage() {
        clickButton(DELETED_TAB_LOCATOR);
        return new DeletedPageYandex(driver);
    }

    public DraftPageYandex goToDraftPage() {
        clickButton(DRAFT_TAB_LOCATOR);
        clickButton(REFRESH_BUTTON_LOCATOR);
        return new DraftPageYandex(driver);
    }

    public String getErrorMessage() {
        return getElementText(ERROR_ADDRESS_MESSAGE_LOCATOR);
    }
}
