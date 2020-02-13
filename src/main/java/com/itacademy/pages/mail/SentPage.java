package com.itacademy.pages.mail;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SentPage extends BasePage {

  private static final By INCOMING_TAB_LOCATOR = By.xpath("//a[@data-title='Входящие']");
  private static final By MAIL_CHECKBOX_LOCATOR = By
      .xpath("//label[@class=\"mail-Toolbar-Item-Checkbox\"]/span");
  private static final By DELETE_BUTTON_LOCATOR = By.xpath("//span[contains(text(),\"Удалить\")]");

  public SentPage(WebDriver driver) {
    super(driver);
  }

  public void deleteTopMailFromSentIfEqualsGiven(String subject) {
    if (isTopMailSubjectEqualsGiven(subject)) {
      clickButton(MAIL_CHECKBOX_LOCATOR);
      clickButton(DELETE_BUTTON_LOCATOR);
    }
  }

  public MailPage returnToMailPage() {
    clickButton(INCOMING_TAB_LOCATOR);
    return new MailPage(driver);
  }
}
