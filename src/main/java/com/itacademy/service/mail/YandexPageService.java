package com.itacademy.service.mail;

import static com.itacademy.framework.Browser.*;

import com.itacademy.framework.Browser;
import com.itacademy.pages.mail.LoginPage;
import com.itacademy.pages.mail.YandexPage;

public class YandexPageService {

  private static final String YANDEX_URL = "https://www.yandex.by/";

  YandexPage yandexPage = new YandexPage(Browser.getDriver());

  public LoginPage openLoginPage() {
    open(YANDEX_URL);
    yandexPage.clickMailButton();
    return new LoginPage(Browser.getDriver());
  }
}
