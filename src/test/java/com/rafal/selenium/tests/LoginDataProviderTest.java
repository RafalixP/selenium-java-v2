package com.rafal.selenium.tests;

//import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import com.rafal.selenium.pages.LoginPage;
import com.rafal.selenium.pages.HomePage;



public class LoginDataProviderTest extends BaseTest {

    private LoginPage loginPage;
    private HomePage homePage;

    @BeforeMethod
    public void setUpLogin() {
        homePage= new HomePage(driver);     // startujemy na stronie głównej
        loginPage = homePage.goToLoginPage();   // przechodzimy na DropdownPage korzystając metody z klasy HomePage
    }
    

    //case 5 - używam DataProvidera do ogarnięcia kilku scenariuszy logowania
    @Test(dataProvider = "loginData")
    public void testLoginWithVariousData(String caseName, String username, String password, boolean shouldLogin) {
        System.out.println("Running scenario: "+ caseName);

        loginPage.login(username, password);

        if (shouldLogin) {
            Assert.assertTrue(loginPage.isLoginSuccessful());
        } else {
            Assert.assertTrue(loginPage.isFlashMessageVisible());
        }
    }

        @DataProvider(name="loginData")
        public Object[][] loginData() {
            return new Object[][]{
                {"valid login", "tomsmith", "SuperSecretPassword!", true},
                {"invalid username", "invalidUser", "SuperSecretPassword!", false},
                {"invalid password", "tomsmith", "wrongPassword", false},
                {"empty fields", "", "", false}
            };
        }

}
