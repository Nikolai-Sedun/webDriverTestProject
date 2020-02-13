package com.itacademy.pages.mail;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

  private static final String YANDEX_URL = "https://www.yandex.by/";
  private static final By MAIL_BUTTON_LOCATOR = By
      .xpath("//a[@data-statlog=\"notifications.mail.logout.title\"]");
  private static final By LOGIN_INPUT_LOCATOR = By.name("login");
  private static final By SUBMIT_BUTTON_LOCATOR = By.xpath("//button[@type=\"submit\"]");
  private static final By PASSWORD_INPUT_LOCATOR = By.name("passwd");
  private static final By LOGIN_CHECK_LOCATOR = By.className("mail-User-Name");
  private static final By ERROR_MESSAGE_LOCATOR = By.className("passp-form-field__error");
  private static final By LOGOUT_BUTTON_LOCATOR = By
      .xpath("//a[@data-metric=\"Sign out of Yandex services\"]");
  private static final By OTHER_ACCOUNT_BUTTON_LOCATOR = By
      .xpath("//a[contains(text(),\"Другой аккаунт\")]");

  public LoginPage(WebDriver driver) {
    super(driver);
  }

  public MailPage loginToMail(String login, String password) {
    open();
    insertLogin(login);
    insertPassword(password);
    return new MailPage(driver);
  }

  public LoginPage open() {
    driver.get(YANDEX_URL);
    clickButton(MAIL_BUTTON_LOCATOR);
    if (driver.findElement(OTHER_ACCOUNT_BUTTON_LOCATOR).isDisplayed()) {
      clickButton(OTHER_ACCOUNT_BUTTON_LOCATOR);
    }
    return new LoginPage(driver);
  }

  public void insertLogin(String login) {
    sendKeysToElement(LOGIN_INPUT_LOCATOR, login);
    clickButton(SUBMIT_BUTTON_LOCATOR);
  }

  public void insertPassword(String password) {
    sendKeysToElement(PASSWORD_INPUT_LOCATOR, password);
    clickButton(SUBMIT_BUTTON_LOCATOR);
  }

  public void doLogout() {
    clickButton(LOGIN_CHECK_LOCATOR);
    clickButton(LOGOUT_BUTTON_LOCATOR);
  }

  public String checkLogin() {
    return getElementText(LOGIN_CHECK_LOCATOR);
  }

  public String getErrorMessage() {
    return getElementText(ERROR_MESSAGE_LOCATOR);
  }
}
