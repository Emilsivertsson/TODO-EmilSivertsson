package org.CodeForPizza;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InputTest {

    FakeInput sup = new FakeInput();



    @Test
    public void InputNumber_ValidInput() {
        // Arrange
        int value = 5;
        int expected = 5;

        // Act
        int actual = sup.inputNumber(value);

        // Assert
        assertEquals(expected, actual);
    }
    @Test
    public void InputNumber_InvalidInput() {
        // Arrange
        int value = 10;
        int expected = 5;

        // Act
        int actual = sup.inputNumber(value);

        // Assert
        assertNotEquals(expected, actual);
    }

    @Test
    public void inputNumber_InvalidInput() {
        // Arrange
        String value = "abc";
        FakeInput fakeInput = new FakeInput();

        // Act and Assert
        assertThrows(NumberFormatException.class, () -> fakeInput.inputNumber(Integer.parseInt(value)));
    }


    @Test
    void inputString_ValidInput() {
        // Arrange
        String prompt = "Hello";
        String expected = "Hello";

        // Act
        String actual = sup.inputString(prompt);

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void inputString_invalidInput() {
        // Arrange
        String prompt = "Hell";
        String expected = "Hello";

        // Act
        String actual = sup.inputString(prompt);

        // Assert
        assertNotEquals(expected, actual);
    }
}