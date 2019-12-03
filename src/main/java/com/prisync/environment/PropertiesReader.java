package com.prisync.environment;

import java.io.*;

import java.util.Properties;

public class PropertiesReader {

    private Properties properties = new Properties();

    public PropertiesReader() {
        try (InputStream inputStream = getClass().getResourceAsStream("/rabbitmq.properties")) {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Properties getProperty() {
        return properties;
    }
}