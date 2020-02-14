package com.itacademy.pages;

import static com.itacademy.framework.Browser.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BasePage {

  private static final By MAIL_SUBJECT_LOCATOR = By
      .xpath("//span[contains(@class, \"js-message-snippet-subject\")]//span[@title]");
  private static final String ATTRIBUTE_NAME = "title";

  WebDriver driver;

  public BasePage(WebDriver driver) {
    this.driver = driver;
  }

  public String getTopMailSubject() {
    return getElementAttributeValue(MAIL_SUBJECT_LOCATOR, ATTRIBUTE_NAME);
  }
}
