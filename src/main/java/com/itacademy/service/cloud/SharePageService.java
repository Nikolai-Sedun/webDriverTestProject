package com.itacademy.service.cloud;

import com.itacademy.framework.Browser;
import com.itacademy.pages.cloud.MainPage;
import com.itacademy.pages.cloud.SharePage;

public class SharePageService {

  private SharePage sharePage = new SharePage(Browser.getDriver());

  public boolean isSharedElementEqualsGiven(String name) {
    return name.equals(sharePage.getSharedElementText());
  }

  public MainPage returnToMainPage() {
    sharePage.clickDiskLogo();
    return new MainPage(Browser.getDriver());
  }
}
