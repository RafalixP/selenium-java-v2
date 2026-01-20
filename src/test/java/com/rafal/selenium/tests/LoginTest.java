package com.rafal.selenium.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
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


    @Test
    public void testLogin() {
        //case 1 - scenariusz pozytywny
        //wchodzimy na podstronę Login
        driver.findElement(By.linkText("Form Authentication")).click();

        //tworzymy nowy obiekt - instancję klasy CheckboxesPage
        LoginPage page = new LoginPage(driver);

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

    //@Test
    //case 2 - scenariusz pozytywny
}
