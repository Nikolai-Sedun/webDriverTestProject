package com.itacademy.pages.mail;

import static com.itacademy.framework.Browser.*;

import com.itacademy.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MailPage extends BasePage {

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
  private static final By ERROR_ADDRESS_MESSAGE_LOCATOR = By
      .xpath("//div[@data-key=\"view=compose-field-to-error\"]");
  private static final By USERNAME_LOCATOR = By.className("mail-User-Name");
  private static final By LOGOUT_BUTTON_LOCATOR = By
      .xpath("//a[@data-metric=\"Sign out of Yandex services\"]");

  public MailPage(WebDriver driver) {
    super(driver);
  }

  public String getUsername() {
    return getElementText(USERNAME_LOCATOR);
  }

  public void clickWriteButton() {
    clickButton(WRITE_MAIL_BUTTON_LOCATOR);
  }

  public void inputMailAddress(String address) {
    sendKeysToElement(ADDRESS_INPUT_LOCATOR, address);
  }

  public String getErrorAddressMessage() {
    return getElementText(ERROR_ADDRESS_MESSAGE_LOCATOR);
  }

  public void inputMailSubject(String subject) {
    sendKeysToElement(SUBJECT_INPUT_LOCATOR, subject);
  }

  public void inputMailText(String mailText) {
    sendKeysToElement(MAIL_TEXT_INPUT_LOCATOR, mailText);
  }

  public void clickSendButton() {
    clickButton(SEND_BUTTON_LOCATOR);
  }

  public void clickExitMailButton() {
    clickButton(EXIT_MAIL_BUTTON_LOCATOR);
  }

  public void clickConfirmExitButton() {
    clickButton(CONFIRM_EXIT_BUTTON_LOCATOR);
  }

  public void clickMailCheckbox() {
    clickButton(MAIL_CHECKBOX_LOCATOR);
  }

  public void clickDeleteButton() {
    clickButton(DELETE_BUTTON_LOCATOR);
  }

  public void clickSentTabButton() {
    clickButton(SENT_TAB_LOCATOR);
  }

  public void clickDraftTabButton() {
    clickButton(DRAFT_TAB_LOCATOR);
  }

  public void clickDeletedTabButton() {
    clickButton(DELETED_TAB_LOCATOR);
  }

  public void getUserMenu() {
    clickButton(USERNAME_LOCATOR);
  }

  public void clickLogoutButton() {
    clickButton(LOGOUT_BUTTON_LOCATOR);
  }
}
