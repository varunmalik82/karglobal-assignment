package com.karglobal.web.core.utils;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Properties;

public class ConfigUtils {

    private final static String PROPERTY_FILE_LOCATION = System.getProperty("user.dir") + "/src/test/resources/Config" +
            ".properties";
    private static Properties properties;

    public static synchronized String getProperty(String propertyKey) {
        try {
            if (properties == null)
                properties = new Properties();
            FileReader reader = new FileReader(PROPERTY_FILE_LOCATION);
            properties.load(reader);
            return properties.getProperty(propertyKey);
        } catch (Exception e) {
            System.err.println("Exception occurred while reading property from Config.properties" + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }
}
