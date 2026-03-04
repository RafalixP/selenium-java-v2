package com.rafal.selenium.listeners;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestListener;
import org.testng.ITestResult;

import io.qameta.allure.Allure;

import java.io.File;
import java.io.IOException;
import java.io.ByteArrayInputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ScreenshotListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        captureScreenshot(result, "FAILED");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        captureScreenshot(result, "SKIPPED");
    }

    private void captureScreenshot(ITestResult result, String status) {
        Object testClass = result.getInstance();
        try {
            // pobranie drivera przez metodę getDriver() z testu
            WebDriver driver = (WebDriver) testClass.getClass()
                    .getMethod("getDriver")
                    .invoke(testClass);

            takeScreenshot(driver, result.getName(), status);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void takeScreenshot(WebDriver driver, String testName, String status) {
    try {
        // 1️⃣ Tworzymy katalog jeśli nie istnieje
        File screenshotsDir = new File("screenshots");
        if (!screenshotsDir.exists()) {
            screenshotsDir.mkdir();
        }

        // 2️⃣ Tworzymy nazwę pliku
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
        File destination = new File(screenshotsDir, testName + "_" + status + "_" + timestamp + ".png");

        // 3️⃣ Robimy screenshot i zapisujemy fizycznie na dysku
        TakesScreenshot ts = (TakesScreenshot) driver;
        FileHandler.copy(ts.getScreenshotAs(OutputType.FILE), destination);

        // 4️⃣ Dodajemy ten sam screenshot do Allure jako attachment
        byte[] content = java.nio.file.Files.readAllBytes(destination.toPath());
        Allure.addAttachment(testName + " [" + status + "]", new ByteArrayInputStream(content));

        System.out.println("Screenshot saved & added to Allure: " + destination.getAbsolutePath());

    } catch (Exception e) {
        e.printStackTrace();
    }
}
}