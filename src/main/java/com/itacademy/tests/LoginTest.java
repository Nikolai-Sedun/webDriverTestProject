package com.itacademy.tests;

import com.itacademy.pages.LoginPageYandex;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

  private static final String LOGIN = "mailtestframework";
  private static final String WRONG_LOGIN = "fkgsjhlmnmqqs";
  private static final String WRONG_LOGIN_ERROR_MESSAGE = "Такого аккаунта нет";

  @BeforeMethod
  private void setUp() {
    LoginPageYandex loginPageYandex = new LoginPageYandex(driver);
    loginPageYandex.goToLoginPage();
  }

  @Test
  public void loginToMailTest() {
    LoginPageYandex loginPageYandex = new LoginPageYandex(driver);
    loginPageYandex.insertLogin(LOGIN_YANDEX);
    loginPageYandex.insertPassword(PASSWORD);
    Assert.assertEquals(loginPageYandex.checkLogin(), LOGIN,
        "Testing of logging with valid data is failed");
    loginPageYandex.doLogout();
  }

  @Test
  public void negativeLoginToMailTest() {
    LoginPageYandex loginPageYandex = new LoginPageYandex(driver);
    loginPageYandex.insertLogin(WRONG_LOGIN);
    Assert.assertEquals(loginPageYandex.getErrorMessage(), WRONG_LOGIN_ERROR_MESSAGE,
        "Testing of logging with invalid data is failed");
  }
}
