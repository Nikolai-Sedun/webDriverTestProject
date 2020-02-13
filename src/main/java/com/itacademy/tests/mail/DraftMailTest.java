package com.itacademy.tests.mail;

import com.itacademy.pages.mail.DeletedPage;
import com.itacademy.pages.mail.DraftPage;
import com.itacademy.pages.mail.LoginPage;
import com.itacademy.pages.mail.MailPage;
import com.itacademy.service.Browser;
import com.itacademy.tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DraftMailTest extends BaseTest {

  private static final String DRAFT_TEST = "Framework Draft Test";
  private static final String DELETED_TAB_EMPTY_MESSAGE = "В папке «Удалённые» нет писем.";

  LoginPage loginPage;
  MailPage mailPage;
  DeletedPage deletedPage;
  DraftPage draftPage;

  @BeforeClass
  private void setUp() {
    loginPage = new LoginPage(Browser.getDriver());
    mailPage = loginPage.loginToMail(LOGIN_YANDEX, PASSWORD);
    deletedPage = mailPage.goToDeletedPage();
    if(!deletedPage.isDeletedTabEmpty()){
      deletedPage.clearDeletedTab();
    }
    deletedPage.returnToMailPage();
  }

  @Test
  public void deletedDraftMailAppearedInDeletedTabTest() {
    mailPage = new MailPage(Browser.getDriver());
    mailPage.createDraftMail(DRAFT_TEST);
    draftPage = mailPage.goToDraftPage();
    draftPage.deleteTopMailFromDraftIfEqualsGiven(DRAFT_TEST);
    draftPage.goToDeletedPage();
    boolean b = mailPage.goToDeletedPage().isTopMailSubjectEqualsGiven(DRAFT_TEST);
    Assert.assertTrue(b, "draft mail wasn't appear in deleted tab");
  }

  @Test(dependsOnMethods = "deletedDraftMailAppearedInDeletedTabTest")
  public void deletedFromDeletedTabMailCompletelyGone() {
    deletedPage = new DeletedPage(Browser.getDriver());
    deletedPage.clearDeletedTab();
    Assert.assertEquals(deletedPage.getDeletedTabEmptyMessage(), DELETED_TAB_EMPTY_MESSAGE,
        "deleting from deleted tab gone wrong");
  }
}
