package com.itacademy.pages.mail;

import static com.itacademy.framework.Browser.*;

import com.itacademy.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DeletedPage extends BasePage {

  private static final By INCOMING_TAB_LOCATOR = By.xpath("//a[@data-title='Входящие']");
  private static final By FOLDER_CLEAR_LOCATOR = By.xpath("//a[@action=\"folder.clear\"]");
  private static final By CLEAR_CONFIRMATION_BUTTON_LOCATOR = By
      .xpath("//button[@data-dialog-action=\"dialog.submit\"]");
  private static final By DELETED_TAB_EMPTY_LOCATOR = By
      .xpath("//div[@class=\"b-messages__placeholder-item\"]");

  public DeletedPage(WebDriver driver) {
    super(driver);
  }

  public void clickClearConfirmationButton() {
    clickButton(CLEAR_CONFIRMATION_BUTTON_LOCATOR);
  }

  public void clickFolderClearButton() {
    clickButton(FOLDER_CLEAR_LOCATOR);
  }

  public void clickIncomingTabButton() {
    clickButton(INCOMING_TAB_LOCATOR);
  }

  public boolean isTabEmptyElementVisible() {
    return isVisible(DELETED_TAB_EMPTY_LOCATOR);
  }
}
