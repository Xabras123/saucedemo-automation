package com.saucedemo.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigManager {

    private static final Properties properties = new Properties();

    static {
        String env = System.getProperty("env", "default");
        String configFile = String.format("src/test/resources/config/config-%s.properties", env);

        try (FileInputStream input = new FileInputStream(configFile)) {
            properties.load(input);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load config file: " + configFile, e);
        }
    }

    public static String get(String key) {
        return properties.getProperty(key);
    }
}
