package hu.nive.ujratervezes.kepesitovizsga.phonebook;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;

public class Phonebook {
    public void exportPhonebook(Map<String, String> contacts, String output) {
        validateInputs(contacts, output);

        Path path = createDirectoryAndPath(output);

        try (BufferedWriter writer = Files.newBufferedWriter(path)) {

            for (Map.Entry<String, String> entry : contacts.entrySet()) {
                writer.write(entry.getKey() + ": " + entry.getValue());
                writer.newLine();
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not write file " + path.toString(), ioe);
        }
    }

    private void validateInputs(Map<String, String> contacts, String output) {
        if (contacts == null) {
            throw new IllegalArgumentException("First input parameter (contacts) is null!");
        }
        if (output == null) {
            throw new IllegalArgumentException("Last input parameter (output) is null!");
        }
    }

    private Path createDirectoryAndPath(String output) {
        Path path = Path.of(output);
        Path filename = path.getFileName();
        Path directory = Path.of(output.replace(filename.toString(), "")).toAbsolutePath();
        if (!Files.exists(directory)) {
            try {
                Files.createDirectory(directory);
            } catch (IOException ioe) {
                throw new IllegalStateException("Can not create directory " + directory.toString(), ioe);
            }
        }
        return path;
    }
}
