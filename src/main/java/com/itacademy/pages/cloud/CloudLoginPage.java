package com.itacademy.pages.cloud;

import static com.itacademy.service.Browser.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CloudLoginPage extends CloudBasePage {

  private static final By LOGIN_INPUT_LOCATOR = By.name("login");
  private static final By PASSWORD_INPUT_LOCATOR = By.name("passwd");
  private static final By SUBMIT_BUTTON_LOCATOR = By.xpath("//button[@type=\"submit\"]");

  public CloudLoginPage(WebDriver driver) {
    super(driver);
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
}
