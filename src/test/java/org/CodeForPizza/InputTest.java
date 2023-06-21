package org.CodeForPizza;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InputTest {

    FakeInput sup = new FakeInput();

    @Test
    @DisplayName("should pass if the input is valid")
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
    @DisplayName("should pass if the input is invalid")
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
    @DisplayName("should pass if inputNumber throws NumberFormatException")
    public void inputNumber_InvalidInput() {
        // Arrange
        String value = "abc";
        FakeInput fakeInput = new FakeInput();

        // Act and Assert
        assertThrows(NumberFormatException.class, () -> fakeInput.inputNumber(Integer.parseInt(value)));
    }

    @Test
    @DisplayName("should pass if the input is valid")
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
    @DisplayName("should pass if the input is invalid")
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