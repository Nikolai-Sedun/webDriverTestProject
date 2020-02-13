package com.itacademy.tests;

import com.itacademy.service.Browser;
import org.openqa.selenium.By;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseTest {

  protected static final String LOGIN_YANDEX = "mailtestframework@yandex.by";
  protected static final String PASSWORD = "2020FrameworkTest";
  protected static final By MAIL_SUBJECT_LOCATOR = By
      .xpath("//span[contains(@class, \"js-message-snippet-subject\")]//span[@title]");

  @BeforeSuite
  public void openBrowser() {
    Browser.getInstance();
  }

  @AfterSuite
  public void closeBrowser() {
    Browser.getInstance().stopBrowser();
  }
}
