package org.CodeForPizza;

import java.sql.SQLException;
import java.util.ArrayList;

public interface DbInterface {

    void createTables() throws SQLException;
    void createPerson(User user) throws SQLException;
    ArrayList<Todo> readOneUser(int id) throws SQLException;
    String readAllUsers() throws SQLException;
    void deleteUser(int id) throws SQLException;
    void updateUserAge(int id, int age) throws SQLException;
    void updateUserName(int id, String name) throws SQLException;
    void createTodo(Todo todo) throws SQLException;
    String readOneTodo(int id) throws SQLException;
    String readAllTodos() throws SQLException;
    void deleteTodo(int id) throws SQLException;
    void updateTodoDescription(int id, String description) throws SQLException;
    void updateTodoStatus(int id, boolean status) throws SQLException;

}
