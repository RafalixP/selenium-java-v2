package com.rafal.selenium.listeners;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.io.FileHandler;
//import org.testng.ITestContext; 
import org.testng.ITestListener; 
import org.testng.ITestResult; 

import java.io.File; 
import java.io.IOException; 
import java.time.LocalDateTime; 
import java.time.format.DateTimeFormatter;


public class ScreenshotListener implements ITestListener {
    @Override   // nadpisujemy metodę z ITestListener

    //metoda wykonywana jeśli TestNG stwierdzi iż test się wysypał
    public void onTestFailure(ITestResult result) {
        System.out.println("Test FAILED: " + result.getName());
        
        Object testClass = result.getInstance();    //działamy na instancji testu (tego który się wysypał)

        try {
            //reflefction

            WebDriver driver = (WebDriver) testClass.getClass()  // bierze klasę testową
                .getMethod("getDriver")                    // szuka metody getDriver()
                .invoke(testClass);                             // wywołuje tą metodę na testClass
            takeScreenshot(driver, result.getName());           // wykonuje screena z aktualnego stanu przeglądarki, getName - nazwa testu
        } catch (Exception e) {                                 // obsługa błędu
            e.printStackTrace();
        }
    }

    //metoda wykonująca screeny
    private void takeScreenshot(WebDriver driver, String testName) {
        //tworzymy obiekt typu TakesScreenshot
        TakesScreenshot ts = (TakesScreenshot) driver;      //tu bieżemy metodę z TakesScreenshot

        //robimy screena i zapisujemy go do pliku tymczasowego
        File source = ts.getScreenshotAs(OutputType.FILE);

        //tworzymy nazwę pliku z datą i godziną wykonania screena
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
        String fileName = testName + "_" + timestamp + ".png";

        //określamy docelową ścieżkę zapisu screena
        File destination = new File("screenshots/" + fileName);

        try {
            //kopiujemy plik ze screena do docelowej lokalizacji
            FileHandler.createDir(new File("screenshots")); // tworzymy katalog jeśli nie istnieje
            FileHandler.copy(source, destination);
            System.out.println("Screenshot saved: " + destination.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }
  
    }
}
