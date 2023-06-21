package org.CodeForPizza;

import net.bytebuddy.agent.VirtualMachine;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.sql.SQLException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

class UserFacadTest {

    SQLite mockSQLite;
    UserFacad userFacad;

    UserFacadTest() throws SQLException {
    }

    @BeforeEach
    void setUp() throws SQLException {
        mockSQLite = Mockito.mock(SQLite.class);
        userFacad = new UserFacad();
        userFacad.db = mockSQLite;

    }

    @Test
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
    void delete() throws SQLException {
        // Arrange
        int userId = 1;

        // Act
        userFacad.delete(userId);

        // Assert
        verify(mockSQLite).deleteUser(userId);
    }

    @Test
    void updateAge() throws SQLException {
        // Arrange
        int userId = 1;

        // Act
        userFacad.update(userId, 10);

        // Assert
        verify(mockSQLite).updateUserAge(userId, 10);
    }

    @Test
    void UpdateName() throws SQLException {
        // Arrange
        int userId = 1;

        // Act
        userFacad.update(userId, "Emil");


        // Assert
        verify(mockSQLite).updateUserName(userId, "Emil");
    }
}