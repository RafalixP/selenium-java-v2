package com.rafal.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;

public class DynamicLoadingPage extends BasePage {
    // zmienne
    private By startButton = By.id("start");
    private By loader = By.id("loading");
    private By helloWorld = By.id("finish");

    //konstruktor
    public DynamicLoadingPage(WebDriver driver) {
        super(driver);
    }

    //metody

    // metoda klikająca przycisk start
    public void clickStartButton() {
        driver.findElement(startButton).click();
    }

    // metoda sprawdzająca obecność tekstu "Hello World" 
    public boolean isHelloWorldVisible() {
        return driver.findElement(helloWorld).isDisplayed();
    }

}
