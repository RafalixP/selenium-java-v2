package com.rafal.selenium.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.BeforeMethod; // do @BeforeMethod


import com.rafal.selenium.utils.ConfigReader;

import org.testng.annotations.AfterMethod;  // do @AfterMethod
import org.testng.annotations.Listeners;    //do obsługi screenów
import org.openqa.selenium.By;              // do znajdowania elementów
import com.rafal.selenium.listeners.ScreenshotListener;    //do obsługi screenów


@Listeners(ScreenshotListener.class)  //dodajemy listenera do obsługi screenów
public class BaseTest {
    protected WebDriver driver;
    protected String browser;

    @BeforeMethod
    public void setUp() {
        // driver = new ChromeDriver();

        browser  = ConfigReader.getProperty("browser");

        switch (browser.toLowerCase()) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;

            case "edge":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
            default:
                throw new RuntimeException("Nieznana przeglądarka: " + browser);

        }

        driver.get(ConfigReader.getProperty("baseUrl"));    // adres URL pobierany z pliku config.properties
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000); // 5 sekund żeby zobaczyć rezultat
        driver.quit();
    }

    // dodaję aby można było dostać się do drivera z klas testujących + screeny
    public WebDriver getDriver() {
        return driver;
    }
}
