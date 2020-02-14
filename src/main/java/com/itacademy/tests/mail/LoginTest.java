package com.itacademy.tests.mail;

import com.itacademy.models.User;
import com.itacademy.service.mail.LoginPageService;
import com.itacademy.service.mail.MailPageService;
import com.itacademy.service.mail.YandexPageService;
import com.itacademy.tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

  private static final String LOGIN = "mailtestframework";
  private static final String WRONG_LOGIN = "fkgsjhlmnmqqs";
  private static final String WRONG_LOGIN_ERROR_MESSAGE = "Такого аккаунта нет";

  private YandexPageService yandexPageService = new YandexPageService();
  private LoginPageService loginPageService = new LoginPageService();
  private MailPageService mailPageService = new MailPageService();
  private User user = new User();

  @Test
  public void loginToMailTest() {
    yandexPageService.openLoginPage();
    loginPageService.loginToMail(user.getLogin(), user.getPassword());
    Assert.assertTrue(mailPageService.isUsernameEqualsGiven(LOGIN),
        "Testing of logging with valid data is failed");
    mailPageService.doLogout();
  }

  @Test
  public void negativeLoginToMailTest() {
    yandexPageService.openLoginPage();
    String message = loginPageService.tryInputWrongLogin(WRONG_LOGIN);
    Assert.assertEquals(message, WRONG_LOGIN_ERROR_MESSAGE,
        "Testing of logging with invalid data is failed");
  }
}
