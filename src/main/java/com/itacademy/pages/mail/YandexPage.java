package com.itacademy.pages.mail;

import static com.itacademy.framework.Browser.*;

import com.itacademy.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class YandexPage extends BasePage {

  private static final String YANDEX_URL = "https://www.yandex.by/";
  private static final By MAIL_BUTTON_LOCATOR = By
      .xpath("//a[@data-statlog=\"notifications.mail.logout.title\"]");

  public YandexPage(WebDriver driver) {
    super(driver);
  }

  public void clickMailButton() {
    clickButton(MAIL_BUTTON_LOCATOR);
  }
}
