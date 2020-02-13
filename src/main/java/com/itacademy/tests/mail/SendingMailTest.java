package com.itacademy.tests.mail;

import com.itacademy.pages.mail.LoginPage;
import com.itacademy.pages.mail.MailPage;
import com.itacademy.pages.mail.SentPage;
import com.itacademy.service.Browser;
import com.itacademy.tests.BaseTest;
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

  LoginPage loginPage;
  MailPage mailPage;
  SentPage sentPageYandex;

  @BeforeClass
  private void setUp() {
    loginPage = new LoginPage(Browser.getDriver());
    loginPage.loginToMail(LOGIN_YANDEX, PASSWORD).sendNewMail(LOGIN_YANDEX, MAIL_TEST);
  }

  @AfterClass
  private void tearDown() {
    WebDriverWait wait = new WebDriverWait(Browser.getDriver(), Duration.ofSeconds(30));
    WebElement newMail = wait.until(ExpectedConditions.elementToBeClickable(MAIL_SUBJECT_LOCATOR));
    mailPage.deleteTopMailFromIncomingIfEqualsGiven(MAIL_TEST);
    mailPage.goToSentPage().deleteTopMailFromSentIfEqualsGiven(MAIL_TEST);
    loginPage.doLogout();
  }

  @Test
  public void sentMailAppearedInSentTabTest() {
    mailPage = new MailPage(Browser.getDriver());
    WebDriverWait wait = new WebDriverWait(Browser.getDriver(), Duration.ofSeconds(30));
    WebElement newMail = wait.until(ExpectedConditions.elementToBeClickable(MAIL_SUBJECT_LOCATOR));
    boolean b = mailPage.goToSentPage().isTopMailSubjectEqualsGiven(MAIL_TEST);
    Assert.assertTrue(b, "mail wasn't send");
  }

  @Test(dependsOnMethods = "sentMailAppearedInSentTabTest")
  public void sentMailAppearedInIncomingTabTest() {
    sentPageYandex = new SentPage(Browser.getDriver());
    boolean b = sentPageYandex.returnToMailPage().isTopMailSubjectEqualsGiven(MAIL_TEST);
    Assert.assertTrue(b, "mail wasn't received");
  }
}
