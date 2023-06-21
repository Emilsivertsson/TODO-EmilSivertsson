package org.CodeForPizza;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.sql.SQLException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

class UserFacadeTest {

    SQLite mockSQLite;
    UserFacad userFacad;

    UserFacadeTest() {
    }

    @BeforeEach
    void setUp() throws SQLException {
        mockSQLite = Mockito.mock(SQLite.class);
        userFacad = new UserFacad();
        userFacad.db = mockSQLite;
    }

    @Test
    @DisplayName("Should pass if createPerson is called")
    void create() throws SQLException {
        // Arrange
        String name = "Hello";
        int age = 10;

        // Act
        userFacad.create(name, age);

        // Assert
        verify(mockSQLite).createPerson(Mockito.any(User.class));
    }

    @Test
    @DisplayName("Should pass if readAllUsers is correct string")
    void read() throws SQLException {
        // Arrange
        Mockito.when(mockSQLite.readAllUsers()).thenReturn("Hello");

        // Act
        String actual = userFacad.read();
        verify(mockSQLite).readAllUsers();

        // Assert
        assertEquals("Hello", actual);
    }

    @Test
    @DisplayName("Should pass if readOneUser is called and returns a list of todos")
    void readOne() throws SQLException {
        // Arrange
        ArrayList<Todo> todos = new ArrayList<>();
        todos.add(new Todo());
        todos.add(new Todo());

        Mockito.when(mockSQLite.readOneUser(1)).thenReturn(todos);

        // Act
        ArrayList<Todo> actual = userFacad.read(1);

        verify(mockSQLite).readOneUser(1);

        // Assert
        assertEquals(todos, actual);
    }


    @Test
    @DisplayName("Should pass if deleteUser is called")
    void delete() throws SQLException {
        // Arrange
        int userId = 1;

        // Act
        userFacad.delete(userId);

        // Assert
        verify(mockSQLite).deleteUser(userId);
    }

    @Test
    @DisplayName("Should pass if updateUserAge is called")
    void updateAge() throws SQLException {
        // Arrange
        int userId = 1;

        // Act
        userFacad.update(userId, 10);

        // Assert
        verify(mockSQLite).updateUserAge(userId, 10);
    }

    @Test
    @DisplayName("Should pass if updateUserName is called")
    void UpdateName() throws SQLException {
        // Arrange
        int userId = 1;

        // Act
        userFacad.update(userId, "Emil");

        // Assert
        verify(mockSQLite).updateUserName(userId, "Emil");
    }
}