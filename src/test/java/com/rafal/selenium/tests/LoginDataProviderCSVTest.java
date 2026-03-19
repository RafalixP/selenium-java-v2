package com.rafal.selenium.tests;

//import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import com.rafal.selenium.pages.LoginPage;
import com.rafal.selenium.pages.HomePage;

//nowe importy do obsługi plików
import java.util.List;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;



public class LoginDataProviderCSVTest extends BaseTest {

    private LoginPage loginPage;
    private HomePage homePage;

    @BeforeMethod
    public void setUpLogin() {
        homePage= new HomePage(driver);     // startujemy na stronie głównej
        loginPage = homePage.goToLoginPage();   // przechodzimy na DropdownPage korzystając metody z klasy HomePage
    }
    

    //case 5 - używam DataProvidera do ogarnięcia kilku scenariuszy logowania
    @Test(dataProvider = "loginData")
    public void testLoginWithVariousData(String caseName, String username, String password, boolean shouldLogin) {
        System.out.println("Running scenario: "+ caseName);

        loginPage.login(username, password);

        if (shouldLogin) {
            Assert.assertTrue(loginPage.isLoginSuccessful());
        } else {
            Assert.assertTrue(loginPage.isFlashMessageVisible());
        }
    }
    
    // DataProvider który czyta CSV

        @DataProvider(name="loginData")
        public Object[][] loginData() throws IOException {
            
            List<Object> data = new ArrayList<>();  // lista elementów składająca się z tablicy obiektów

            BufferedReader reader = new BufferedReader(
                new FileReader("src/test/resources/loginData.csv")  // otiweramy plik i czytamy go linijka po linijce
            );

            String line;    // deklaracja zmiennej którą będziemy używać do zapisywania poszczególnych linijek danych (patzr poniżej)

            while ((line = reader.readLine()) != null ) {   // readLine() odczytuje nam jedną linijkę i zapisujemy ją jako 'line', dopóki linijki z danymi nam się nie skończą (pętla się kończy gdy readLine zwróci nulla)

                String[] values = line.split(",");

                String caseName = values[0];
                String username = values[1];
                String password = values[2];
                boolean shouldLogin = Boolean.parseBoolean(values[3]);

                data.add(new Object[]{caseName, username, password, shouldLogin});  // dodajemy do listy nową tablicę reprezentującą jedną linijkę danych, czyli jeden scenariusz w tym przypadku
            }

            reader.close(); // tu już dziękujemy naszemu plikowi z danymi

            return data.toArray(new Object[0][]);   //TestNG DataProvider wymaga tablicy, czyli zamieniamy listę na tablicę tablic
        }

}
