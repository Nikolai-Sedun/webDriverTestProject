package com.itacademy.tests.cloud;

import com.itacademy.models.User;
import com.itacademy.service.cloud.LoginPageService;
import com.itacademy.service.cloud.MainPageService;
import com.itacademy.service.cloud.SharePageService;
import com.itacademy.tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ShareTest extends BaseTest {

  private static final String FOLDER_NAME = "Новая папка";

  private LoginPageService loginPageService = new LoginPageService();
  private MainPageService mainPageService = new MainPageService();
  private SharePageService sharePageService = new SharePageService();
  private User user = new User();

  @BeforeClass
  public void setUp() {
    loginPageService.openCloudLoginPage();
    loginPageService.loginToMainPage(user.getLogin(), user.getPassword());
  }

  @AfterClass
  private void tearDown() {
    sharePageService.returnToMainPage();
    mainPageService.deleteFolder();
    mainPageService.doLogout();
  }

  @Test
  public void sharingElementTest() {
    mainPageService.goToSharedPage();
    Assert.assertTrue(sharePageService.isSharedElementEqualsGiven(FOLDER_NAME),
        "sharing element failed");
  }
}
