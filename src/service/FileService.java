package service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;


public class FileService {

    public static void write(String path, String data) throws IOException {
        Files.write(Paths.get(path), data.getBytes(), StandardOpenOption.APPEND);
    }

}
