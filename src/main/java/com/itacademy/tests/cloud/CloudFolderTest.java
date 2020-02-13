package com.itacademy.tests.cloud;

import com.itacademy.service.MainPageService;
import com.itacademy.tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CloudFolderTest extends BaseTest {

  private static final String FOLDER_NAME = "Новая папка";

  private MainPageService mainPageService;

  @BeforeClass
  public void setUp() {
    mainPageService = new MainPageService();
    mainPageService.loginToMainPage();
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
