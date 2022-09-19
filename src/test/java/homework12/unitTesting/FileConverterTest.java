package homework12.unitTesting;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import siit.homework12.FileConverter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class FileConverterTest {
    @BeforeAll
    static void readFile(){
        FileConverter fileConverter = new FileConverter();
        fileConverter.fileConverter("personDatabase.csv", 9, "sortedPersons.csv");

    }
    File outputFile = new File(".\\sortedPersons.csv");
    Path path = Path.of(".\\sortedPersons.csv");
    Scanner in;

    {
        try {
            in = new Scanner(outputFile);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void check_Number_Of_Resulted_Names_Test() throws IOException {
        long results = Files.readAllLines(path).size();

        Assertions.assertEquals(2, results);
    }

    @Test
    public void check_Filter_Name_Results_Test() {
        String firstLine = in.nextLine();
        String secondLine = in.nextLine();

        Assertions.assertEquals("Jane Doe", firstLine);
        Assertions.assertEquals("John Doe", secondLine);
    }
}
