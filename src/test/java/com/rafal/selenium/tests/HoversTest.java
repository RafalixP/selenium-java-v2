package com.rafal.selenium.tests;

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

    // case 1 - po załadaowaniu podstrony Hovers widoczne są trzy obrazki
    @Test
    public void threeImagesShouldBeVisible() {
        Assert.assertEquals(hoversPage.getNumberOfFigures(), 3, "coś tu jest nie tak, powinny być trzy obrazki");
    }

    

    // case 2 - hover na obrazek powoduje pojawienie się tekstu (czyli bez hovera tekstu nie ma)
    @Test
    public void hoveringMakesTextVisible() {
        Assert.assertFalse(hoversPage.isCaptionVisible(0));

        hoversPage.hoverOverFigure(0);

        Assert.assertTrue(hoversPage.isCaptionVisible(0));

    }

    // case 3 - tekst który się pojawia jest poprawny
    

    // case 4 - link który się pojawia jest poprawny (i może działa jeszcze)
}
