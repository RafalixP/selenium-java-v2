package com.rafal.selenium.tests;

//import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.rafal.selenium.pages.LoginPage;
import com.rafal.selenium.pages.HomePage;

import org.openqa.selenium.By;
//import java.time.Duration;


public class LoginTest extends BaseTest {

    //zmienne trzymające dane logowania - hardcoded
    private String username = "tomsmith";
    private String password = "SuperSecretPassword!";
    private String invalidPassword = "XXXXXXXX";

    private LoginPage loginPage;
    private HomePage homePage;

    @BeforeMethod
    public void setUpLogin() {
        homePage= new HomePage(driver);     // startujemy na stronie głównej
        loginPage = homePage.goToLoginPage();   // przechodzimy na DropdownPage korzystając metody z klasy HomePage

    }

    //case 1 - scenariusz pozytywny
    @Test(enabled = true)
    public void testLogin() {
        
        //znajdujemy interesujące nas pola i wpisujemy login oraz hasło
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickLogin();

        Assert.assertTrue(loginPage.isLoginSuccessful());

    }

    //case 2 - scenariusz negatywny, nieprawidłowe hasło
    @Test(enabled = true)
    public void testLoginInvalidPassword() {
        //znajdujemy interesujące nas pola i wpisujemy login oraz hasło
        loginPage.enterUsername(username);
        loginPage.enterPassword(invalidPassword);
        loginPage.clickLogin();
        
        //czy logowanie się udało?
        Assert.assertTrue(loginPage.isFlashMessageVisible());
    }
    
    //case 3 - scenariusz negatywny, nieprawidłowy Username
    @Test(enabled = true)
    public void testLoginInvalidUsername() {
        //znajdujemy interesujące nas pola i wpisujemy login oraz hasło
        loginPage.enterUsername("invalidUser");
        loginPage.enterPassword(password);
        loginPage.clickLogin();

        //czy logowanie się udało?
        //Assert.assertTrue(driver.findElement(By.id("flash")).isDisplayed());
        Assert.assertTrue(loginPage.isFlashMessageVisible());

        //a wyświetl no adres strony
        String currentUrl = driver.getCurrentUrl();
        System.out.println("scenariusz negatywny, nieprawidłowy Username");
        System.out.println("Current URL is: " + currentUrl);
    }

    //case 4 - scenariusz negatywny, puste pola
    @Test(enabled = true)
    public void emptyFieldsLogin() {
        loginPage.clickLogin();
        Assert.assertTrue(driver.findElement(By.id("flash")).isDisplayed());
        System.out.println("scenariusz negatywny, puste pola");
    }
}
