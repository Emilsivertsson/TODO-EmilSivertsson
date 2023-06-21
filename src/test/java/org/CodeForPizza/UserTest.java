package org.CodeForPizza;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    User user;

    @BeforeEach
    void setUp() {
        user = new User("Emil", 39);
        user.todos.add(new Todo("Hello1", "Hello more"));
        user.todos.add(new Todo("Hello2", "Hello again"));
    }

    @Test
    @DisplayName("Should pass if the users name is correct")
    void getName() {
        // Arrange
        String expected = "Emil";

        // Act
        String actual = user.getName();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Should pass if the users age is correct")
    void setName() {
        // Arrange
        String name = "kalle";

        // Act
        user.setName(name);

        // Assert
        assertEquals(name, user.getName());
    }

    @Test
    @DisplayName("Should pass if the users name is null and throws IllegalArgumentException")
    void setNameIsNUll() {
        // Arrange
        String name = null;

        // act and assert
        assertThrows(IllegalArgumentException.class, () -> user.setName(name));
    }

    @Test
    @DisplayName("should pass if the users age is correct")
    void getAge() {
        // Arrange
        int expected = 39;

        // Act
        int actual = user.getAge();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Should pass if the users age is correct")
    void setAge() {
        // Arrange
        int age = 40;

        // Act
        user.setAge(age);

        // Assert
        assertEquals(age, user.getAge());
    }

    @Test
    @DisplayName("Should pass if the users age is 0 and throws IllegalArgumentException")
    void setAgeZero() {
        // Arrange
        int age = 0;

        // Act and assert
        assertThrows(IllegalArgumentException.class, () -> user.setAge(age));
    }

    @Test
    @DisplayName("Should pass if the users age is correct")
    void setId() {
        // Arrange
        int id = 1;

        // Act
        user.setId(id);

        // Assert
        assertEquals(id, user.getId());
    }

    @Test
    @DisplayName("Should pass if the users age is 0 and throws IllegalArgumentException")
    void setIdZero() {
        // Arrange
        int id = 0;

        // Act and assert
        assertThrows(IllegalArgumentException.class, () -> user.setId(id));
    }

    @Test
    @DisplayName("Should pass if the users id is correct")
    void getId() {
        // Arrange
        int expected = 0;

        // Act
        int actual = user.getId();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Should pass if the users todos are correct")
    void getTodos() {
        // Arrange
        ArrayList<Todo> expected = new ArrayList<>();
        expected.add(new Todo ("Hello1", "Hello more"));
        expected.add(new Todo ("Hello2", "Hello again"));

        // Act
        ArrayList<Todo> actual = user.getTodos();

        // Assert
        assertEquals(expected.size(), actual.size()); // Check if the sizes are equal
        for (int i = 0; i < expected.size(); i++) {
            Todo expectedTodo = expected.get(i);
            Todo actualTodo = actual.get(i);
            assertEquals(expectedTodo.getTitle(), actualTodo.getTitle());
            assertEquals(expectedTodo.getText(), actualTodo.getText());
        }
    }
}