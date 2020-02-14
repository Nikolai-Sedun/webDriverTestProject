package com.itacademy.tests.cloud;

import com.itacademy.models.User;
import com.itacademy.service.cloud.LoginPageService;
import com.itacademy.service.cloud.MainPageService;
import com.itacademy.tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FolderTest extends BaseTest {

  private static final String FOLDER_NAME = "Новая папка";

  private LoginPageService loginPageService = new LoginPageService();
  private MainPageService mainPageService = new MainPageService();
  private User user = new User();

  @BeforeClass
  public void setUp() {
    loginPageService.openCloudLoginPage();
    loginPageService.loginToMainPage(user.getLogin(), user.getPassword());
  }

  @AfterClass
  private void tearDown() {
    mainPageService.doLogout();
  }

  @Test
  public void creatingFolderTest() {
    mainPageService.createNewFolder();
    Assert.assertTrue(mainPageService.isFirstElementNameEqualsGiven(FOLDER_NAME),
        "folder creation failed");
  }

  @Test
  public void deletingFolderTest() {
    mainPageService.deleteFolder();
    Assert.assertFalse(mainPageService.isFirstElementNameEqualsGiven(FOLDER_NAME),
        "folder deleting failed");
  }
}

