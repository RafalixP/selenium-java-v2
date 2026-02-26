package com.rafal.selenium.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {
    private static Properties properties = new Properties();
    //private static InputStream;

    static {
        InputStream input = ConfigReader.class.getClassLoader().getResourceAsStream("config.properties");

        if (input == null) {
            throw new RuntimeException("Ups, nie mogę znaleźć pliku config");
            }

        try {
            properties.load(input);     // wczytujemy zawartośc pliku config do obiektu properties
            input.close();
        }
        catch (IOException e) {
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
