package org.CodeForPizza;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OutputTest {

    Output output;

    @BeforeEach
    void setUp() {
        output = new Output();
    }

    @Test
    void mainMenu() {
        // Arrange
        String expected = """
                Please choose an option to use:
                1. User
                2. Todo
                3. Exit
                """;

        // Act
        String actual = output.mainMenu();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void userMenu() {
        // Arrange
        String expected = """
                Please choose an option:
                1. Create new user
                2. Show all users
                3. Show all Todos for a user
                4. Update a user
                5. Delete a user
                6. Back to main
                """;

        // Act
        String actual = output.userMenu();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void todoMenu() {
        // Arrange
        String expected = """
                Please choose an option:
                1. Create new todo
                2. Show all todos
                3. Show one todo and its info
                4. Update a todo
                5. Delete a todo
                6. Back to main
                """;

        // Act
        String actual = output.todoMenu();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void updateUser() {
        // Arrange
        String expected = """
                Please choose an option:
                1. Update name
                2. Update age
                3. Back to user menu
                """;

        // Act
        String actual = output.updateUser();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void updateTodo() {
        // Arrange
        String expected = """
                Please choose an option:
                1. Update description
                2. Update done
                3. Back to todo menu
                """;

        // Act
        String actual = output.updateTodo();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void askForName() {
        // Arrange
        String expected = "What is the name of the user?";

        // Act
        String actual = output.askForName();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void askForAge() {
        // Arrange
        String expected = "What is the age of the user?";

        // Act
        String actual = output.askForAge();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void askForNewAge() {
        // Arrange
        String expected = "What is the new age of the user?";

        // Act
        String actual = output.askForNewAge();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void askForNewName() {
        // Arrange
        String expected = "What is the new name of the user?";

        // Act
        String actual = output.askForNewName();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void askForId() {
        // Arrange
        String expected = "Please enter id";

        // Act
        String actual = output.askForId();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void askForDescription() {
        // Arrange
        String expected = "What is the description of the todo?";

        // Act
        String actual = output.askForDescription();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void askForDone() {
        // Arrange
        String expected = """
                Is the todo done?\s
                1. Yes
                2. No
                """;

        // Act
        String actual = output.askForDone();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void invalidInput() {
        // Arrange
        String expected = "Please input a number";

        // Act
        String actual = output.invalidInput();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void getExitText() {
        // Arrange
        String expected = "Exiting...";

        // Act
        String actual = output.getExitText();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void askForNewDescription() {
        // Arrange
        String expected = "What is the new description of the todo?";

        // Act
        String actual = output.askForNewDescription();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void askForTitle() {
        // Arrange
        String expected = "What is the title of the todo?";

        // Act
        String actual = output.askForTitle();

        // Assert
        assertEquals(expected, actual);
    }
}