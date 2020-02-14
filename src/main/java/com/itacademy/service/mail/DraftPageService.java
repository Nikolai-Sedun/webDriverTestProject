package com.itacademy.service.mail;

import com.itacademy.framework.Browser;
import com.itacademy.pages.mail.DeletedPage;
import com.itacademy.pages.mail.DraftPage;

public class DraftPageService {

  private DraftPage draftPage = new DraftPage(Browser.getDriver());

  public void deleteTopMailFromDraftIfEqualsGiven(String subject) {
    if (isTopMailSubjectEqualsGiven(subject)) {
      draftPage.clickMailCheckbox();
      draftPage.clickDeleteButton();
    }
  }

  private boolean isTopMailSubjectEqualsGiven(String subject) {
    return subject.equals(draftPage.getTopMailSubject());
  }

  public DeletedPage goToDeletedPage() {
    draftPage.clickDeletedTabButton();
    return new DeletedPage(Browser.getDriver());
  }
}
