package com.itacademy.service;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Browser {

    private static Browser instance;
    private static WebDriver driver;

    private Browser() {
        System.setProperty("webdriver.chrome.driver", "./src/main/java/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public static Browser getInstance() {
        if (instance == null) {
            instance = new Browser();
        }
        return instance;
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public void stopBrowser() {
        getInstance().getDriver().close();
        getInstance().getDriver().quit();
        getInstance().driver = null;
    }

    public static void open(String url) {
        driver.get(url);
    }

    public static void refresh() {
        driver.navigate().refresh();
    }

    public static void clickButton(By locator) {
        waitElementToBeClickable(locator).click();
    }

    public static String getElementText(By locator) {
        return waitElementToBeVisible(locator).getText();
    }

    public static void sendKeysToElement(By locator, String keys) {
        waitElementToBeVisible(locator).sendKeys(keys);
    }

    public static void sendKeysToHiddenElement(By locator, String keys) {
        driver.findElement(locator).sendKeys(keys);
    }

    public static String getElementAttributeValue(By locator, String attribute) {
        return waitElementToBeClickable(locator).getAttribute(attribute);
    }

    public static void callContextMenu(By locator) {
        Actions action = new Actions(driver);
        action.contextClick(waitElementToBeClickable(locator)).perform();
    }

    public static void doubleClickElement(By locator) {
        Actions action = new Actions(driver);
        action.doubleClick(waitElementToBeClickable(locator)).perform();
    }

    public static void dragAndDrop(By source, By target) {
        Actions actions = new Actions(driver);
        actions.dragAndDrop(waitElementToBeClickable(source), waitElementToBeClickable(target)).perform();
    }

    private static WebElement waitElementToBeClickable(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    private static WebElement waitElementToBeVisible(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static boolean isVisible(By locator) {
        return driver.findElement(locator).isDisplayed();
    }

    public void highlightElement(By locator) {
        // implement
    }

    public void shareLink(By locator) {
        // implement
    }

    public void screenshot() {
        // implement
    }
}
