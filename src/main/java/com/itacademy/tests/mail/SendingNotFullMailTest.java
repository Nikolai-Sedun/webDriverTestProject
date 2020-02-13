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
import org.testng.annotations.Test;

public class SendingNotFullMailTest extends BaseTest {

  private static final String WRONG_ADDRESS = "agtjhgdjkhkhj";
  private static final String WITHOUT_SUBJECT = "(Без темы)";
  private static final String WRONG_ADDRESS_ERROR_MESSAGE = "Некорректные адреса: agtjhgdjkhkhj";

  MailPage mailPage;
  LoginPage loginPage;
  SentPage sentPageYandex;

  @AfterClass
  private void tearDown() {
    mailPage = new MailPage(Browser.getDriver());
    WebDriverWait wait = new WebDriverWait(Browser.getDriver(), Duration.ofSeconds(30));
    WebElement newMail = wait.until(ExpectedConditions.elementToBeClickable(MAIL_SUBJECT_LOCATOR));
    mailPage.deleteTopMailFromIncomingIfEqualsGiven(WITHOUT_SUBJECT);
    mailPage.goToSentPage().deleteTopMailFromSentIfEqualsGiven(WITHOUT_SUBJECT);
    loginPage.doLogout();
  }

  @Test(priority = 1)
  public void negativeMailTest() {
    loginPage = new LoginPage(Browser.getDriver());
    MailPage mailPage = loginPage.loginToMail(LOGIN_YANDEX, PASSWORD);
    mailPage.sendNotFullMail(WRONG_ADDRESS);
    Assert.assertEquals(mailPage.getErrorMessage(), WRONG_ADDRESS_ERROR_MESSAGE,
        "Testing send with invalid address is failed");
    mailPage.exitDraftMail();
  }

  @Test(priority = 2)
  public void sentNotFullMailAppearedInSentTabTest() {
    mailPage = new MailPage(Browser.getDriver());
    mailPage.sendNotFullMail(LOGIN_YANDEX);
    WebDriverWait wait = new WebDriverWait(Browser.getDriver(), Duration.ofSeconds(30));
    WebElement newMail = wait.until(ExpectedConditions.elementToBeClickable(MAIL_SUBJECT_LOCATOR));
    boolean b = mailPage.goToSentPage().isTopMailSubjectEqualsGiven(WITHOUT_SUBJECT);
    Assert.assertTrue(b, "mail wasn't send");
  }

  @Test(priority = 2, dependsOnMethods = "sentNotFullMailAppearedInSentTabTest")
  public void sentMailAppearedInIncomingTabTest() {
    sentPageYandex = new SentPage(Browser.getDriver());
    boolean b = sentPageYandex.returnToMailPage().isTopMailSubjectEqualsGiven(WITHOUT_SUBJECT);
    Assert.assertTrue(b, "mail wasn't received");
  }
}
