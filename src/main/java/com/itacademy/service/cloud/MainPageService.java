package com.itacademy.service.cloud;

import static com.itacademy.framework.Browser.*;

import com.itacademy.framework.Browser;
import com.itacademy.pages.cloud.MainPage;
import java.nio.file.FileSystems;
import com.itacademy.pages.cloud.SharePage;

public class MainPageService {

  private MainPage mainPage = new MainPage(Browser.getDriver());

  public boolean checkDiskLogo() {
    return mainPage.isDiskLogoVisible();
  }

  public void doLogout() {
    mainPage.callUserMenu();
    mainPage.clickExitButton();
  }

  public void createNewFolder() {
    mainPage.clickCreateButton();
    mainPage.clickFolderButton();
    mainPage.clickSaveButton();
    refresh();
  }

  public boolean isFirstElementNameEqualsGiven(String name) {
    return name.equals(mainPage.getFirstElementName());
  }

  public void deleteFolder() {
    mainPage.callFirstElementContextMenu();
    mainPage.clickDeleteButton();
    if (mainPage.isTrashNotificationVisible()) {
      mainPage.clickTrashClean();
    }
  }

  public void moveFileToFolderAndOpen() {
    mainPage.dragAndDropFileToFolder();
    mainPage.openFirstElement();
  }

  public void uploadFileToRoot(String relativePath) {
    mainPage.selectPathToFile(getAbsolutePath(relativePath));
    refresh();
  }

  private String getAbsolutePath(String relativePath) {
    return FileSystems.getDefault().getPath(relativePath).normalize().toAbsolutePath().toString();
  }

  public SharePage goToSharedPage() {
    mainPage.callFirstElementContextMenu();
    mainPage.clickShareButton();
    open(mainPage.getSharedElementLink());
    return new SharePage(Browser.getDriver());
  }
}
