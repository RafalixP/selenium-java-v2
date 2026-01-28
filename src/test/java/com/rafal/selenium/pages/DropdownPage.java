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

}
