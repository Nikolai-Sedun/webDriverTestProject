package com.itacademy.service.mail;

import com.itacademy.framework.Browser;
import com.itacademy.pages.mail.LoginPage;
import com.itacademy.pages.mail.MailPage;

public class LoginPageService {

  private LoginPage loginPage = new LoginPage(Browser.getDriver());

  public MailPage loginToMail(String login, String password) {
    if (loginPage.isOtherAccountButtonVisible()) {
      loginPage.clickOtherAccountButton();
    }
    loginPage.insertLogin(login);
    loginPage.clickEnterButton();
    loginPage.insertPassword(password);
    loginPage.clickEnterButton();
    return new MailPage(Browser.getDriver());
  }

  public String tryInputWrongLogin(String login) {
    if (loginPage.isOtherAccountButtonVisible()) {
      loginPage.clickOtherAccountButton();
    }
    loginPage.insertLogin(login);
    loginPage.clickEnterButton();
    return loginPage.getErrorMessage();
  }
}
