package com.itacademy.tests.cloud;

import com.itacademy.service.MainPageService;
import com.itacademy.tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CloudFileTest extends BaseTest {

  private static final String TEST_FILE_PATH = "./src/main/java/resources/TestFile.txt";
  private static final String TEST_FILE_NAME = "TestFile.txt";

  private MainPageService mainPageService;

  @BeforeClass
  public void setUp() {
    mainPageService = new MainPageService();
    mainPageService.loginToMainPage();
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
