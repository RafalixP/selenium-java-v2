package com.rafal.selenium.pages;
import com.rafal.selenium.utils.ConfigReader;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;

        //pobieramy czas oczekiwania z config i konwertujemy na Duration
        int waitSeconds = ConfigReader.getInt("waitTime");
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(waitSeconds));
    }

    // kliknij dopiero kiedy element da się kliknąć
    public void clickWhenReady(By locator) {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        element.click();
    } 
}
