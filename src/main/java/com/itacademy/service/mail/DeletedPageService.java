package com.itacademy.service.mail;

import com.itacademy.framework.Browser;
import com.itacademy.pages.mail.DeletedPage;
import com.itacademy.pages.mail.MailPage;
import org.openqa.selenium.NoSuchElementException;

public class DeletedPageService {

  private DeletedPage deletedPage = new DeletedPage(Browser.getDriver());

  public boolean isDeletedTabEmpty() {
    boolean elementCondition = false;
    try {
      elementCondition = deletedPage.isTabEmptyElementVisible();
    } catch (
        NoSuchElementException e) {
      return elementCondition;
    }
    return elementCondition;
  }

  public MailPage returnToMailPage() {
    deletedPage.clickIncomingTabButton();
    return new MailPage(Browser.getDriver());
  }

  public void clearDeletedTab() {
    deletedPage.clickFolderClearButton();
    deletedPage.clickClearConfirmationButton();
  }

  public boolean isTopMailSubjectEqualsGiven(String subject) {
    return subject.equals(deletedPage.getTopMailSubject());
  }
}
