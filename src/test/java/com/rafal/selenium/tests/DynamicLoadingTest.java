package com.rafal.selenium.tests;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.Assert;

import com.rafal.selenium.pages.HomePage;
import com.rafal.selenium.pages.DynamicLoadingPage;

public class DynamicLoadingTest extends BaseTest{
    // zmienne
    private HomePage homePage;
    private DynamicLoadingPage dynamicLoadingPage;

    @BeforeMethod
    public void SetUpDynamicLoading() {
        homePage = new HomePage(driver);    // startujemy na stronie głównej
        dynamicLoadingPage = homePage.goToDynamicLoadingPage(); // przechodzimy na podstronę dynamic loading
    }

    // case 1 - example 1 - element on the page is hidden
    @Test
    public void example1_test() {
        dynamicLoadingPage.clickExample_1();
        dynamicLoadingPage.clickStartButton();
        //dynamicLoadingPage.waitForLoaderToDisappear(); // niepotrzebne
        Assert.assertTrue(dynamicLoadingPage.isHelloWorldVisible());
        
    }

    // case 2 - example 2 - element on the page does not exists until the loader dissapear
    @Test
    public void example2_test() {
        dynamicLoadingPage.clickExample_2();
        Assert.assertFalse(dynamicLoadingPage.isHelloWorldInitiallyVisible());
        dynamicLoadingPage.clickStartButton();
        Assert.assertTrue(dynamicLoadingPage.isHelloWorldVisible());
        
        //dynamicLoadingPage.isHelloWorldVisible();
        //Assert.assertTrue(dynamicLoadingPage.waitForLoaderToDisappear());
    }


    
}
