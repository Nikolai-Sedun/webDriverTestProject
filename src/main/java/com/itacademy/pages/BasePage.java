package com.itacademy.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class BasePage {

    private static final By MAIL_SUBJECT_LOCATOR = By
        .xpath("//span[contains(@class, \"js-message-snippet-subject\")]//span[@title]");
    private static final String ATTRIBUTE_NAME = "title";

    WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isTopMailSubjectEqualsGiven(String subject) {
        return subject.equals(getElementAttribute(MAIL_SUBJECT_LOCATOR, ATTRIBUTE_NAME));
    }

    protected void clickButton(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        driver.findElement(locator).click();
    }

    protected String getElementText(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        return driver.findElement(locator).getText();
    }

    protected void sendKeysToElement(By locator, String keys) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        driver.findElement(locator).sendKeys(keys);
    }

    protected String getElementAttribute(By locator, String attribute) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        return driver.findElement(locator).getAttribute(attribute);
    }
}
