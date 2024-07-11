package app;

import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileHandler {

    public String createFile(String path) {
        Path newFile;
        try {
            newFile = Files.createFile(Paths.get(path));
        } catch (FileAlreadyExistsException e) {
            return "File already exists!";
        } catch (IOException e) {
            return "Something wrong: " + e.getMessage();
        }
        return "Created " + newFile.toString().replace("\\", "\\\\");
    }

    public String writeToFile(Path path, String content) {
        try {
            Files.writeString(path, content);
        } catch (IOException e) {
            return e.getMessage();
        }
        return "Recorded in " + path.toString().replace("\\", "\\\\");
    }

    public String readFromFile(String path) {
        try {
            return Files.readString(Paths.get(path));
        } catch (IOException e) {
            return "Something wrong: " + e.getMessage();
        }
    }
}
