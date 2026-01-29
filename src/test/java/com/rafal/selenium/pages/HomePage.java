package com.rafal.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {
    //zmienne
    private By dropdownLink = By.linkText("Dropdown");
    private By loginLink =  By.linkText("Form Authentication");
    private By checkboxesLink = By.linkText("Checkboxes");

    //konstruktor
    public HomePage(WebDriver driver) {
        super(driver);
    }

    public DropdownPage goToDropdownPage() {
        driver.findElement(dropdownLink).click();
        return new DropdownPage(driver);
    }

    public LoginPage goToLoginPage() {
        driver.findElement(loginLink).click();
        return new LoginPage(driver);
    }

    public CheckboxPage goToCheckboxPage() {
        driver.findElement(checkboxLink).click();
        return new CheckboxPage(driver);
    }
    
}
