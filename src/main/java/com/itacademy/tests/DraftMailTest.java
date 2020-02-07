package com.itacademy.tests;

import com.itacademy.pages.DeletedPageYandex;
import com.itacademy.pages.DraftPageYandex;
import com.itacademy.pages.LoginPageYandex;
import com.itacademy.pages.MailPageYandex;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DraftMailTest extends BaseTest {

  private static final String DRAFT_TEST = "Framework Draft Test";
  private static final String DELETED_TAB_EMPTY_MESSAGE = "В папке «Удалённые» нет писем.";

  LoginPageYandex loginPageYandex;
  MailPageYandex mailPageYandex;
  DeletedPageYandex deletedPageYandex;
  DraftPageYandex draftPageYandex;

  @BeforeClass
  private void setUp() {
    loginPageYandex = new LoginPageYandex(driver);
    mailPageYandex = loginPageYandex.loginToMail(LOGIN_YANDEX, PASSWORD);
    deletedPageYandex = mailPageYandex.goToDeletedPage();
    if(!deletedPageYandex.isDeletedTabEmpty()){
      deletedPageYandex.clearDeletedTab();
    }
    deletedPageYandex.returnToMailPage();
  }

  @Test
  public void deletedDraftMailAppearedInDeletedTabTest() {
    mailPageYandex = new MailPageYandex(driver);
    mailPageYandex.createDraftMail(DRAFT_TEST);
    draftPageYandex = mailPageYandex.goToDraftPage();
    draftPageYandex.deleteTopMailFromDraftIfEqualsGiven(DRAFT_TEST);
    draftPageYandex.goToDeletedPage();
    boolean b = mailPageYandex.goToDeletedPage().isTopMailSubjectEqualsGiven(DRAFT_TEST);
    Assert.assertTrue(b, "draft mail wasn't appear in deleted tab");
  }

  @Test(dependsOnMethods = "deletedDraftMailAppearedInDeletedTabTest")
  public void deletedFromDeletedTabMailCompletelyGone() {
    deletedPageYandex = new DeletedPageYandex(driver);
    deletedPageYandex.clearDeletedTab();
    Assert.assertEquals(deletedPageYandex.getDeletedTabEmptyMessage(), DELETED_TAB_EMPTY_MESSAGE,
        "deleting from deleted tab gone wrong");
  }
}
