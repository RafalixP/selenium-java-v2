package com.rafal.selenium.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DropdownPage extends BasePage {
    
    //lokator
    private By dropdownLocator = By.id("dropdown");

    //konstruktor
    public DropdownPage(WebDriver driver) {
        super(driver);
    }

    // wybór dropdowna po widocznym tekście
    public void selectByVisibleText(String text) {
        WebElement dropdownElement = driver.findElement(dropdownLocator); // wyszukujemy okno z dropdownem
        new Select(dropdownElement).selectByVisibleText(text);     // tworzymy obiekt 'Select' dla znalezionego dropdowna i wybieramy to co przyjdzie jako 'text'
    }

    //metoda zwracająca tekst z wybranej opcji
    public String getSelectedOptionText() {
        WebElement dropdownElement = driver.findElement(dropdownLocator); // tworzymy element dropdownElement i przypisujemy mu to co znajdziemy po dropdownLocator
        Select select = new Select(dropdownElement);                  //nowy obiekt select
        return select.getFirstSelectedOption().getText();            //na obiekcie select stosujemy metodę z klasy Select (getFirstSelectedOption) i następnie wyciągamy z tego tekst
    }

    //metoda zwracająca value z wybranej opcji
    public String getSelectedOptionValue() {
        WebElement dropdownElement = driver.findElement(dropdownLocator);
        Select select = new Select(dropdownElement);
        return select.getFirstSelectedOption().getAttribute("value");
    }

    // metoda do refreshu strony
    public void reloadPage() {
        driver.navigate().refresh();
    }

    //metoda do wpisywania tekstu w dropdowna
    public void tryToTypeIntoDropdown(String text) {
        driver.findElement(dropdownLocator).sendKeys(text);
    }

}
