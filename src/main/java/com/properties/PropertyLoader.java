package com.properties;

import java.io.IOException;
import java.util.Properties;

public class PropertyLoader {

    private final static String FILE_PATH = "/application.properties";

    private static Properties properties;

    private PropertyLoader() {
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

    private static void loadProperty() {
        properties = new Properties();
        try {
            properties.load(PropertyLoader.class.getResourceAsStream(FILE_PATH));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}