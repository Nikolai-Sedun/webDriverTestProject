package com.itacademy.tests.mail;

import com.itacademy.models.User;
import com.itacademy.service.mail.DeletedPageService;
import com.itacademy.service.mail.DraftPageService;
import com.itacademy.service.mail.LoginPageService;
import com.itacademy.service.mail.MailPageService;
import com.itacademy.service.mail.YandexPageService;
import com.itacademy.tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DraftMailTest extends BaseTest {

  private static final String DRAFT_TEST = "Framework Draft Test";

  private YandexPageService yandexPageService = new YandexPageService();
  private LoginPageService loginPageService = new LoginPageService();
  private MailPageService mailPageService = new MailPageService();
  private DeletedPageService deletedPageService = new DeletedPageService();
  private DraftPageService draftPageService = new DraftPageService();
  private User user = new User();

  @BeforeClass
  private void setUp() {
    yandexPageService.openLoginPage();
    loginPageService.loginToMail(user.getLogin(), user.getPassword());
    mailPageService.goToDeletedPage();
    if (!deletedPageService.isDeletedTabEmpty()) {
      deletedPageService.clearDeletedTab();
    }
    deletedPageService.returnToMailPage();
  }

  @AfterClass
  private void tearDown() {
    mailPageService.doLogout();
  }

  @Test
  public void deletedDraftMailAppearedInDeletedTabTest() {
    mailPageService.createDraftMail(DRAFT_TEST, DRAFT_TEST);
    mailPageService.goToDraftPage();
    draftPageService.deleteTopMailFromDraftIfEqualsGiven(DRAFT_TEST);
    draftPageService.goToDeletedPage();
    boolean b = deletedPageService.isTopMailSubjectEqualsGiven(DRAFT_TEST);
    Assert.assertTrue(b, "draft mail wasn't appear in deleted tab");
  }

  @Test(dependsOnMethods = "deletedDraftMailAppearedInDeletedTabTest")
  public void deletedFromDeletedTabMailCompletelyGone() {
    deletedPageService.clearDeletedTab();
    Assert.assertTrue(deletedPageService.isDeletedTabEmpty(),
        "deleting from deleted tab gone wrong");
  }
}
