package com.rafal.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {
	//lokatory
	private By usernameField = By.id("username");
    private By passwordField = By.id("password");
    private By loginButton = By.cssSelector("button[type='submit']");
    private By flashMessage = By.id("flash");

	//konstruktor
	public LoginPage(WebDriver driver) {
		super(driver);
	}
	//metody

    //metoda sprawdzająca komunikat informujący o NIEpowodzeniu logowania
    public boolean isFlashMessageVisible() {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(flashMessage));
        return element.isDisplayed();
    }

    // metoda sprawdzająca powodzenie logowania
    public boolean isLoginSuccessful() {
        wait.until(ExpectedConditions.urlContains("secure"));
        return driver.getCurrentUrl().contains("secure");
    }
    
    
    public void enterUsername(String username) {
        driver.findElement(usernameField).sendKeys(username);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickLogin() {
        driver.findElement(loginButton).click();
    }
}