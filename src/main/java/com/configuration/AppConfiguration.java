package com.configuration;

import org.apache.commons.configuration2.Configuration;
import org.apache.commons.configuration2.EnvironmentConfiguration;

public class AppConfiguration {

    public static AppConfiguration instance;
    private final Configuration configuration;

    public AppConfiguration() {
        this.configuration = new EnvironmentConfiguration();
    }

    private static AppConfiguration getInstance() {
        if (instance == null) {
            instance = new AppConfiguration();
        }
        return instance;
    }

    public static String getString(String key) {
        return getInstance().configuration.getString(key);
    }
}