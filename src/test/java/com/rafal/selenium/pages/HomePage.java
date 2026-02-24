package com.rafal.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {
    //zmienne
    private By dropdownLink = By.linkText("Dropdown");
    private By loginLink =  By.linkText("Form Authentication");
    private By checkboxesLink = By.linkText("Checkboxes");
    private By hoversLink = By.linkText("Hovers");
    private By dynamicLoadingLink = By.linkText("Dynamic Loading");

//    private final Duration WAIT_TIME = Duration.ofSeconds(5);   // stała, przeniosłem do BasePage

    //konstruktor
    public HomePage(WebDriver driver) {
        super(driver);
    }

    // metody

    public DropdownPage goToDropdownPage() {
        clickWhenReady(dropdownLink);
        return new DropdownPage(driver);
    }

    public LoginPage goToLoginPage() {
        clickWhenReady(loginLink);
        return new LoginPage(driver);
    }

    public CheckboxesPage goToCheckboxesPage() {
        clickWhenReady(checkboxesLink);
        return new CheckboxesPage(driver);
    }

    public HoversPage goToHoversPage() {
        clickWhenReady(hoversLink);
        return new HoversPage(driver);
    }

    public DynamicLoadingPage goToDynamicLoadingPage() {
        clickWhenReady(dynamicLoadingLink);
        return new DynamicLoadingPage(driver);
    }
    
}
