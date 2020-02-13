package com.itacademy.pages.cloud;

import static com.itacademy.service.Browser.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CloudMainPage extends CloudBasePage {

  private static final By CREATE_BUTTON_LOCATOR = By.className("create-resource-popup-with-anchor");
  private static final By UPLOAD_FILE_INPUT_LOCATOR = By.xpath("//input[@type=\"file\"]");
  private static final By FOLDER_BUTTON_LOCATOR = By.xpath("//span[contains(text(),\"Папку\")]");
  private static final By SAVE_BUTTON_LOCATOR = By
      .xpath("//span[contains(text(),\"Сохранить\")]//parent::button");
  private static final By FIRST_ELEMENT_NAME_LOCATOR = By.xpath("//div/span[@class=\"clamped-text\"]");
  private static final By FILE_LOCATOR = By
      .xpath("//div[contains(@class,\"listing-item_type_file\")]");
  private static final By FOLDER_LOCATOR = By
      .xpath("//div[contains(@class,\"listing-item_type_dir\")][1]");
  private static final By CONTEXT_DELETE_LOCATOR = By.xpath("//span[contains(text(),\"Удалить\")]");
  private static final By CONTEXT_SHARE_LOCATOR = By.xpath("//span[contains(text(),\"Поделиться\")]");
  private static final By CONTEXT_LINK_LOCATOR = By.className("publish-resource-tumbler__input");
  private static final By USER_ACCOUNT_MENU_CALL_LOCATOR = By
      .xpath("//a[starts-with(@class,\"user-account\")]");
  private static final By EXIT_BUTTON_LOCATOR = By.xpath("//a[contains(text(), \"Выйти\")]");
  private static final String ATTRIBUTE_CONTAINS_LINK = "value";

  public CloudMainPage(WebDriver driver) {
    super(driver);
  }

  public void callUserMenu() {
    clickButton(USER_ACCOUNT_MENU_CALL_LOCATOR);
  }

  public void clickExitButton() {
    clickButton(EXIT_BUTTON_LOCATOR);
  }

  public void clickCreateButton() {
    clickButton(CREATE_BUTTON_LOCATOR);
  }

  public void clickFolderButton() {
    clickButton(FOLDER_BUTTON_LOCATOR);
  }

  public void clickSaveButton() {
    clickButton(SAVE_BUTTON_LOCATOR);
  }

  public String getFirstElementName() {
    return getElementText(FIRST_ELEMENT_NAME_LOCATOR);
  }

  public void callFirstElementContextMenu() {
    callContextMenu(FIRST_ELEMENT_NAME_LOCATOR);
  }

  public void clickDeleteButton() {
    clickButton(CONTEXT_DELETE_LOCATOR);
  }

  public void clickShareButton() {
    clickButton(CONTEXT_SHARE_LOCATOR);
  }

  public String getSharedElementLink() {
    return getElementAttributeValue(CONTEXT_LINK_LOCATOR, ATTRIBUTE_CONTAINS_LINK);
  }

  public void dragAndDropFileToFolder() {
    dragAndDrop(FILE_LOCATOR, FOLDER_LOCATOR);
  }

  public void openFirstElement() {
    doubleClickElement(FIRST_ELEMENT_NAME_LOCATOR);
  }

  public void selectPathToFile(String relativePath) {
    sendKeysToHiddenElement(UPLOAD_FILE_INPUT_LOCATOR, relativePath);
  }
}
