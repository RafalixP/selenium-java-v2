package com.rafal.selenium.tests;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.openqa.selenium.By;
import com.rafal.selenium.pages.CheckboxesPage;

public class CheckboxesTest extends BaseTest {
    @Test
    public void isBoxChecked() {
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

    @Test
    //case 2 - sprawdzenie czy jak zaznaczę boxa #1 i potem ODzaznaczę #2 to czy #1 nadal jest zaznaczony

    // sprawdzamy czy box #1 NIE jest zaznaczony
    Assert.assertFalse(page.isCheckboxSelected(0));

    //klikam #1 boxa z listy
    page.clickCheckbox(0);

    // sprawdzamy czy box #1 jest zaznaczony
    Assert.assertTrue(page.isCheckboxSelected(0));

    //sprawdzamy czy box #2 jest zaznaczony (domyślnie)
    Assert.assertTrue(page.isCheckboxSelected(1));

    //klikam drugiego boxa z listy
    page.clickCheckbox(1);

    //sprawdzam czy box #2 NIE jest już zaznaczony
    Assert.assertFalse(page.isCheckboxSelected(1));

    //sprawdzam czy box #1 nadal JEST zaznaczony
    Assert.assertTrue(page.isCheckboxSelected(0));
    
}
