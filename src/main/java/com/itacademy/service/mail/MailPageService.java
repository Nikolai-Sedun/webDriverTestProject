package com.itacademy.service.mail;

import static com.itacademy.framework.Browser.refresh;

import com.itacademy.framework.Browser;
import com.itacademy.pages.mail.DeletedPage;
import com.itacademy.pages.mail.DraftPage;
import com.itacademy.pages.mail.MailPage;
import com.itacademy.pages.mail.SentPage;

public class MailPageService {

  private MailPage mailPage = new MailPage(Browser.getDriver());

  public boolean isUsernameEqualsGiven(String name) {
    return name.equals(mailPage.getUsername());
  }

  public void sendNewMail(String address, String subject, String mailText) {
    mailPage.clickWriteButton();
    mailPage.inputMailAddress(address);
    mailPage.inputMailSubject(subject);
    mailPage.inputMailText(mailText);
    mailPage.clickSendButton();
  }

  public void sendNotFullMail(String address) {
    mailPage.clickWriteButton();
    mailPage.inputMailAddress(address);
    mailPage.clickSendButton();
  }

  public String tryInputWrongAddress(String address) {
    mailPage.clickWriteButton();
    mailPage.inputMailAddress(address);
    mailPage.clickSendButton();
    return mailPage.getErrorAddressMessage();
  }

  public void createDraftMail(String subject, String mailText) {
    mailPage.clickWriteButton();
    mailPage.inputMailSubject(subject);
    mailPage.inputMailText(mailText);
    exitDraftMail();
  }

  public void exitDraftMail() {
    mailPage.clickExitMailButton();
    mailPage.clickConfirmExitButton();
  }

  public boolean isTopMailSubjectEqualsGiven(String subject) {
    return subject.equals(mailPage.getTopMailSubject());
  }

  public void deleteTopMailFromIncomingIfEqualsGiven(String subject) {
    if (isTopMailSubjectEqualsGiven(subject)) {
      mailPage.clickMailCheckbox();
      mailPage.clickDeleteButton();
    }
  }

  public SentPage goToSentPage() {
    mailPage.clickSentTabButton();
    return new SentPage(Browser.getDriver());
  }

  public DeletedPage goToDeletedPage() {
    mailPage.clickDeletedTabButton();
    return new DeletedPage(Browser.getDriver());
  }

  public DraftPage goToDraftPage() {
    mailPage.clickDraftTabButton();
    refresh();
    return new DraftPage(Browser.getDriver());
  }

  public void doLogout() {
    mailPage.getUserMenu();
    mailPage.clickLogoutButton();
  }
}
