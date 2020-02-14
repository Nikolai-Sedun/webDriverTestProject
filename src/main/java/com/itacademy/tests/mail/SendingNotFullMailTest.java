package com.itacademy.tests.mail;

import com.itacademy.models.Mail;
import com.itacademy.models.User;
import com.itacademy.service.mail.LoginPageService;
import com.itacademy.service.mail.MailPageService;
import com.itacademy.service.mail.SentPageService;
import com.itacademy.service.mail.YandexPageService;
import com.itacademy.tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SendingNotFullMailTest extends BaseTest {

  private static final String WRONG_ADDRESS = "agtjhgdjkhkhj";
  private static final String WITHOUT_SUBJECT = "(Без темы)";
  private static final String WRONG_ADDRESS_ERROR_MESSAGE = "Некорректные адреса: agtjhgdjkhkhj";

  private YandexPageService yandexPageService = new YandexPageService();
  private LoginPageService loginPageService = new LoginPageService();
  private MailPageService mailPageService = new MailPageService();
  private SentPageService sentPageService = new SentPageService();
  private User user = new User();
  private Mail mail = new Mail();

  @BeforeClass
  private void setUp() {
    yandexPageService.openLoginPage();
    loginPageService.loginToMail(user.getLogin(), user.getPassword());
  }

  @AfterClass
  private void tearDown() {
    mailPageService.deleteTopMailFromIncomingIfEqualsGiven(WITHOUT_SUBJECT);
    mailPageService.goToSentPage();
    sentPageService.deleteTopMailFromSentIfEqualsGiven(WITHOUT_SUBJECT);
    mailPageService.doLogout();
  }

  @Test(priority = 1)
  public void negativeMailTest() {
    Assert.assertEquals(mailPageService.tryInputWrongAddress(WRONG_ADDRESS),
        WRONG_ADDRESS_ERROR_MESSAGE, "Testing send with invalid address is failed");
    mailPageService.exitDraftMail();
  }

  @Test(priority = 2)
  public void sentNotFullMailAppearedInSentTabTest() {
    mailPageService.sendNotFullMail(mail.getAddress());
    waitNewMailArrive();
    mailPageService.goToSentPage();
    boolean b = sentPageService.isTopMailSubjectEqualsGiven(WITHOUT_SUBJECT);
    Assert.assertTrue(b, "mail wasn't send");
  }

  @Test(priority = 2, dependsOnMethods = "sentNotFullMailAppearedInSentTabTest")
  public void sentMailAppearedInIncomingTabTest() {
    sentPageService.returnToMailPage();
    waitNewMailArrive();
    boolean b = mailPageService.isTopMailSubjectEqualsGiven(WITHOUT_SUBJECT);
    Assert.assertTrue(b, "mail wasn't received");
  }
}
