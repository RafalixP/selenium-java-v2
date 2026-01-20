package com.rafal.selenium.tests;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.openqa.selenium.By;
import com.rafal.selenium.pages.CheckboxesPage;

public class CheckboxesTest extends BaseTest {
    @Test
    //case 1

    //wchodzimy na podstronę Checkboxes
    driver.findElement(By.linkText("Checkboxes")).click();

    //tworzymy nowy obiekt - instancję klasy CheckboxesPage
    CheckboxesPage page = new CheckboxesPage(driver);
    
    // sprawdzamy czy box #1 NIE jest zaznaczony
    Assert.assertFalse(page.isCheckboxSelected(0));

    //klikamy boxa #1 z tej listy
    page.clickCheckbox(0);

    //sprawdamy czy box #1 jest zaznaczony (czyli że zmienił się jego stan po naszym kliknięciu)
    Assert.assertTrue(page.isCheckboxSelected(0));
}
