package org.CodeForPizza;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TodoTest {
    Todo todo;
    @BeforeEach
    void setUp() {
        todo = new Todo("Hello","Hello more");
    }

    @Test
    void getText() {
        // Arrange
        String expected = "Hello more";

        // Act
        String actual = todo.getText();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void isDone() {
        // Arrange
        boolean expected = false;

        // Act
        boolean actual = todo.isDone();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void setDone() {
        // Arrange
        boolean value = true;

        // Act
        todo.setDone(value);

        // Assert
        assertTrue(todo.isDone());

    }

    @Test
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
    void setAssignedTo() {
        // Arrange
        int value = 1;

        // Act
        todo.setAssignedTo(value);

        // Assert
        assertEquals(value, todo.getAssignedTo());
    }
    @Test
    void setAssignedToZero() {
        // Arrange
        int value = 0;

        // Act
        assertThrows(IllegalArgumentException.class, () -> todo.setAssignedTo(value));
    }


    @Test
    void getTitle() {
        // Arrange
        String expected = "Hello";

        // Act
        String actual = todo.getTitle();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void setId() {
        // Arrange
        int value = 1;

        // Act
        todo.setId(value);

        // Assert
        assertEquals(value, todo.id);
    }
    @Test
    void setIdZero() {
        // Arrange
        int value = 0;

        // Act
        assertThrows(IllegalArgumentException.class, () -> todo.setId(value));
    }

    @Test
    void setTitle() {
        // Arrange
        String value = "Hello";

        // Act
        todo.setTitle(value);

        // Assert
        assertEquals(value, todo.getTitle());
    }
    @Test
    void setTitleEmpty() {
        // Arrange
        String value = "";

        // Act
        assertThrows(IllegalArgumentException.class, () -> todo.setTitle(value));
    }

    @Test
    void setText() {
        // Arrange
        String value = "Hello";

        // Act
        todo.setText(value);

        // Assert
        assertEquals(value, todo.getText());
    }
    @Test
    void setTextEmpty() {
        // Arrange
        String value = "";

        // Act
        assertThrows(IllegalArgumentException.class, () -> todo.setText(value));
    }

    @Test
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