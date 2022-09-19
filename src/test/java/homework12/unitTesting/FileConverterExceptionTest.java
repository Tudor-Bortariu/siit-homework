package homework12.unitTesting;

import org.junit.jupiter.api.Test;
import siit.homework12.FileConverter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FileConverterExceptionTest {

    @Test
    public void check_Filter_Results_Test() {
        FileConverter fileConverter = new FileConverter();
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                fileConverter.fileConverter("personDatabase.csv", 13, "sortedPersons.csv"));

        String expectedMessage = "Target month cannot be bigger than 12.";
        String actualMessage = exception.getMessage();

        assertEquals(expectedMessage, actualMessage);
    }

}
