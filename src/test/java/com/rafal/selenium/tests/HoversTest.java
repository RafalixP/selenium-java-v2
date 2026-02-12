package com.rafal.selenium.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Int;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.Assert;

import com.rafal.selenium.pages.HomePage;
import com.rafal.selenium.pages.HoversPage;


public class HoversTest extends BaseTest{
    //zmienne
    private HomePage homePage;
    private HoversPage hoversPage; 

    
    @BeforeMethod
    public void SetUpHovers() {
        homePage = new HomePage(driver);    // startujemy na stronie głównej
        hoversPage = homePage.goToHoversPage();    // przechodzimy na podstronę Hover
    }

    // case 1 - po załadaowaniu pod strony Hovers widoczne są trzy obrazki
    

    // case 2 - hover na obrazek powoduje pojawienie się tekstu (czyli bez hovera tekstu nie ma)
    @Test
    public void hoveringMakesTextVisible() {
        Assert.assertFalse(driver.findElement(caption).isDisplayed());

        hoversPage.hoverOverFigure(1);

        Assert.assertEquals(hoversPage.getCaptionText(), "name: user1", "coś tu jest nie tak, tekst powinien brzmieć: name: user1");

    }

    // case 3 - tekst który się pojawia jest poprawny

    // case 4 - link który się pojawia jest poprawny (i może działa jeszcze)
}
