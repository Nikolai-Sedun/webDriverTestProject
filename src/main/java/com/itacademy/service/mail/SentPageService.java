package com.itacademy.service.mail;

import com.itacademy.framework.Browser;
import com.itacademy.pages.mail.MailPage;
import com.itacademy.pages.mail.SentPage;

public class SentPageService {

  private SentPage sentPage = new SentPage(Browser.getDriver());

  public void deleteTopMailFromSentIfEqualsGiven(String subject) {
    if (isTopMailSubjectEqualsGiven(subject)) {
      sentPage.clickMailCheckbox();
      sentPage.clickDeleteButton();
    }
  }

  public boolean isTopMailSubjectEqualsGiven(String subject) {
    return subject.equals(sentPage.getTopMailSubject());
  }

  public MailPage returnToMailPage() {
    sentPage.clickIncomingTabButton();
    return new MailPage(Browser.getDriver());
  }
}
