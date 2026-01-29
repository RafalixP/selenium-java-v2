package com.rafal.selenium.tests;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.Assert;

import com.rafal.selenium.pages.DropdownPage;
import com.rafal.selenium.pages.HomePage;

public class DropdownTest extends BaseTest {

    //zmienne
    private DropdownPage dropdownPage;
    private HomePage homePage;


    @BeforeMethod
    public void setUpDropdown() {
        homePage = new HomePage(driver);        // startujemy na stronie głównej
        dropdownPage = homePage.goToDropdownPage(); // przechodzimy na DropdownPage korzystając metody z klasy HomePage
    }

    // case 1 - Po załadowaniu strony żadna opcja nie jest wybrana
    @Test
    public void defaultState_shouldShowPlaceholder() {
        Assert.assertEquals(dropdownPage.getSelectedOptionText(), "Please select an option", "Domyślnie dropdown powinien pokazywać placeholder 'Please select an option'"); // komunikat na wypadek gdyby nie było równości
    }
        
    // case 2 - Kliknięcie opcji 1 → opcja ma selected
    @Test
    public void selectOption1_shouldMarkItAsSelected() {
        
        dropdownPage.selectByVisibleText("Option 1");

        //Assert.assertTrue(driver.findElement(By.id("dropdown")).isDisplayed()); // to jest tu niepotrzebne, bo nas interesuje wybrana opcja, a nie czy box się wyświetlił
        Assert.assertEquals(dropdownPage.getSelectedOptionText(), "Option 1"); 

    }

    // case 3 - Odświeżenie strony nie zmienia stanu (nic nie jest wybrane)

    // case 4 - Pole dropdowna nie jest edytowalne ręcznie

    

    // case 5 - Kliknięcie opcji 2 → opcja ma selected

    // case 6 - kolejność opcji: czy 1 jest faktycznie pierwsza

    // case 7 - wybieram 1, potem 2, sprawdzam czy opcja 1 przestaje być selected, a wybrana jest opcja 2

    // case 8 - walidacja danych - czy można wpisać tekst

}
