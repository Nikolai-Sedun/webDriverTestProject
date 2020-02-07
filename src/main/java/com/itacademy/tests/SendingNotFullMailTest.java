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
import org.testng.annotations.Test;

public class SendingNotFullMailTest extends BaseTest {

  private static final String WRONG_ADDRESS = "agtjhgdjkhkhj";
  private static final String WITHOUT_SUBJECT = "(Без темы)";
  private static final String WRONG_ADDRESS_ERROR_MESSAGE = "Некорректные адреса: agtjhgdjkhkhj";

  MailPageYandex mailPageYandex;
  LoginPageYandex loginPageYandex;
  SentPageYandex sentPageYandex;

  @AfterClass
  private void tearDown() {
    mailPageYandex = new MailPageYandex(driver);
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    WebElement newMail = wait.until(ExpectedConditions.elementToBeClickable(MAIL_SUBJECT_LOCATOR));
    mailPageYandex.deleteTopMailFromIncomingIfEqualsGiven(WITHOUT_SUBJECT);
    mailPageYandex.goToSentPage().deleteTopMailFromSentIfEqualsGiven(WITHOUT_SUBJECT);
    loginPageYandex.doLogout();
  }

  @Test(priority = 1)
  public void negativeMailTest() {
    loginPageYandex = new LoginPageYandex(driver);
    MailPageYandex mailPageYandex = loginPageYandex.loginToMail(LOGIN_YANDEX, PASSWORD);
    mailPageYandex.sendNotFullMail(WRONG_ADDRESS);
    Assert.assertEquals(mailPageYandex.getErrorMessage(), WRONG_ADDRESS_ERROR_MESSAGE,
        "Testing send with invalid address is failed");
    mailPageYandex.exitDraftMail();
  }

  @Test(priority = 2)
  public void sentNotFullMailAppearedInSentTabTest() {
    mailPageYandex = new MailPageYandex(driver);
    mailPageYandex.sendNotFullMail(LOGIN_YANDEX);
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    WebElement newMail = wait.until(ExpectedConditions.elementToBeClickable(MAIL_SUBJECT_LOCATOR));
    boolean b = mailPageYandex.goToSentPage().isTopMailSubjectEqualsGiven(WITHOUT_SUBJECT);
    Assert.assertTrue(b, "mail wasn't send");
  }

  @Test(priority = 2, dependsOnMethods = "sentNotFullMailAppearedInSentTabTest")
  public void sentMailAppearedInIncomingTabTest() {
    sentPageYandex = new SentPageYandex(driver);
    boolean b = sentPageYandex.returnToMailPage().isTopMailSubjectEqualsGiven(WITHOUT_SUBJECT);
    Assert.assertTrue(b, "mail wasn't received");
  }
}
