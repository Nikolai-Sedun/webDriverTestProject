package com.itacademy.service.cloud;

import static com.itacademy.framework.Browser.*;

import com.itacademy.framework.Browser;
import com.itacademy.pages.cloud.LoginPage;
import com.itacademy.pages.cloud.MainPage;

public class LoginPageService {

  private static final String YANDEX_DISK_URL = "https://disk.yandex.by/client/disk";

  private LoginPage loginPage = new LoginPage(Browser.getDriver());

  public LoginPage openCloudLoginPage() {
    open(YANDEX_DISK_URL);
    if (loginPage.isOtherAccountButtonVisible()) {
      loginPage.clickOtherAccountButton();
    }
    return new LoginPage(Browser.getDriver());
  }

  public MainPage loginToMainPage(String login, String password) {
    openCloudLoginPage();
    loginPage.insertLogin(login);
    loginPage.clickEnterButton();
    loginPage.insertPassword(password);
    loginPage.clickEnterButton();
    return new MainPage(Browser.getDriver());
  }
}
