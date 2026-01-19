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


public class loginSimpleTest {
    //deklaracja zmiennych
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeMethod
    public void SetUP() {
        // ustawienia przeglądarki (opcjonalne) i tworzenie drivera
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    //scenariusz pozytywny
    public void testLogin() throws InterruptedException {
        //otwieramy stronę
        driver.get("https://the-internet.herokuapp.com/login");

        //znajdujemy interesujące nas pola i wpisujemy login oraz hasło
        driver.findElement(By.id("username")).sendKeys("tomsmith");
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");

        //klikamy przycisk login
        driver.findElement(By.cssSelector("button[type='submit']")).click();
        
        //poczekajmy chwilę - prosty wait
        Thread.sleep(3000);

        //czy logowanie się udało?
        String currentUrl = driver.getCurrentUrl();
        System.out.println("Current URL is: " + currentUrl);
        Assert.assertTrue(currentUrl.contains("secure"));
    }

    //scenariusz negatywny - nieprawidłowe hasło
    @Test
    public void invalidPasswrdLogin() throws InterruptedException {
        //otwieramy stronę
        driver.get("https://the-internet.herokuapp.com/login");

        //znajdujemy interesujące nas pola i wpisujemy login oraz hasło NIEPRAWIDŁOWE
        driver.findElement(By.id("username")).sendKeys("tomsmith");
        driver.findElement(By.id("password")).sendKeys("wrongPassword!");
        
        //klikamy przycisk login
        driver.findElement(By.cssSelector("button[type='submit']")).click();

        //czy logowanie się NIEudało?

        //1. czy URL nadal zawiera słowo 'login'
        wait.until(ExpectedConditions.urlContains("login"));

        //2. Czy pojawił się komunikat o błędnym haśle?
        Assert.assertTrue(driver.findElement(By.id("flash")).isDisplayed());


    }
    

    @AfterMethod
    public void tearDown() {
        // Kod wykonywany po każdym teście
        driver.quit();
    }
      
}
