package com.rafal.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;

public class DynamicLoadingPage extends BasePage {
    // zmienne
    private By startButton = By.cssSelector("#start button"); //By.id("start");
    private By loaderStrip = By.id("loading");
    private By helloWorld = By.id("finish");
    private By example1link = By.linkText("Example 1: Element on page that is hidden");
    private By example2link = By.linkText("Example 2: Element rendered after the fact");

    //konstruktor
    public DynamicLoadingPage(WebDriver driver) {
        super(driver);
    }

    //metody

    //metoda klikająca link example 1
    public void clickExample_1() {
        clickWhenReady(example1link);
    }

    //metoda klikająca link example 2
    public void clickExample_2() {
        clickWhenReady(example2link);
    }

    // metoda klikająca przycisk start
    public void clickStartButton() {
        //driver.findElement(startButton).click();
        clickWhenReady(startButton);
    }

    // metoda sprawdzająca czy pasek loader zniknął 
    public void waitForLoaderToDisappear() {
        //new WebDriverWait(driver, WAIT_TIME).until(ExpectedConditions.invisibilityOfElementLocated(loaderStrip));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(loaderStrip));
    }

    // metoda sprawdzająca obecność tekstu "Hello World" 
    public boolean isHelloWorldVisible() {
        //return driver.findElement(helloWorld).isDisplayed();
        //new WebDriverWait(driver, WAIT_TIME).until(ExpectedConditions.visibilityOfElementLocated(helloWorld));
         return wait.until(ExpectedConditions.visibilityOfElementLocated(helloWorld)).isDisplayed();
    }

    // metoda sprawdzająca czy Hello world jest widoczne już na początku
    public boolean isHelloWorldInitiallyVisible() {
        return !driver.findElements(helloWorld).isEmpty() && driver.findElement(helloWorld).isDisplayed();
    }

}
