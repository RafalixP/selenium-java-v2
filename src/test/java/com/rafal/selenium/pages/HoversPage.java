package com.rafal.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebElement;
import java.time.Duration;

public class HoversPage extends BasePage{
    // zmienne
    private By figures = By.cssSelector(".figure");     // to będzie (pierwszy) obrazek ze strony
    private By caption = By.cssSelector(".figcaption h5");  // to będą elementy które pojawią się po hoverze
    private By webLink = By.cssSelector(".figcaption a"); // to będzie link który pojawi się po hoverze

    // konstruktor
    public HoversPage(WebDriver driver) {
        super(driver);
    }

    // metody

    // metoda sprawdzająca czy teskt jest widoczny - bierze indeks elementu i zwraca T/F
    public boolean isCaptionVisible(int index) {
        return driver.findElements(caption).get(index).isDisplayed();
    }

    // meotda do hoverowania - bierze indeks konkretnego elementu (0 do 2 w tym przypadku, dla userów od 1 do 3)
    public void hoverOverFigure(int index) {
        WebElement figure = driver.findElements(figures).get(index);     // tu wybieramy interesujący nas obrazek po indeksie

        Actions actions = new Actions(driver);
        actions.moveToElement(figure).perform();
    }

    // metoda zwracająca tekst który powinien pojawić się pod wybranym i zhoverowanym przez nas obrazkiem
    public String getCaptionText(int index) {
        return driver.findElements(caption).get(index).getText();
    } 

    // metoda zwracająca ilość obrazków na stronie
    public int getNumberOfFigures() {
        return driver.findElements(figures).size();
    }
    

    // metoda sprawdzająca czy link 'View profile' jest widoczny
    public boolean isViewProfileLinkVisible(int index) {
        return driver.findElements(webLink).get(index).isDisplayed();
    }

    // metoda klikająca link 'View profile'
    public void clickViewProfile(int index) {
        WebElement link = new WebDriverWait(driver, Duration.ofSeconds(5))
                        .until(ExpectedConditions.elementToBeClickable(driver.findElements(webLink).get(index)));
link.click();
    }

}
