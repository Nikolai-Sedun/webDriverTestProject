package com.itacademy.service;

import static com.itacademy.service.Browser.*;

import com.itacademy.pages.cloud.CloudLoginPage;
import com.itacademy.pages.cloud.CloudMainPage;
import java.nio.file.FileSystems;

import com.itacademy.pages.cloud.CloudSharePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPageService {

  private static final String LOGIN_YANDEX = "mailtestframework@yandex.by";
  private static final String PASSWORD = "2020FrameworkTest";
  private static final String YANDEX_DISK_URL = "https://disk.yandex.by/client/disk";
  private static final By OTHER_ACCOUNT_BUTTON_LOCATOR = By
      .xpath("//a[contains(text(),\"Другой аккаунт\")]");
  private static final By DISK_LOGO_LOCATOR = By
      .xpath("//span[@class=\"logo burger-sidebar__logo\"]");

  private WebDriver driver = Browser.getDriver();
  private CloudMainPage cloudMainPage;
  private CloudLoginPage cloudLoginPage;
  private CloudSharePage cloudSharePage;

  public CloudLoginPage openCloudLoginPage() {
    open(YANDEX_DISK_URL);
    if (driver.findElement(OTHER_ACCOUNT_BUTTON_LOCATOR).isDisplayed()) {
      clickButton(OTHER_ACCOUNT_BUTTON_LOCATOR);
    }
    return this.cloudLoginPage = new CloudLoginPage(driver);
  }

  public CloudMainPage loginToMainPage() {
    openCloudLoginPage();
    cloudLoginPage.insertLogin(LOGIN_YANDEX);
    cloudLoginPage.clickEnterButton();
    cloudLoginPage.insertPassword(PASSWORD);
    cloudLoginPage.clickEnterButton();
    return this.cloudMainPage = new CloudMainPage(driver);
  }

  public boolean isDiskLogoVisible() {
    return isVisible(DISK_LOGO_LOCATOR);
  }

  public void doLogout() {
    cloudMainPage.callUserMenu();
    cloudMainPage.clickExitButton();
  }

  public void createNewFolder() {
    cloudMainPage.clickCreateButton();
    cloudMainPage.clickFolderButton();
    cloudMainPage.clickSaveButton();
    refresh();
  }

  public boolean isFirstElementNameEqualsGiven(String name) {
    return name.equals(cloudMainPage.getFirstElementName());
  }

  public void deleteFolder() {
    cloudMainPage.callFirstElementContextMenu();
    cloudMainPage.clickDeleteButton();
  }

  public void moveFileToFolderAndOpen() {
    cloudMainPage.dragAndDropFileToFolder();
    cloudMainPage.openFirstElement();
  }

  public void uploadFileToRoot(String relativePath) {
    cloudMainPage.selectPathToFile(getAbsolutePath(relativePath));
    refresh();
  }

  private String getAbsolutePath(String relativePath) {
    return FileSystems.getDefault().getPath(relativePath).normalize().toAbsolutePath().toString();
  }

  public void goToSharedPage() {
    cloudMainPage.callFirstElementContextMenu();
    cloudMainPage.clickShareButton();
    open(cloudMainPage.getSharedElementLink());
    this.cloudSharePage = new CloudSharePage(driver);
  }

  public boolean isSharedElementEqualsGiven(String name) {
    return name.equals(cloudSharePage.getSharedElementText());
  }
}
