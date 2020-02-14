package com.itacademy.tests.cloud;

import com.itacademy.models.User;
import com.itacademy.service.cloud.LoginPageService;
import com.itacademy.service.cloud.MainPageService;
import com.itacademy.tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FileTest extends BaseTest {

  private static final String TEST_FILE_PATH = "./src/main/java/resources/TestFile.txt";
  private static final String TEST_FILE_NAME = "TestFile.txt";

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
  public void uploadingFileTest() {
    mainPageService.uploadFileToRoot(TEST_FILE_PATH);
    Assert.assertTrue(mainPageService.isFirstElementNameEqualsGiven(TEST_FILE_NAME),
        "file uploading failed");
  }

  @Test(dependsOnMethods = "uploadingFileTest")
  public void dragAndDropFileTest() {
    mainPageService.createNewFolder();
    mainPageService.moveFileToFolderAndOpen();
    Assert.assertTrue(mainPageService.isFirstElementNameEqualsGiven(TEST_FILE_NAME),
        "file drag and drop failed");
  }
}

