package com.rafal.selenium.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private static Properties properties = new Properties();

    static {
        try {
            properties.load(ConfigReader.class.getClassLoader().getResourceAsStream("config.properties"));
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
