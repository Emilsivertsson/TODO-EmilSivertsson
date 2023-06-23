package org.CodeForPizza;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class TodoFacadeTest {

    SQLite mockSQLite;
    TodoFacade todoFacade;


    @BeforeEach
    void setUp() throws SQLException {
        mockSQLite = Mockito.mock(SQLite.class);
        todoFacade = new TodoFacade();
        todoFacade.db = mockSQLite;
    }

    @Test
    @DisplayName("should pass if createTodo is called")
    void create() throws SQLException {
        // Arrange
        int userId = 1;
        String title = "Hello";
        String text = "Hello more";

        // Act
        todoFacade.create(userId, title, text);

        // Assert
        verify(mockSQLite).createTodo(Mockito.any(Todo.class));
    }

    @Test
    @DisplayName("should pass if readAll returns correct string")
    void readAll() throws SQLException {
        // Arrange
        when(mockSQLite.readAllTodos()).thenReturn("Hello");

        // Act
        String actual = todoFacade.read();

        // Assert
        assertEquals("Hello", actual);
    }

    @Test
    @DisplayName("should pass if readOne returns correct string")
    void ReadOne() throws SQLException {
        // Arrange
        when(mockSQLite.readOneTodo(1)).thenReturn("Hello");

        // Act
        String actual = todoFacade.read(1);

        // Assert
        assertEquals("Hello", actual);
    }

    @Test
    @DisplayName("should pass if delete is called")
    void delete() throws SQLException {
        // Arrange
        int id = 1;

        // Act
        todoFacade.delete(id);

        // Assert
        verify(mockSQLite).deleteTodo(1);
    }

    @Test
    @DisplayName("should pass if updateDescription is called")
    void updateDescription() throws SQLException {
        // Arrange
        int id = 1;
        String description = "Hello";

        // Act
        todoFacade.update(id, description);

        // Assert
        verify(mockSQLite).updateTodoDescription(1, "Hello");
    }

    @Test
    @DisplayName("should pass if updateStatus is called")
    void UpdateStatus() throws SQLException {
        // Arrange
        int id = 1;
        boolean status = true;

        // Act
        todoFacade.update(id, status);

        // Assert
        verify(mockSQLite).updateTodoStatus(1, true);
    }

    @Test
    @DisplayName("should pass if TodoExists is true")
    void checkTodoExist() throws SQLException {
        // Arrange
        int id = 1;
        boolean expectedExistence = true;

        when(mockSQLite.checkConnection()).thenReturn(true);
        when(mockSQLite.checkIfTodoExist(id)).thenReturn(expectedExistence);

        // Act
        boolean actualExistence = todoFacade.checkTodoExist(id);

        // Assert
        verify(mockSQLite).checkConnection();
        verify(mockSQLite).openConnection("user");
        verify(mockSQLite).checkIfTodoExist(id);
        verify(mockSQLite).closeConnection();

        assertEquals(expectedExistence, actualExistence);
    }

    @Test
    @DisplayName("should pass if TodosExist is true")
    void checkTodosExist() throws SQLException {
        // Arrange
        boolean expectedExistence = true;

        when(mockSQLite.checkConnection()).thenReturn(true);
        when(mockSQLite.checkTodosExist()).thenReturn(expectedExistence);

        // Act
        boolean actualExistence = todoFacade.checkTodosExist();

        // Assert
        verify(mockSQLite).checkConnection();
        verify(mockSQLite).openConnection("user");
        verify(mockSQLite).checkTodosExist();
        verify(mockSQLite).closeConnection();

        assertEquals(expectedExistence, actualExistence);
    }

}