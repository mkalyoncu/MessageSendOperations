package com.prisync.environment;

import java.io.*;
import java.util.Properties;

public class PropertiesReader {

    private Properties properties = new Properties();

    public PropertiesReader() {
        try {
            //input = new FileInputStream("./src/main/resources/rabbitmq.properties");
            String file = "src/main/resources/rabbitmq.properties";
            Reader reader = new FileReader(file);
            properties.load(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Properties getProperty() {
        return properties;
    }
}