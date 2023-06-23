package org.CodeForPizza;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.sql.SQLException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class UserFacadeTest {

    SQLite mockSQLite;
    UserFacad userFacad;

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
        when(mockSQLite.readAllUsers()).thenReturn("Hello");

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

        when(mockSQLite.readOneUser(1)).thenReturn(todos);

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

    @Test
    @DisplayName("Should pass if checkIfUserExist returns true")
    void checkIfUserExist() throws SQLException {
        // Arrange
        int id = 1;
        boolean expectedExistence = true;

        when(mockSQLite.checkConnection()).thenReturn(true);
        when(mockSQLite.checkIfUserExist(id)).thenReturn(expectedExistence);

        // Act
        boolean actualExistence = userFacad.checkIfUserExist(id);

        // Assert
        verify(mockSQLite).checkConnection();
        verify(mockSQLite).openConnection("user");
        verify(mockSQLite).checkIfUserExist(id);
        verify(mockSQLite).closeConnection();

        assertEquals(expectedExistence, actualExistence);
    }

    @Test
    @DisplayName("Should pass if checkUsersExist returns true")
    void checkUsersExist() throws SQLException {
        // Arrange
        boolean expectedExistence = true;

        when(mockSQLite.checkConnection()).thenReturn(true);
        when(mockSQLite.checkUsersExist()).thenReturn(expectedExistence);

        // Act
        boolean actualExistence = userFacad.checkUsersExist();

        // Assert
        verify(mockSQLite).checkConnection();
        verify(mockSQLite).openConnection("user");
        verify(mockSQLite).checkUsersExist();
        verify(mockSQLite).closeConnection();

        assertEquals(expectedExistence, actualExistence);
    }
}