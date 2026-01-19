package com.rafal.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;              // do znajdowania elementów
import org.testng.annotations.Test;         // do @Test
import org.testng.annotations.BeforeMethod; // do @BeforeMethod
import org.testng.annotations.AfterMethod;  // do @AfterMethod
import org.testng.Assert;                   // do Assert.assertTrue()
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class checkboxesSimpleTest {
    //deklaracja zmiennych
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeMethod
    public void setUp() {
        driver =  new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
