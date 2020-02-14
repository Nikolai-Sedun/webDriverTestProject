package com.itacademy.tests;

import static com.itacademy.framework.Browser.waitElementToBeClickable;

import com.itacademy.framework.Browser;
import org.openqa.selenium.By;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseTest {

  private static final By MAIL_SUBJECT_LOCATOR = By
      .xpath("//span[contains(@class, \"js-message-snippet-subject\")]//span[@title]");

  @BeforeSuite
  public void openBrowser() {
    Browser.getInstance();
  }

  @AfterSuite
  public void closeBrowser() {
    Browser.getInstance().stopBrowser();
  }

  protected void waitNewMailArrive() {
    waitElementToBeClickable(MAIL_SUBJECT_LOCATOR);
  }
}

