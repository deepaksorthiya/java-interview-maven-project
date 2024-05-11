package com.example.corejava;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Arrays;

public class FileOperations {

    public static void main(String[] args) throws URISyntaxException {
        String fileName = "config";

        ClassLoader classLoader = FileOperations.class.getClassLoader();
        URL resource = classLoader.getResource(fileName);

        File file = new File(resource.toURI());

        System.out.println(file.exists());
        System.out.println(file.isDirectory());
        System.out.println(Arrays.stream(file.listFiles()).map(f -> f.getName()).toList());
    }

}
