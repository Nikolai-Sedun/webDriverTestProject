package com.itacademy.tests.cloud;

import com.itacademy.models.User;
import com.itacademy.service.cloud.LoginPageService;
import com.itacademy.service.cloud.MainPageService;
import com.itacademy.tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

  private LoginPageService loginPageService = new LoginPageService();
  private MainPageService mainPageService = new MainPageService();
  private User user = new User();

  @BeforeClass
  private void setUp() {
    loginPageService.openCloudLoginPage();
  }

  @AfterClass
  private void tearDown() {
    mainPageService.doLogout();
  }

  @Test
  public void loginToCloudTest() {
    loginPageService.loginToMainPage(user.getLogin(), user.getPassword());
    Assert.assertTrue(mainPageService.checkDiskLogo(), "Login to cloud failed");
  }
}
