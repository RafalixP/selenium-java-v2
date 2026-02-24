package com.rafal.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected final Duration DEFAULT_TIME = Duration.ofSeconds(10);   // stała

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, DEFAULT_TIME);
    }

    // kliknij dopiero kiedy element da się kliknąć
    public void clickWhenReady(By locator) {
        //WebDriverWait wait = new WebDriverWait(driver, WAIT_TIME);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        element.click();
    } 
}
