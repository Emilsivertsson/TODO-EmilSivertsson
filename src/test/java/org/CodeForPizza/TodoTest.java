package org.CodeForPizza;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TodoTest {
    Todo todo;
    @BeforeEach
    void setUp() {
        todo = new Todo("Hello","Hello more");
    }

    @Test
    @DisplayName("should pass if the text is correct")
    void getText() {
        // Arrange
        String expected = "Hello more";

        // Act
        String actual = todo.getText();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("should pass if the todo is not done")
    void isDone() {
        // Arrange
        boolean expected = false;

        // Act
        boolean actual = todo.isDone();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("should pass if the todo is done")
    void setDone() {
        // Arrange
        boolean value = true;

        // Act
        todo.setDone(value);

        // Assert
        assertTrue(todo.isDone());

    }

    @Test
    @DisplayName("should pass if the assignedTo has correct return")
    void getAssignedTo() {
        // Arrange
        int expected = 1;
        todo.setAssignedTo(1);

        // Act
        int actual = todo.getAssignedTo();

        // Assert
        assertEquals(expected, actual);

    }

    @Test
    @DisplayName("should pass if the assignedTo is correct set")
    void setAssignedTo() {
        // Arrange
        int value = 1;

        // Act
        todo.setAssignedTo(value);

        // Assert
        assertEquals(value, todo.getAssignedTo());
    }
    @Test
    @DisplayName("should pass if the assignedTo is set to zero throws IllegalArgumentException")
    void setAssignedToZero() {
        // Arrange
        int value = 0;

        // Act
        assertThrows(IllegalArgumentException.class, () -> todo.setAssignedTo(value));
    }


    @Test
    @DisplayName("should pass if getTitle returns correct value")
    void getTitle() {
        // Arrange
        String expected = "Hello";

        // Act
        String actual = todo.getTitle();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("should pass if setId sets correct value")
    void setId() {
        // Arrange
        int value = 1;

        // Act
        todo.setId(value);

        // Assert
        assertEquals(value, todo.id);
    }
    @Test
    @DisplayName("should pass if setId to zero throws IllegalArgumentException")
    void setIdZero() {
        // Arrange
        int value = 0;

        // Act
        assertThrows(IllegalArgumentException.class, () -> todo.setId(value));
    }

    @Test
    @DisplayName("should pass if setTitle sets correct value")
    void setTitle() {
        // Arrange
        String value = "Hello";

        // Act
        todo.setTitle(value);

        // Assert
        assertEquals(value, todo.getTitle());
    }
    @Test
    @DisplayName("should pass if setTitle to empty throws IllegalArgumentException")
    void setTitleEmpty() {
        // Arrange
        String value = "";

        // Act
        assertThrows(IllegalArgumentException.class, () -> todo.setTitle(value));
    }

    @Test
    @DisplayName("should pass if setText sets correct value")
    void setText() {
        // Arrange
        String value = "Hello";

        // Act
        todo.setText(value);

        // Assert
        assertEquals(value, todo.getText());
    }
    @Test
    @DisplayName("should pass if setText to empty throws IllegalArgumentException")
    void setTextEmpty() {
        // Arrange
        String value = "";

        // Act
        assertThrows(IllegalArgumentException.class, () -> todo.setText(value));
    }

    @Test
    @DisplayName("should pass if toString returns correct value")
    void testToString() {
        // Arrange
        int id = 1;
        String title = "Hello";
        String text = "Hello more";
        boolean done = false;
        todo.setId(id);

        String expected = "id: " + id + "\n" +
                "Title: " + title + "\n" +
                "Description: " + text + "\n" +
                "Done: " + done + "\n"
                +"--------------------\n";

        // Act
        String actual = todo.toString();

        // Assert
        assertEquals(expected, actual);
    }
}