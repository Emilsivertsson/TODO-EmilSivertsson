package org.CodeForPizza;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OutputTest {

    Output output;

    @BeforeEach
    void setUp() {
        output = new Output();
    }

    @Test
    @DisplayName("Should pass if the main menu is correct")
    void mainMenu() {
        // Arrange
        String expected = """
                Please choose an option to use:
                1. User
                2. Todo
                3. Exit
                """;

        // Act
        String actual = Output.mainMenu();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Should pass if the user menu is correct")
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
        String actual = Output.userMenu();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Should pass if the todo menu is correct")
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
        String actual = Output.todoMenu();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Should pass if the update user menu is correct")
    void updateUser() {
        // Arrange
        String expected = """
                Please choose an option:
                1. Update name
                2. Update age
                3. Back to user menu
                """;

        // Act
        String actual = Output.updateUser();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Should pass if the update todo menu is correct")
    void updateTodo() {
        // Arrange
        String expected = """
                Please choose an option:
                1. Update description
                2. Update done
                3. Back to todo menu
                """;

        // Act
        String actual = Output.updateTodo();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Should pass if the ask for name is correct")
    void askForName() {
        // Arrange
        String expected = "What is the name of the user?";

        // Act
        String actual = Output.askForName();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Should pass if the ask for age is correct")
    void askForAge() {
        // Arrange
        String expected = "What is the age of the user?";

        // Act
        String actual = Output.askForAge();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Should pass if the ask for new age is correct")
    void askForNewAge() {
        // Arrange
        String expected = "What is the new age of the user?";

        // Act
        String actual = Output.askForNewAge();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Should pass if the ask for new name is correct")
    void askForNewName() {
        // Arrange
        String expected = "What is the new name of the user?";

        // Act
        String actual = Output.askForNewName();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Should pass if the ask for id is correct")
    void askForId() {
        // Arrange
        String expected = "Please enter id";

        // Act
        String actual = Output.askForId();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Should pass if the ask for description is correct")
    void askForDescription() {
        // Arrange
        String expected = "What is the description of the todo?";

        // Act
        String actual = Output.askForDescription();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Should pass if the ask if todo is done is correct")
    void askForDone() {
        // Arrange
        String expected = """
                Is the todo done?\s
                1. Yes
                2. No
                """;

        // Act
        String actual = Output.askForDone();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Should pass if the invalid input is correct")
    void invalidInput() {
        // Arrange
        String expected = "Please input a number";

        // Act
        String actual = Output.invalidInput();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Should pass if the exit text is correct")
    void getExitText() {
        // Arrange
        String expected = "Exiting...";

        // Act
        String actual = Output.getExitText();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Should pass if the ask for new description is correct")
    void askForNewDescription() {
        // Arrange
        String expected = "What is the new description of the todo?";

        // Act
        String actual = Output.askForNewDescription();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Should pass if the ask for title is correct")
    void askForTitle() {
        // Arrange
        String expected = "What is the title of the todo?";

        // Act
        String actual = Output.askForTitle();

        // Assert
        assertEquals(expected, actual);
    }
}