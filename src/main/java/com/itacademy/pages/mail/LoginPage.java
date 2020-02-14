package com.itacademy.pages.mail;

import static com.itacademy.framework.Browser.*;

import com.itacademy.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

  private static final By LOGIN_INPUT_LOCATOR = By.name("login");
  private static final By SUBMIT_BUTTON_LOCATOR = By.xpath("//button[@type=\"submit\"]");
  private static final By PASSWORD_INPUT_LOCATOR = By.name("passwd");
  private static final By ERROR_MESSAGE_LOCATOR = By.className("passp-form-field__error");
  private static final By OTHER_ACCOUNT_BUTTON_LOCATOR = By
      .xpath("//a[contains(text(),\"Другой аккаунт\")]");

  public LoginPage(WebDriver driver) {
    super(driver);
  }

  public void clickOtherAccountButton() {
    clickButton(OTHER_ACCOUNT_BUTTON_LOCATOR);
  }

  public boolean isOtherAccountButtonVisible() {
    return isVisible(OTHER_ACCOUNT_BUTTON_LOCATOR);
  }

  public void insertLogin(String login) {
    sendKeysToElement(LOGIN_INPUT_LOCATOR, login);
  }

  public void insertPassword(String password) {
    sendKeysToElement(PASSWORD_INPUT_LOCATOR, password);
  }

  public void clickEnterButton() {
    clickButton(SUBMIT_BUTTON_LOCATOR);
  }

  public String getErrorMessage() {
    return getElementText(ERROR_MESSAGE_LOCATOR);
  }
}
