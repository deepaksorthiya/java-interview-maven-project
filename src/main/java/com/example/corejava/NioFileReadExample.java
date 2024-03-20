package com.example.corejava;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class NioFileReadExample {

    public static void main(String[] args) throws IOException, URISyntaxException {
        URI uri = Thread.currentThread().getContextClassLoader().getResource("config/application.properties").toURI();
        Path path = Path.of(uri);
        List<String> strings = Files.readAllLines(path);
        System.out.println(strings);
    }
}
