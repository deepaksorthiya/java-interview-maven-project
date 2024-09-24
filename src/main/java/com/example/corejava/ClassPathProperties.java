package com.example.corejava;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Arrays;
import java.util.Properties;

public class ClassPathProperties {
    public static void main(String[] args) throws URISyntaxException, IOException {
        String fileName = "config/application.properties";
        InputStream is = ClassPathProperties.class.getClassLoader().getResourceAsStream(fileName);

        ClassLoader classLoader = ClassPathProperties.class.getClassLoader();
        URL resource = classLoader.getResource(fileName);
        if (resource == null) {
            throw new IllegalArgumentException("file not found! " + fileName);
        } else {

            // failed if files have whitespaces or special characters
            //return new File(resource.getFile());

            File file = new File(resource.toURI());
            System.out.println(Arrays.toString(file.listFiles()));
        }

        Properties properties = new Properties();
        properties.load(is);

        System.out.println(properties);
    }
}
