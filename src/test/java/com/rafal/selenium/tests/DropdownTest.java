package com.rafal.selenium.tests;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.rafal.selenium.pages.DropdownPage;

public class DropdownTest extends BaseTest {

    //zmienne
    private DropdownPage page;


    @BeforeMethod
    public void setUpDropdown() {
        page = new DropdownPage(driver); //tworzymy nowy obiekt strony
        driver.findElement(By.linkText("Dropdown")).click(); //znajdujemy link do podstrony i klikamy go
    }

    @Test
    public void selectDropdown() {
        page.selectByVisibleText("Option 1");
    }
}
