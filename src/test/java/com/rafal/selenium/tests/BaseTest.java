package com.rafal.selenium.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod; // do @BeforeMethod
import org.testng.annotations.AfterMethod;  // do @AfterMethod
import org.openqa.selenium.By;              // do znajdowania elementów

public class BaseTest {
    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
