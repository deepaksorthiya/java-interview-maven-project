package com.example.corejava;

import java.io.IOException;
import java.nio.file.*;

/**
 * java program to watch specific directory
 */
public class FileWatchExample {
    // Main Function
    public static void main(String[] args) {
        try {
            // Specify the directory which supposed to be watched
            Path directoryPath = Paths.get(System.getProperty("user.dir"));

            // Create a WatchService
            WatchService watchService = FileSystems.getDefault().newWatchService();

            // Register the directory for specific events
            directoryPath.register(watchService,
                    StandardWatchEventKinds.ENTRY_CREATE,
                    StandardWatchEventKinds.ENTRY_DELETE,
                    StandardWatchEventKinds.ENTRY_MODIFY);

            System.out.println("Watching directory: " + directoryPath);

            // Infinite loop to continuously watch for events
            while (true) {
                WatchKey key = watchService.take();

                for (WatchEvent<?> event : key.pollEvents()) {
                    // Handle the specific event
                    if (event.kind() == StandardWatchEventKinds.ENTRY_CREATE) {
                        System.out.println("File created: " + event.context());
                    } else if (event.kind() == StandardWatchEventKinds.ENTRY_DELETE) {
                        System.out.println("File deleted: " + event.context());
                    } else if (event.kind() == StandardWatchEventKinds.ENTRY_MODIFY) {
                        System.out.println("File modified: " + event.context());
                    }
                }

                // To receive further events, reset the key
                key.reset();
            }

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}