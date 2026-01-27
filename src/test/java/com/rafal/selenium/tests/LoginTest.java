package com.rafal.selenium.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.rafal.selenium.pages.LoginPage;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;


public class LoginTest extends BaseTest {

    //zmienne trzymające dane logowania - hardcoded
    private String username = "tomsmith";
    private String password = "SuperSecretPassword!";
    private String invalidPassword = "XXXXXXXX";
    private LoginPage page;

    @BeforeMethod
    public void setUpLogin() {
        page = new LoginPage(driver); //tworzymy nowy obiekt - instancję klasy CheckboxesPage
        //wchodzimy na podstronę Login
        driver.findElement(By.linkText("Form Authentication")).click();
    }

    @Test
    public void testLogin() {
        //case 1 - scenariusz pozytywny
        
        //znajdujemy interesujące nas pola i wpisujemy login oraz hasło
        page.enterUsername(username);
        page.enterPassword(password);
        page.clickLogin();
        
        //poczekajmy chwilę na zmianę strony (wait odziedziczony z BaseTest)
        wait.until(ExpectedConditions.urlContains("secure"));

        //czy logowanie się udało?
        String currentUrl = driver.getCurrentUrl();
        System.out.println("Current URL is: " + currentUrl);
        Assert.assertTrue(currentUrl.contains("secure"));

    }

    @Test
    public void testLoginInvalidPassword() {
        //case 2 - scenariusz negatywny, nieprawidłowe hasło
        //znajdujemy interesujące nas pola i wpisujemy login oraz hasło
        page.enterUsername(username);
        page.enterPassword(invalidPassword);
        page.clickLogin();

        //poczekajmy chwilę na zmianę strony (wait odziedziczony z BaseTest)
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("flash")));

        //czy logowanie się udało?
        Assert.assertTrue(driver.findElement(By.id("flash")).isDisplayed());

        //a wyświetl no adres strony
        String currentUrl = driver.getCurrentUrl();
        System.out.println("Current URL is: " + currentUrl);


    }
    
    
}
