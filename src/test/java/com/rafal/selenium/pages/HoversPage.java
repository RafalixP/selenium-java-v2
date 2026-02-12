package com.rafal.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.WebElement;

public class HoversPage extends BasePage{
    // zmienne
    private By figures = By.cssSelector(".figure");     // to będzie obrazek ze strony
    private By caption = By.cssSelector(".figcaption h5");  // to będą elementy które pojawią się po hoverze

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
    public String getCaptionText() {
        return driver.findElement(caption).getText();
    } 
    

}
