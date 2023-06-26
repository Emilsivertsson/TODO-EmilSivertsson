package org.CodeForPizza;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OutputTest {

    @BeforeEach
    void setUp() {
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
                Please choose what to update:
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
                Please choose what to update:
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
        String expected = "Please input a number\n";

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
        String expected = "What is the new description of the todo?\n";

        // Act
        String actual = Output.askForNewDescription();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Should pass if the ask for title is correct")
    void askForTitle() {
        // Arrange
        String expected = "What is the title of the todo?\n";

        // Act
        String actual = Output.askForTitle();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Should pass if the No users is correct")
    void noUsers() {
        // Arrange
        String expected = "No users exist in the database\n";

        // Act
        String actual = Output.noUsers();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Should pass if the no todos is correct")
    void noTodos() {
        // Arrange
        String expected = "No todos exist in the database\n";

        // Act
        String actual = Output.noTodos();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Should pass if the no user is correct")
    void noUser() {
        // Arrange
        String expected = "No user with that id exists\n";

        // Act
        String actual = Output.noUser();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Should pass if the no todo is correct")
    void noTodo() {
        // Arrange
        String expected = "No todo with that id exists\n";

        // Act
        String actual = Output.noTodo();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Should pass if name cant be empty or null is correct")
    void nameCantBeEmptyOrNull() {
        // Arrange
        String expected = "Name can't be empty or null\n";

        // Act
        String actual = Output.nameCantBeEmptyOrNull();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Should pass if age cant be 0 or below is correct")
    void ageCantBeZero() {
        // Arrange
        String expected = "Age can't be 0 or below\n";

        // Act
        String actual = Output.ageCantBeZero();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Should pass if the title cant be empty is correct")
    void titleCantBeEmpty() {
        // Arrange
        String expected = "Title can't be empty\n";

        // Act
        String actual = Output.titleCantBeEmpty();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Should pass if the description cant be empty is correct")
    void descriptionCantBeEmpty() {
        // Arrange
        String expected = "Description can't be empty\n";

        // Act
        String actual = Output.descriptionCantBeEmpty();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Should pass if the username updated is correct")
    void userNameUpdated() {
        // Arrange
        String expected = "User name updated\n";

        // Act
        String actual = Output.userNameUpdated();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Should pass if the user age updated is correct")
    void userAgeUpdated() {
        // Arrange
        String expected = "User age updated\n";

        // Act
        String actual = Output.userAgeUpdated();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Should pass if the user created is correct")
    void userCreated() {
        // Arrange
        String expected = "User created\n";

        // Act
        String actual = Output.userCreated();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Should pass if the user deleted is correct")
    void userDeleted() {
        // Arrange
        String expected = "User deleted\n";

        // Act
        String actual = Output.userDeleted();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Should pass if the todo description updated is correct")
    void todoDescriptionUpdated() {
        // Arrange
        String expected = "Todo description updated\n";

        // Act
        String actual = Output.todoDescriptionUpdated();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Should pass if the todo status updated is correct")
    void todoStatusUpdated() {
        // Arrange
        String expected = "Todo status updated\n";

        // Act
        String actual = Output.todoStatusUpdated();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Should pass if the todo created is correct")
    void todoCreated() {
        // Arrange
        String expected = "Todo created\n";

        // Act
        String actual = Output.todoCreated();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Should pass if the todo deleted is correct")
    void todoDeleted() {
        // Arrange
        String expected = "Todo deleted\n";

        // Act
        String actual = Output.todoDeleted();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void allTodos() {
        // Arrange
        String expected = "All todos: \n";

        // Act
        String actual = Output.allTodos();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void deleteWho() {
        // Arrange
        String expected = "Who do you want to delete?\n";

        // Act
        String actual = Output.deleteWho();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void allUsers() {
        // arrange
        String expected = "All users: \n";

        // act
        String actual = Output.allUsers();

        // assert
        assertEquals(expected, actual);
    }

    @Test
    void chooseUser() {
        // arrange
        String expected = "Which user do you want to see todos for?\n";

        // act
        String actual = Output.chooseUser();

        // assert
        assertEquals(expected, actual);
    }

    @Test
    void chooseTodo() {
        // arrange
        String expected = "Which todo do you want to see more info about?\n";

        // act
        String actual = Output.chooseTodo();

        // assert
        assertEquals(expected, actual);
    }

    @Test
    void updateWho() {
        // arrange
        String expected = "Who do you want to update?\n";

        // act
        String actual = Output.updateWho();

        // assert
        assertEquals(expected, actual);
    }

    @Test
    void deletewhich() {
        // arrange
        String expected = "Which one do you want to delete?\n";

        // act
        String actual = Output.deletewhich();

        // assert
        assertEquals(expected, actual);
    }

    @Test
    void whichTodoUpdate() {
        // arrange
        String expected = "Which todo do you want to update?\n";

        // act
        String actual = Output.whichTodoUpdate();

        // assert
        assertEquals(expected, actual);
    }

    @Test
    void noTodosForUser() {
        // arrange
        String expected = "No todos for that user\n";

        // act
        String actual = Output.noTodosForUser();

        // assert
        assertEquals(expected, actual);
    }
}