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
    private String beforeText;
    private String afterText;


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


    // case 3.1 - Odświeżenie strony nie zmienia stanu (nic nie jest wybrane)
    @Test
    public void reloadShouldKeepThePlaceholder() {
        //sprawdzamy czy po otwarciu strony widoczny jest placeholder
        Assert.assertEquals(dropdownPage.getSelectedOptionText(), "Please select an option", "Domyślnie dropdown powinien pokazywać placeholder 'Please select an option'");
        //reload strony
        dropdownPage.reloadPage();
        //ponownie sprawdzamy czy jest widoczny placeholder
        Assert.assertEquals(dropdownPage.getSelectedOptionText(), "Please select an option", "Domyślnie dropdown powinien pokazywać placeholder 'Please select an option'");
    }

    // case 3.2 - po wybraniu opcji 1 z dropdowna i wykonaniu reload resetuje się również stan dropdowna
    @Test
    public void reloadShouldResetTheDropdownPlaceholder() {
        //sprawdzamy czy dropdown ma value = ""
        Assert.assertEquals(dropdownPage.getSelectedOptionValue(), "", "Coś tu nie gra, value powinno być pustym stringiem");
        
        System.out.println("Wartość value przed kliknięciem to: " + dropdownPage.getSelectedOptionValue());

        // klikamy opcję 1
        dropdownPage.selectByVisibleText("Option 1");
        System.out.println("Wartość value po kliknięciu to: " + dropdownPage.getSelectedOptionValue());

        // sprawdzamy czy dropdown ma value = "1"
        Assert.assertEquals(dropdownPage.getSelectedOptionValue(), "1", "Coś tu nie gra, po wybraniu 1 value powinna wynosić 1");

        // robimy reload
        dropdownPage.reloadPage();

        //sprawdzamy czy dropdown ma value = ""
        Assert.assertEquals(dropdownPage.getSelectedOptionValue(), "", "Coś tu nie gra, po reloadzie value powinno być pustym stringiem");
    }


    
    // case 4 - Pole dropdowna nie jest edytowalne ręcznie
    @Test
    public void notPossibleToEditManually() {
        beforeText = dropdownPage.getSelectedOptionText();  //bierzemy tekst placeholdera i przypisujemy go do zmiennej
        
        // porównujemy wartość tej zmennej z oczekiwanym Stringiem
        Assert.assertEquals(beforeText, "Please select an option", "Domyślnie dropdown powinien pokazywać placeholder 'Please select an option'"); 

        dropdownPage.tryToTypeIntoDropdown("abc");   // próbujemy wpisać tekst w pole

        afterText = dropdownPage.getSelectedOptionText();  //bierzemy tekst placeholdera i przypisujemy go do zmiennej

        Assert.assertEquals(beforeText, afterText, "Uwaga, coś się zmieniło");
    }
    

    // case 5.1 - Kliknięcie opcji 2 → czy opcja 2 jest wybrana 
    @Test
    public void clickOption2_shouldSelectOption2() {
        //bierzemy tekst placeholdera i przypisujemy go do zmiennej
        beforeText = dropdownPage.getSelectedOptionText();
        System.out.println("Tekst domyślny: " + beforeText);
        
        // porównujemy wartość tej zmiennej z oczekiwanym placeholderem
        Assert.assertEquals(beforeText, "Please select an option", "Domyślnie dropdown powinien pokazywać placeholder 'Please select an option'");

        //wybieramy opcję 2 z dropdowna
        dropdownPage.selectByVisibleText("Option 2");

        //pobieramy tekst PO kliknięciu
        afterText = dropdownPage.getSelectedOptionText();
        System.out.println("Tekst po kliknięciu: " + afterText);

        //sprawdzamy status dropdowna - oczekiwana wartość: Option 2
        Assert.assertEquals(afterText, "Option 2", "Ups, coś nie zadziałało");
    }


    
    // case 5.2 - Kliknięcie opcji 2 → zmiana value na "2"
    @Test
    public void clickOption2_Option2ShouldHaveSelectedAttr() {
        // sprawdzamy czy dropdown ma value = ""
        Assert.assertEquals(dropdownPage.getSelectedOptionValue(), "", "Nieprawidłowa wartość domyślna dropdowna");

        System.out.println("Domyślna wartość value to: " + dropdownPage.getSelectedOptionValue());
        //wybieramy opcję 2
        dropdownPage.selectByVisibleText("Option 2");

        System.out.println("Wartość value po kliknięciu Option 2 to: " + dropdownPage.getSelectedOptionValue());

        // sprawdzamy czy opcja 2 ma value = "2"
        Assert.assertEquals(dropdownPage.getSelectedOptionValue(), "2", "Nieprawidłowa wartość dropdowna dla Opcji 2");
    }

    // case 6 - kolejność opcji: czy 1 jest faktycznie pierwsza

    // case 7 - wybieram 1, potem 2, sprawdzam czy opcja 1 przestaje być selected, a wybrana jest opcja 2

}
