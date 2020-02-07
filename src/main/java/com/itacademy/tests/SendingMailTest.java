package com.itacademy.tests;

import com.itacademy.pages.LoginPageYandex;
import com.itacademy.pages.MailPageYandex;
import com.itacademy.pages.SentPageYandex;
import java.time.Duration;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SendingMailTest extends BaseTest {

  private static final String MAIL_TEST = "Framework Mail Test";

  LoginPageYandex loginPageYandex;
  MailPageYandex mailPageYandex;
  SentPageYandex sentPageYandex;

  @BeforeClass
  private void setUp() {
    loginPageYandex = new LoginPageYandex(driver);
    loginPageYandex.loginToMail(LOGIN_YANDEX, PASSWORD).sendNewMail(LOGIN_YANDEX, MAIL_TEST);
  }

  @AfterClass
  private void tearDown() {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    WebElement newMail = wait.until(ExpectedConditions.elementToBeClickable(MAIL_SUBJECT_LOCATOR));
    mailPageYandex.deleteTopMailFromIncomingIfEqualsGiven(MAIL_TEST);
    mailPageYandex.goToSentPage().deleteTopMailFromSentIfEqualsGiven(MAIL_TEST);
    loginPageYandex.doLogout();
  }

  @Test(priority = 1)
  public void sentMailAppearedInSentTabTest() {
    mailPageYandex = new MailPageYandex(driver);
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    WebElement newMail = wait.until(ExpectedConditions.elementToBeClickable(MAIL_SUBJECT_LOCATOR));
    boolean b = mailPageYandex.goToSentPage().isTopMailSubjectEqualsGiven(MAIL_TEST);
    Assert.assertTrue(b, "mail wasn't send");
  }

  @Test(priority = 1, dependsOnMethods = "sentMailAppearedInSentTabTest")
  public void sentMailAppearedInIncomingTabTest() {
    sentPageYandex = new SentPageYandex(driver);
    boolean b = sentPageYandex.returnToMailPage().isTopMailSubjectEqualsGiven(MAIL_TEST);
    Assert.assertTrue(b, "mail wasn't received");
  }
}
