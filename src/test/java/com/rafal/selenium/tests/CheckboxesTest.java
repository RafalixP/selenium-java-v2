package com.rafal.selenium.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.openqa.selenium.By;
import com.rafal.selenium.pages.CheckboxesPage;
import com.rafal.selenium.pages.HomePage;

public class CheckboxesTest extends BaseTest {
    
    //zmienne
    private CheckboxesPage checkboxesPage;
    private HomePage homePage;

    @BeforeMethod
    public void setUpCheckbox() {
        homePage = new HomePage(driver);        //startujemy na stronie głównej
        checkboxesPage = homePage.goToCheckboxesPage(); // przechodzimy na CheckboxPage korzystając metody z klasy HomePage

    }

    //case 1
    @Test
    public void isBoxChecked() {
        
        // sprawdzamy czy box #1 NIE jest zaznaczony
        Assert.assertFalse(checkboxesPage.isCheckboxSelected(0));

        //klikamy boxa #1 z tej listy
        checkboxesPage.clickCheckbox(0);

        //sprawdamy czy box #1 jest zaznaczony (czyli że zmienił się jego stan po naszym kliknięciu)
        Assert.assertTrue(checkboxesPage.isCheckboxSelected(0));
    }

    //case 2 - sprawdzenie czy jak zaznaczę boxa #1 i potem ODzaznaczę #2 to czy #1 nadal jest zaznaczony
    @Test
    public void clickingBetweenBoxes() {

        // sprawdzamy czy box #1 NIE jest zaznaczony
        Assert.assertFalse(checkboxesPage.isCheckboxSelected(0));

        //klikam #1 boxa z listy
        checkboxesPage.clickCheckbox(0);

        // sprawdzamy czy box #1 jest zaznaczony
        Assert.assertTrue(checkboxesPage.isCheckboxSelected(0));

        //sprawdzamy czy box #2 jest zaznaczony (domyślnie)
        Assert.assertTrue(checkboxesPage.isCheckboxSelected(1));

        //klikam drugiego boxa z listy
        checkboxesPage.clickCheckbox(1);

        //sprawdzam czy box #2 NIE jest już zaznaczony
        Assert.assertFalse(checkboxesPage.isCheckboxSelected(1));

        //sprawdzam czy box #1 nadal JEST zaznaczony
        Assert.assertTrue(checkboxesPage.isCheckboxSelected(0));
    }
    
}
