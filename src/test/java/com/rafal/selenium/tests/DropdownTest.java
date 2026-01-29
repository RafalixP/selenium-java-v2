package com.rafal.selenium.tests;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.Assert;

import com.rafal.selenium.pages.DropdownPage;

public class DropdownTest extends BaseTest {

    //zmienne
    private DropdownPage page;


    @BeforeMethod
    public void setUpDropdown() {
        page = new DropdownPage(driver); //tworzymy nowy obiekt strony
        driver.findElement(By.linkText("Dropdown")).click(); //znajdujemy link do podstrony i klikamy go
    }

    // case 1 - Po załadowaniu strony żadna opcja nie jest wybrana
    @Test
    public void defaultState_shouldShowPlaceholder() {
        Assert.assertEquals(page.getSelectedOptionText(), "Please select an option", "Domyślnie dropdown powinien pokazywać placeholder 'Please select an option'"); // komunikat na wypadek gdyby nie było równości
    }
        
    // case 2 - Kliknięcie opcji 1 → opcja ma selected
    @Test
    public void selectDropdown() {
        
        page.selectByVisibleText("Option 1");

        //Assert.assertTrue(driver.findElement(By.id("dropdown")).isDisplayed()); // to jest tu niepotrzebne, bo nas interesuje wybrana opcja, a nie czy box się wyświetlił
        Assert.assertEquals(page.getSelectedOptionText(), "Option 1"); 

    }

    // case - Odświeżenie strony nie zmienia stanu (nic nie jest wybrane)

    // case - Pole dropdowna nie jest edytowalne ręcznie

    

    // case - Kliknięcie opcji 2 → opcja ma selected

    // case - kolejność opcji: czy 1 jest faktycznie pierwsza

    // case - wybieram 1, potem 2, sprawdzam czy opcja 1 przestaje być selected, a wybrana jest opcja 2

    // case - walidacja danych - czy można wpisać tekst

}
