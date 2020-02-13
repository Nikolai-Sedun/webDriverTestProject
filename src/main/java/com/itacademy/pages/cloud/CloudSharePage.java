package com.itacademy.pages.cloud;

import static com.itacademy.service.Browser.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CloudSharePage extends CloudBasePage {

  public CloudSharePage(WebDriver driver) {
    super(driver);
  }

  private static final By SHARED_ELEMENT_NAME_LOCATOR = By.className("listing-item__title");

  public String getSharedElementText() {
    return getElementText(SHARED_ELEMENT_NAME_LOCATOR);
  }
}
