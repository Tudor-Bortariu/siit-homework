package homework08.unitTesting;

import org.junit.jupiter.api.Test;
import siit.homework08.Student;

import static org.junit.jupiter.api.Assertions.*;

public class StudentConstructorExceptionTest {
    @Test
    public void first_Name_Exception_Test() {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                new Student("", "Snow", 1996, "male", "196568456247"));

        String expectedMessage = "First Name field cannot be empty.";
        String actualMessage = exception.getMessage();

        assertEquals(actualMessage, expectedMessage);
    }

    @Test
    public void last_Name_Exception_Test() {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                new Student("John", "", 1996, "male", "196568456247"));

        String expectedMessage = "Last Name field cannot be empty.";
        String actualMessage = exception.getMessage();

        assertEquals(actualMessage, expectedMessage);
    }

    @Test
    public void birth_Date_Exception_Test() {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                new Student("John", "Snow", 2022, "male", "196568456247"));

        String expectedMessage = "Date of birth must be higher than 1900 and less than current year - 18.";
        String actualMessage = exception.getMessage();

        assertEquals(actualMessage, expectedMessage);
    }

    @Test
    public void gender_Exception_Test() {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                new Student("John", "Snow", 1996, "unknown", "196568456247"));

        String expectedMessage = "Gender must be Male or Female.";
        String actualMessage = exception.getMessage();

        assertEquals(actualMessage, expectedMessage);
    }

    @Test
    public void id_Exception_Test() {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                new Student("John", "Snow", 1996, "male", ""));

        String expectedMessage = "ID cannot be empty.";
        String actualMessage = exception.getMessage();

        assertEquals(actualMessage, expectedMessage);
    }
}
