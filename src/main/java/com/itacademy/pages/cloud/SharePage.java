package com.itacademy.pages.cloud;

import static com.itacademy.framework.Browser.*;

import com.itacademy.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SharePage extends BasePage {

  public SharePage(WebDriver driver) {
    super(driver);
  }

  private static final By SHARED_ELEMENT_NAME_LOCATOR = By.className("listing-item__title");
  private static final By DISK_LOGO_LOCATOR = By
      .xpath("//a[@href=\"https://disk.yandex.by\"]");

  public String getSharedElementText() {
    return getElementText(SHARED_ELEMENT_NAME_LOCATOR);
  }

  public void clickDiskLogo() {
    clickButton(DISK_LOGO_LOCATOR);
  }
}
