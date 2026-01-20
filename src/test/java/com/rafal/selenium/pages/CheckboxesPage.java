package com.rafal.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class CheckboxesPage extends BasePage {
    //lokatory
    //stała lokalizująca checkboxy
    private static final By CHECKBOXES_LOCATOR = By.cssSelector("input[type='checkbox']"); 

    //konstruktor
    public CheckboxesPage(WebDriver driver) {
        super(driver);  
    }
    //metody

    //stwórz listę checkboxów korzystając z podanego lokatora, następnie kliknj box o numerze podanym jako parametr metody
    public void clickCheckbox(int index) {
        List<WebElement> checkboxes = driver.findElements(CHECKBOXES_LOCATOR);
        checkboxes.get(index).click();
    }

    // stwórz listę checkboxów korzystając z podanego lokatora (duplikacja kodu!), następnie zwróć stan boxa (True/False)
    public boolean isCheckboxSelected(int index) {
        List<WebElement> checkboxes = driver.findElements(CHECKBOXES_LOCATOR);
        return checkboxes.get(index).isSelected();
    }

}
