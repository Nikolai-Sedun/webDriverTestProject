package com.itacademy.tests;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

public class BaseTest {

  protected static final String LOGIN_YANDEX = "mailtestframework@yandex.by";
  protected static final String PASSWORD = "2020FrameworkTest";
  protected static final By MAIL_SUBJECT_LOCATOR = By
      .xpath("//span[contains(@class, \"js-message-snippet-subject\")]//span[@title]");

  protected static WebDriver driver;

  @BeforeSuite
  public void openBrowser() {
    System.setProperty("webdriver.chrome.driver", "./src/main/java/resources/chromedriver.exe");
    driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  }

  @AfterSuite
  public void closeBrowser() {
    driver.quit();
  }
}
