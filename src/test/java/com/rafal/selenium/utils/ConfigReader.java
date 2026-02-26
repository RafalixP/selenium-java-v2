package com.rafal.selenium.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private static Properties properties = new Properties();

    static {
        try {
            FileInputStream file = new FileInputStream("src/resources/config.properties"); // nowy obiekt - plik z zewnątrz
            properties.load(file);   // do obiektu properties ładujemy to co było w otwartym pliku
            file.close();      // zamykamy plik
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Ups, nie udało się wczytać pliku konfiguracyjnego");
        }
    }

    // metody

    // metoda pobierająca wartości z pliku konfiguracyjnego
    public static String getProperty(String key) {
        return properties.getProperty(key);
    }

    // metoda zamieniająca Stringa na Integer
    public static int getInt(String key) {
        return Integer.parseInt(properties.getProperty(key));
    }

    // metoda zamieniająca Stringa na Boolean
    public static Boolean getBoolean(String key) {
        return Boolean.parseBoolean(properties.getProperty(key));
    } 

}
