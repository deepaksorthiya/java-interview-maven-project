package com.example.corejava;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Properties;

public class JavaSwitchCase {

    public static void main(String[] args) {

        int x = 10;
        String s = "";

        switch (x) {
            case 10:
                s += 10;
            case 20:
                s += 20;
            case 50:
                s += 50;
            case 40:
                s += 40;
                break;
            default:
                s += "default";

        }

        System.out.println(s);
    }

    public static class ClassPathPropeties {
        public static void main(String[] args) throws URISyntaxException, IOException {
            String fileName = "config/application.properties";
            InputStream is = ClassPathPropeties.class.getClassLoader().getResourceAsStream(fileName);

            ClassLoader classLoader = ClassPathPropeties.class.getClassLoader();
            URL resource = classLoader.getResource(fileName);
            if (resource == null) {
                throw new IllegalArgumentException("file not found! " + fileName);
            } else {

                // failed if files have whitespaces or special characters
                //return new File(resource.getFile());

                File file = new File(resource.toURI());
            }

            Properties properties = new Properties();
            properties.load(is);

            System.out.println(properties);

            System.out.println(test());
        }


        public static int test() {
            int i = 1;
            try {
                int x = 1 / 0;
                i = 2;
                return i;
            } catch (Exception e) {
                i = 3;
                System.out.println("Exception");
                return i;
            } finally {
                i = 4;
                System.out.println("Finally");
                return i;
            }
        }
    }
}
