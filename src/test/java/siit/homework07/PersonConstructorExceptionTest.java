package siit.homework07;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonConstructorExceptionTest {

    @Test
    public void blank_Name_Exception_Test() {

        String actualMessage = assertThrows(IllegalArgumentException.class, () ->
                new Student(" ", 22)).getMessage();
        String expectedMessage = "Person Name must contain at least one character.";

        assertEquals(actualMessage, expectedMessage);
    }

    @Test
    public void negative_Age_Exception_Test() {

        String actualMessage = assertThrows(IllegalArgumentException.class, () ->
                new Student("Popescu Ion", -2)).getMessage();
        String expectedMessage = "Age must be bigger than 0.";

        assertEquals(actualMessage, expectedMessage);
    }

}