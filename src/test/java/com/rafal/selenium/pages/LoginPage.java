package com.rafal.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import io.qameta.allure.Step;

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
        // return element.isDisplayed();
        return true; // prościej
    }

    // metoda sprawdzająca powodzenie logowania
    public boolean isLoginSuccessful() {
        wait.until(ExpectedConditions.urlContains("secure"));
        return driver.getCurrentUrl().contains("secure");
    }
    
    @Step("Enter username: {username}")
    public void enterUsername(String username) {
        driver.findElement(usernameField).sendKeys(username);
    }

    @Step("Enter password")
    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    @Step("Click the login button")
    public void clickLogin() {
        driver.findElement(loginButton).click();
    }

    //metoda dla użycia DataProvidera
    public void login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLogin();
    }
}