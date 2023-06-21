package org.CodeForPizza;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.sql.*;
import java.util.ArrayList;
import static org.mockito.ArgumentMatchers.anyString;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class SQLiteTest {

    Connection mockConnection;

    ResultSet mockResultSet;

    PreparedStatement mockStatement;
    private SQLite sqLite;

    @BeforeEach
    void setUp() throws SQLException {
        mockConnection = Mockito.mock(Connection.class);

        mockResultSet = Mockito.mock(ResultSet.class);

        mockStatement = Mockito.mock(PreparedStatement.class);

        sqLite = new SQLite("user");
        sqLite.conn = mockConnection;

        when(mockConnection.prepareStatement(anyString())).thenReturn(mockStatement);
        when(mockStatement.executeQuery()).thenReturn(mockResultSet);
    }


    @Test
    void createPerson() throws SQLException {
        // Arrange
        String sql = "Insert into users (name,age) values (?,?)";
        User user = new User("Alice", 25);

        // Act
        sqLite.createPerson(user);

        // Assert
        verify(mockConnection).prepareStatement(sql);
        verify(mockStatement).setString(1, user.getName());
        verify(mockStatement).setInt(2, user.getAge());
        verify(mockStatement).executeUpdate();

    }

    @Test
    void createPerson_shouldThrowSQLException() throws SQLException {
        // Arrange
        Connection mockConnection = mock(Connection.class);
        PreparedStatement mockStatement = mock(PreparedStatement.class);
        SQLite sqLite = new SQLite("user");
        sqLite.conn = mockConnection;

        when(mockConnection.prepareStatement(anyString())).thenReturn(mockStatement);
        doThrow(SQLException.class).when(mockStatement).executeUpdate();

        User user = new User("Alice", 25);

        // Act and Assert
        assertThrows(SQLException.class, () -> sqLite.createPerson(user));
        verify(mockConnection).prepareStatement(anyString());
        verify(mockStatement).setString(1, user.getName());
        verify(mockStatement).setInt(2, user.getAge());
        verify(mockStatement).executeUpdate();
    }


    @Test
    void readOneUser() throws SQLException {
        // Arrange
        int id = 1;
        String expectedTitle1 = "Task 1";
        String expectedText1 = "Complete task 1";
        boolean expectedDone1 = false;
        String expectedTitle2 = "Task 2";
        String expectedText2 = "Complete task 2";
        boolean expectedDone2 = true;
        String sql = "SELECT users.name, users.age, todo.id, todo.title, todo.text, todo.done\n" +
                "                FROM users\n" +
                "                inner join todo on users.id = todo.assignedTo\n" +
                "                WHERE users.id = ?";
        PreparedStatement mockStatement = Mockito.mock(PreparedStatement.class);
        ResultSet mockResultSet = Mockito.mock(ResultSet.class);

        when(mockConnection.prepareStatement(sql)).thenReturn(mockStatement);
        when(mockStatement.executeQuery()).thenReturn(mockResultSet);
        when(mockResultSet.next()).thenReturn(true, true, false);
        when(mockResultSet.getInt("id")).thenReturn(1, 2);
        when(mockResultSet.getString("title")).thenReturn(expectedTitle1, expectedTitle2);
        when(mockResultSet.getString("text")).thenReturn(expectedText1, expectedText2);
        when(mockResultSet.getBoolean("done")).thenReturn(expectedDone1, expectedDone2);

        // Act
        ArrayList<Todo> result = sqLite.readOneUser(id);

        // Assert
        verify(mockConnection).prepareStatement(sql);
        verify(mockStatement).setInt(1, id);
        verify(mockStatement).executeQuery();
        verify(mockResultSet, times(3)).next();
        verify(mockResultSet, times(2)).getInt("id");
        verify(mockResultSet, times(2)).getString("title");
        verify(mockResultSet, times(2)).getString("text");
        verify(mockResultSet, times(2)).getBoolean("done");


        Todo todo1 = result.get(0);
        assertEquals(expectedTitle1, todo1.getTitle());
        assertEquals(expectedText1, todo1.getText());
        assertEquals(expectedDone1, todo1.isDone());


        Todo todo2 = result.get(1);
        assertEquals(expectedTitle2, todo2.getTitle());
        assertEquals(expectedText2, todo2.getText());
        assertEquals(expectedDone2, todo2.isDone());
    }

    @Test
    void readOneUser_shouldThrowSQLException() throws SQLException {
        // Arrange
        Connection mockConnection = mock(Connection.class);
        PreparedStatement mockStatement = mock(PreparedStatement.class);
        ResultSet mockResultSet = mock(ResultSet.class);
        SQLite sqLite = new SQLite("user");
        sqLite.conn = mockConnection;

        when(mockConnection.prepareStatement(anyString())).thenReturn(mockStatement);
        when(mockStatement.executeQuery()).thenReturn(mockResultSet);
        doThrow(SQLException.class).when(mockResultSet).next();

        int id = 1;

        // Act and Assert
        assertThrows(SQLException.class, () -> sqLite.readOneUser(id));
        verify(mockConnection).prepareStatement(anyString());
        verify(mockStatement).setInt(1, id);
        verify(mockStatement).executeQuery();
        verify(mockResultSet).next();
    }



    @Test
    void readAllUsers() throws SQLException {
        // Arrange
        String sql = "Select * from users";
        ResultSetMetaData mockMetaData = Mockito.mock(ResultSetMetaData.class);
        when(mockResultSet.getMetaData()).thenReturn(mockMetaData);
        when(mockMetaData.getColumnCount()).thenReturn(3);

        when(mockResultSet.next()).thenReturn(true).thenReturn(false);
        when(mockResultSet.getInt("id")).thenReturn(1);
        when(mockResultSet.getString("name")).thenReturn("Alice");
        when(mockResultSet.getInt("age")).thenReturn(25);

        // act
        String result = sqLite.readAllUsers();

        // assert
        verify(mockConnection).prepareStatement(sql);
        verify(mockStatement).executeQuery();
        verify(mockResultSet, times(2)).next();
        verify(mockResultSet).getInt("id");
        verify(mockResultSet).getString("name");
        verify(mockResultSet).getInt("age");

        String expectedResult = "1 " +
                "Alice " +
                "25\n" +
                "-----------------\n";
        assertEquals(expectedResult, result);
    }

    @Test
    void readAllUsers_shouldThrowSQLException() throws SQLException {
        // Arrange
        Connection mockConnection = mock(Connection.class);
        PreparedStatement mockStatement = mock(PreparedStatement.class);
        ResultSet mockResultSet = mock(ResultSet.class);
        SQLite sqLite = new SQLite("user");
        sqLite.conn = mockConnection;

        when(mockConnection.prepareStatement(anyString())).thenReturn(mockStatement);
        when(mockStatement.executeQuery()).thenReturn(mockResultSet);
        doThrow(SQLException.class).when(mockResultSet).next();

        // Act and Assert
        assertThrows(SQLException.class, () -> sqLite.readAllUsers());
        verify(mockConnection).prepareStatement(anyString());
        verify(mockStatement).executeQuery();
        verify(mockResultSet).next();
    }

    @Test
    void deleteUser() throws SQLException {
        // Arrange
        String sql = "Delete from users where id = ?";
        int id = 1;

        // Act
        sqLite.deleteUser(id);

        // Assert
        verify(mockConnection).prepareStatement(sql);
        verify(mockStatement).setInt(1, id);
        verify(mockStatement).executeUpdate();

    }

    @Test
    void deleteUser_shouldThrowSQLException() throws SQLException {
        // Arrange
        Connection mockConnection = mock(Connection.class);
        PreparedStatement mockStatement = mock(PreparedStatement.class);
        SQLite sqLite = new SQLite("user");
        sqLite.conn = mockConnection;

        when(mockConnection.prepareStatement(anyString())).thenReturn(mockStatement);
        doThrow(SQLException.class).when(mockStatement).executeUpdate();

        // Act and Assert
        assertThrows(SQLException.class, () -> sqLite.deleteUser(1));
        verify(mockConnection).prepareStatement(anyString());
        verify(mockStatement).setInt(1, 1);
        verify(mockStatement).executeUpdate();
    }

    @Test
    void updateUserAge() throws SQLException {
        // Arrange
        String sql = "Update users set age = ? where id = ?";
        int id = 1;
        int age = 25;

        // Act
        sqLite.updateUserAge(id, age);

        // Assert
        verify(mockConnection).prepareStatement(sql);
        verify(mockStatement).setInt(1, age);
        verify(mockStatement).setInt(2, id);
        verify(mockStatement).executeUpdate();

    }

    @Test
    void updateUserAge_shouldThrowSQLException() throws SQLException {
        // Arrange
        Connection mockConnection = mock(Connection.class);
        PreparedStatement mockStatement = mock(PreparedStatement.class);
        SQLite sqLite = new SQLite("user");
        sqLite.conn = mockConnection;

        when(mockConnection.prepareStatement(anyString())).thenReturn(mockStatement);
        doThrow(SQLException.class).when(mockStatement).executeUpdate();

        // Act and Assert
        assertThrows(SQLException.class, () -> sqLite.updateUserAge(1, 30));
        verify(mockConnection).prepareStatement(anyString());
        verify(mockStatement).setInt(1, 30);
        verify(mockStatement).setInt(2, 1);
        verify(mockStatement).executeUpdate();
    }

    @Test
    void updateUserName() throws SQLException {
        // Arrange
        String sql = "Update users set name = ? where id = ?";
        int id = 1;
        String name = "Alice";

        // Act
        sqLite.updateUserName(id, name);

        // Assert
        verify(mockConnection).prepareStatement(sql);
        verify(mockStatement).setString(1, name);
        verify(mockStatement).setInt(2, id);
        verify(mockStatement).executeUpdate();

    }

    @Test
    void updateUserName_shouldThrowSQLException() throws SQLException {
        // Arrange
        Connection mockConnection = mock(Connection.class);
        PreparedStatement mockStatement = mock(PreparedStatement.class);
        SQLite sqLite = new SQLite("user");
        sqLite.conn = mockConnection;

        when(mockConnection.prepareStatement(anyString())).thenReturn(mockStatement);
        doThrow(SQLException.class).when(mockStatement).executeUpdate();

        // Act and Assert
        assertThrows(SQLException.class, () -> sqLite.updateUserName(1, "Alice"));
        verify(mockConnection).prepareStatement(anyString());
        verify(mockStatement).setString(1, "Alice");
        verify(mockStatement).setInt(2, 1);
        verify(mockStatement).executeUpdate();
    }

    @Test
    void createTodo() throws SQLException {
        // Arrange
        String sql = "Insert into todo (title, text, done, assignedTo) values (?,?,?,?)";
        Todo todo = new Todo();
        todo.setTitle("Todo Title");
        todo.setText("Todo Text");
        todo.setDone(true);
        todo.setAssignedTo(1);

        // Act
        sqLite.createTodo(todo);

        // Assert
        verify(mockConnection).prepareStatement(sql);
        verify(mockStatement).setString(1, todo.getTitle());
        verify(mockStatement).setString(2, todo.getText());
        verify(mockStatement).setBoolean(3, todo.isDone());
        verify(mockStatement).setInt(4, todo.getAssignedTo());
        verify(mockStatement).executeUpdate();

    }

    @Test
    void readOneTodo() throws SQLException {
        // Arrange
        int id = 1;
        String sql = "Select title,text,done, assignedTo from todo where id = ?";
        ResultSet mockResultSet = Mockito.mock(ResultSet.class);
        when(mockResultSet.getString("title")).thenReturn("Todo Title");
        when(mockResultSet.getString("text")).thenReturn("Todo Text");
        when(mockResultSet.getBoolean("done")).thenReturn(true);
        when(mockResultSet.getInt("assignedTo")).thenReturn(1);

        when(mockConnection.prepareStatement(sql)).thenReturn(mockStatement);
        when(mockStatement.executeQuery()).thenReturn(mockResultSet);

        // Act
        String result = sqLite.readOneTodo(id);

        // Assert
        verify(mockConnection).prepareStatement(sql);
        verify(mockStatement).setInt(1, id);
        verify(mockStatement).executeQuery();
        verify(mockResultSet).getString("title");
        verify(mockResultSet).getString("text");
        verify(mockResultSet).getBoolean("done");
        verify(mockResultSet).getInt("assignedTo");

        String expectedResult = "Title: Todo Title\n" +
                "Description: Todo Text\n" +
                "Completed: true\n" +
                "Assigned to: 1";

        assertEquals(expectedResult, result);
    }



    @Test
    void readAllTodos() throws SQLException {
        // Arrange
        String sql = "Select id,title from todo";
        ResultSetMetaData mockMetaData = Mockito.mock(ResultSetMetaData.class);
        when(mockResultSet.getMetaData()).thenReturn(mockMetaData);
        when(mockMetaData.getColumnCount()).thenReturn(2); // Assuming two columns (id, title)

        when(mockResultSet.next()).thenReturn(true).thenReturn(true).thenReturn(false);
        when(mockResultSet.getInt("id")).thenReturn(1).thenReturn(2);
        when(mockResultSet.getString("title")).thenReturn("Todo 1").thenReturn("Todo 2");

        // Act
        String result = sqLite.readAllTodos();

        // Assert
        verify(mockConnection).prepareStatement(sql);
        verify(mockStatement).executeQuery();
        verify(mockResultSet, Mockito.times(3)).next();
        verify(mockResultSet, Mockito.times(2)).getInt("id");
        verify(mockResultSet, Mockito.times(2)).getString("title");

        String expectedResult = "Id: 1\n" +
                "Title: Todo 1\n" +
                "-----------------\n" +
                "Id: 2\n" +
                "Title: Todo 2\n" +
                "-----------------\n";

        assertEquals(expectedResult, result);
    }




    @Test
    void deleteTodo() throws SQLException {
        // Arrange
        String sql = "Delete from todo where id = ?";
        int id = 1;

        // Act
        sqLite.deleteTodo(id);

        // Assert
        verify(mockConnection).prepareStatement(sql);
        verify(mockStatement).setInt(1, id);
        verify(mockStatement).executeUpdate();

    }

    @Test
    void deleteTodo_shouldThrowSQLException() throws SQLException {
        // Arrange
        Connection mockConnection = mock(Connection.class);
        PreparedStatement mockStatement = mock(PreparedStatement.class);
        SQLite sqLite = new SQLite("user");
        sqLite.conn = mockConnection;

        when(mockConnection.prepareStatement(Mockito.anyString())).thenReturn(mockStatement);
        when(mockStatement.executeUpdate()).thenThrow(SQLException.class);

        int id = 1;

        // Act and Assert
        assertThrows(SQLException.class, () -> sqLite.deleteTodo(id));
        verify(mockConnection).prepareStatement(Mockito.anyString());
        verify(mockStatement).setInt(1, id);
        verify(mockStatement).executeUpdate();
    }

    @Test
    void updateTodoDescription() throws SQLException {
        // Arrange
        String sql = "Update todo set text = ? where id = ?";
        int id = 1;
        String text = "Todo Text";

        // Act
        sqLite.updateTodoDescription(id, text);

        // Assert
        verify(mockConnection).prepareStatement(sql);
        verify(mockStatement).setString(1, text);
        verify(mockStatement).setInt(2, id);
        verify(mockStatement).executeUpdate();

    }

    @Test
    void updateTodoDescription_shouldThrowSQLException() throws SQLException {
        // Arrange
        Connection mockConnection = mock(Connection.class);
        PreparedStatement mockStatement = mock(PreparedStatement.class);
        SQLite sqLite = new SQLite("user");
        sqLite.conn = mockConnection;

        when(mockConnection.prepareStatement(Mockito.anyString())).thenReturn(mockStatement);
        when(mockStatement.executeUpdate()).thenThrow(SQLException.class);

        int id = 1;
        String description = "Updated description";

        // Act and Assert
        assertThrows(SQLException.class, () -> sqLite.updateTodoDescription(id, description));
        verify(mockConnection).prepareStatement(Mockito.anyString());
        verify(mockStatement).setString(1, description);
        verify(mockStatement).setInt(2, id);
        verify(mockStatement).executeUpdate();
    }

    @Test
    void updateTodoStatus() throws SQLException {
        // Arrange
        String sql = "Update todo set done = ? where id = ?";
        int id = 1;
        boolean done = true;

        // Act
        sqLite.updateTodoStatus(id, done);

        // Assert
        verify(mockConnection).prepareStatement(sql);
        verify(mockStatement).setBoolean(1, done);
        verify(mockStatement).setInt(2, id);
        verify(mockStatement).executeUpdate();

    }

    @Test
    void updateTodoStatus_shouldThrowSQLException() throws SQLException {
        // Arrange
        Connection mockConnection = mock(Connection.class);
        PreparedStatement mockStatement = mock(PreparedStatement.class);
        SQLite sqLite = new SQLite("user");
        sqLite.conn = mockConnection;

        when(mockConnection.prepareStatement(Mockito.anyString())).thenReturn(mockStatement);
        when(mockStatement.executeUpdate()).thenThrow(SQLException.class);

        int id = 1;
        boolean status = true;

        // Act and Assert
        assertThrows(SQLException.class, () -> sqLite.updateTodoStatus(id, status));
        verify(mockConnection).prepareStatement(Mockito.anyString());
        verify(mockStatement).setBoolean(1, status);
        verify(mockStatement).setInt(2, id);
        verify(mockStatement).executeUpdate();
    }
}