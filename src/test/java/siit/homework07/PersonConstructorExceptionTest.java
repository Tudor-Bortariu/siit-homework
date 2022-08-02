package siit.homework07;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonConstructorExceptionTest {

    @Test
    public void blank_Name_Exception_Test() {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                new Student(" ", 22));

        String expectedMessage = "Person Name must contain at least one character.";
        String actualMessage = exception.getMessage();

        assertEquals(actualMessage, expectedMessage);
    }

    @Test
    public void negative_Age_Exception_Test() {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                new Student("Popescu Ion", -2));

        String expectedMessage = "Age must be bigger than 0.";
        String actualMessage = exception.getMessage();

        assertEquals(actualMessage, expectedMessage);
    }

}