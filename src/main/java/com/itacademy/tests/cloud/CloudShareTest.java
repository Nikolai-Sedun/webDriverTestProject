package com.itacademy.tests.cloud;

import com.itacademy.service.MainPageService;
import com.itacademy.tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CloudShareTest extends BaseTest {

  private static final String FOLDER_NAME = "Новая папка";

  private MainPageService mainPageService;

  @BeforeClass
  public void setUp() {
    mainPageService = new MainPageService();
    mainPageService.loginToMainPage();
  }

  @Test
  public void sharingElementTest() {
    mainPageService.goToSharedPage();
    Assert.assertTrue(mainPageService.isSharedElementEqualsGiven(FOLDER_NAME),
        "sharing element failed");
  }
}
