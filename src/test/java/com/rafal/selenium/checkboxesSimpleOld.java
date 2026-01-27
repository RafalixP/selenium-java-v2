package com.rafal.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;              // do znajdowania elementów
import org.testng.annotations.Test;         // do @Test
import org.testng.annotations.BeforeMethod; // do @BeforeMethod
import org.testng.annotations.AfterMethod;  // do @AfterMethod
import org.testng.Assert;                   // do Assert.assertTrue()
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.WebElement;

public class checkboxesSimpleOld {
    //deklaracja zmiennych
    private WebDriver driver;
    private WebDriverWait wait;
    private List<WebElement> checkboxes;

    @BeforeMethod
    public void setUp() {
        driver =  new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        //otiweramy stronę główną
        driver.get("https://the-internet.herokuapp.com");

        //klikamy podstronę checkboxes
        driver.findElement(By.linkText("Checkboxes")).click();

        //wyszukujemy wszystkie boxy i tworzymy z nich listę
        checkboxes = driver.findElements(By.cssSelector("input[type='checkbox']"));
    }

    @Test(enabled = false)
    public void isBoxChecked() {
        //case 1
        

        // sprawdzamy czy box #1 NIE jest zaznaczony
        Assert.assertFalse(checkboxes.get(0).isSelected());

        //klikamy boxa #1 z tej listy
        checkboxes.get(0).click();

        //sprawdamy czy box #1 jest zaznaczony (czyli że zmienił się jego stan po naszym kliknięciu)
        Assert.assertTrue(checkboxes.get(0).isSelected());
    }

    @Test(enabled = false)
    public void clickingBetweenBoxes() {
        //case 2 - sprawdzenie czy jak zaznaczę boxa #1 i potem ODzaznaczę #2 to czy #1 nadal jest zaznaczony

        // sprawdzamy czy box #1 NIE jest zaznaczony
        Assert.assertFalse(checkboxes.get(0).isSelected());

        //klikam #1 boxa z listy
        checkboxes.get(0).click();

        // sprawdzamy czy box #1 jest zaznaczony
        Assert.assertTrue(checkboxes.get(0).isSelected());

        //sprawdzamy czy box #2 jest zaznaczony (domyślnie)
        Assert.assertTrue(checkboxes.get(1).isSelected());

        //klikam drugiego boxa z listy
        checkboxes.get(1).click();

        //sprawdzam czy box #2 NIE jest już zaznaczony
        Assert.assertFalse(checkboxes.get(1).isSelected());

        //sprawdzam czy box #1 nadal JEST zaznaczony
        Assert.assertTrue(checkboxes.get(0).isSelected());
    }

    @AfterMethod
    public void tearDown() {
        //driver.quit();
    }
}
