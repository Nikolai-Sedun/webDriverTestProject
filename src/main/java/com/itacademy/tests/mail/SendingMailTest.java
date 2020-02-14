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

public class SendingMailTest extends BaseTest {

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
    waitNewMailArrive();
    mailPageService.deleteTopMailFromIncomingIfEqualsGiven(mail.getSubject());
    mailPageService.goToSentPage();
    sentPageService.deleteTopMailFromSentIfEqualsGiven(mail.getSubject());
    mailPageService.doLogout();
  }

  @Test
  public void sentMailAppearedInSentTabTest() {
    mailPageService.sendNewMail(mail.getAddress(), mail.getSubject(), mail.getText());
    waitNewMailArrive();
    mailPageService.goToSentPage();
    boolean b = sentPageService.isTopMailSubjectEqualsGiven(mail.getSubject());
    Assert.assertTrue(b, "mail wasn't send");
  }

  @Test(dependsOnMethods = "sentMailAppearedInSentTabTest")
  public void sentMailAppearedInIncomingTabTest() {
    sentPageService.returnToMailPage();
    boolean b = mailPageService.isTopMailSubjectEqualsGiven(mail.getSubject());
    Assert.assertTrue(b, "mail wasn't received");
  }
}
