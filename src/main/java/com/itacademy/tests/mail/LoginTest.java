package com.itacademy.tests.mail;

import com.itacademy.pages.mail.LoginPage;
import com.itacademy.service.Browser;
import com.itacademy.tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

  private static final String LOGIN = "mailtestframework";
  private static final String WRONG_LOGIN = "fkgsjhlmnmqqs";
  private static final String WRONG_LOGIN_ERROR_MESSAGE = "Такого аккаунта нет";

  @BeforeMethod
  private void setUp() {
    LoginPage loginPage = new LoginPage(Browser.getDriver());
    loginPage.open();
  }

  @Test
  public void loginToMailTest() {
    LoginPage loginPage = new LoginPage(Browser.getDriver());
    loginPage.insertLogin(LOGIN_YANDEX);
    loginPage.insertPassword(PASSWORD);
    Assert.assertEquals(loginPage.checkLogin(), LOGIN,
        "Testing of logging with valid data is failed");
    loginPage.doLogout();
  }

  @Test
  public void negativeLoginToMailTest() {
    LoginPage loginPage = new LoginPage(Browser.getDriver());
    loginPage.insertLogin(WRONG_LOGIN);
    Assert.assertEquals(loginPage.getErrorMessage(), WRONG_LOGIN_ERROR_MESSAGE,
        "Testing of logging with invalid data is failed");
  }
}
