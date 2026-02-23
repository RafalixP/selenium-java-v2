package com.rafal.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {
    //zmienne
    private By dropdownLink = By.linkText("Dropdown");
    private By loginLink =  By.linkText("Form Authentication");
    private By checkboxesLink = By.linkText("Checkboxes");
    private By hoversLink = By.linkText("Hovers");
    private By dynamicLoadingLink = By.linkText("Dynamic Loading");

    private final Duration WAIT_TIME = Duration.ofSeconds(5);   // stała

    //konstruktor
    public HomePage(WebDriver driver) {
        super(driver);
    }

    // metody

    // kliknij dopiero kiedy element da się kliknąć
    private void clickWhenReady(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, WAIT_TIME);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        element.click();
    } 

    public DropdownPage goToDropdownPage() {
        driver.clickWhenReady(dropdownLink);
        return new DropdownPage(driver);
    }

    public LoginPage goToLoginPage() {
        driver.clickWhenReady(loginLink);
        return new LoginPage(driver);
    }

    public CheckboxesPage goToCheckboxesPage() {
        driver.clickWhenReady(checkboxesLink);
        return new CheckboxesPage(driver);
    }

    public HoversPage goToHoversPage() {
        driver.clickWhenReady(hoversLink);
        return new HoversPage(driver);
    }

    public DynamicLoadingPage goToDynamicLoadingPage() {
        driver.clickWhenReady(dynamicLoadingLink);
        return new DynamicLoadingPage(driver);
    }
    
}
