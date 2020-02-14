package com.itacademy.pages.mail;

import static com.itacademy.framework.Browser.*;

import com.itacademy.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DraftPage extends BasePage {

  private static final By MAIL_CHECKBOX_LOCATOR = By
      .xpath("//label[@class=\"mail-Toolbar-Item-Checkbox\"]/span");
  private static final By DELETE_DRAFT_BUTTON_LOCATOR = By
      .xpath("//span[contains(@class,\"js-toolbar-item-title-delete\")]");
  private static final By DELETED_TAB_LOCATOR = By.xpath("//a[@data-title='Удалённые']");

  public DraftPage(WebDriver driver) {
    super(driver);
  }

  public void clickMailCheckbox() {
    clickButton(MAIL_CHECKBOX_LOCATOR);
  }

  public void clickDeleteButton() {
    clickButton(DELETE_DRAFT_BUTTON_LOCATOR);
  }

  public void clickDeletedTabButton() {
    clickButton(DELETED_TAB_LOCATOR);
  }
}
