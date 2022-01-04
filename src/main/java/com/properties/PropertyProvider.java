package com.properties;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyProvider {

    private final static String FILE_PATH = "/application.properties";

    private static Properties properties;

    private PropertyProvider() {
        //singleton
    }

    public static synchronized String getProperty(String propertyName) {
        if (properties == null) {
            loadProperty();
        }
        String value = properties.getProperty(propertyName);
        if (value != null) {
            return value;
        } else {
            throw new IllegalArgumentException(String.format("Property %s is not found in file %s", propertyName, "/application.properties"));
        }
    }

    private static synchronized void loadProperty() {
        properties = new Properties();
        try {
            properties.load(PropertyProvider.class.getResourceAsStream(FILE_PATH));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Тут нет смысла синхронизировать метод, т. к. он синхронизирован в
     *
     * @see java.util.Properties#store0(java.io.BufferedWriter, java.lang.String, boolean)
     */
    public static void setProperty(String propName, String propValue) {
        if (properties == null) {
            loadProperty();
        }
        properties.setProperty(propName, propValue);
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("src/main/resources/application.properties");
            properties.store(fileOutputStream, null);
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}