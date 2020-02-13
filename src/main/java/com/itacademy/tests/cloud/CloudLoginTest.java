package com.itacademy.tests.cloud;

import com.itacademy.service.MainPageService;
import com.itacademy.tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CloudLoginTest extends BaseTest {

  private static final String LOGIN = "mailtestframework";

  MainPageService mainPageService;

  @BeforeClass
  private void setUp() {
    mainPageService = new MainPageService();
    mainPageService.openCloudLoginPage();
  }

  @Test
  public void loginToCloudTest() {
    mainPageService.loginToMainPage();
    Assert.assertTrue(mainPageService.isDiskLogoVisible(), "Login to cloud failed");
  }
}
