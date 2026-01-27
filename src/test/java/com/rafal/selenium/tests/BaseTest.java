package com.rafal.selenium.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait; // do obsługi waita
import java.time.Duration;  // do obsługi waita
import org.testng.annotations.BeforeMethod; // do @BeforeMethod

import com.rafal.selenium.pages.LoginPage;

import org.testng.annotations.AfterMethod;  // do @AfterMethod
import org.openqa.selenium.By;              // do znajdowania elementów

public class BaseTest {
    protected WebDriver driver;
    protected WebDriverWait wait;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://the-internet.herokuapp.com");
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(5000); // 5 sekund żeby zobaczyć rezultat
        driver.quit();
    }
}
