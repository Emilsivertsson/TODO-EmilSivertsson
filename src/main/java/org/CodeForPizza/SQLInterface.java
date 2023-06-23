package org.CodeForPizza;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * this interface is implements methods for the SQL database.
 */
public interface SQLInterface {

    boolean checkIfUserExist(int id) throws SQLException;
    boolean checkUsersExist() throws SQLException;
    void createTables() throws SQLException;
    void createPerson(User user) throws SQLException;
    ArrayList<Todo> readOneUser(int id) throws SQLException;
    String readAllUsers() throws SQLException;
    void deleteUser(int id) throws SQLException;
    void updateUserAge(int id, int age) throws SQLException;
    void updateUserName(int id, String name) throws SQLException;
    boolean checkIfTodoExist(int id) throws SQLException;
    boolean checkTodosExist() throws SQLException;
    void createTodo(Todo todo) throws SQLException;
    String readOneTodo(int id) throws SQLException;
    String readAllTodos() throws SQLException;
    void deleteTodo(int id) throws SQLException;
    void updateTodoDescription(int id, String description) throws SQLException;
    void updateTodoStatus(int id, boolean status) throws SQLException;

}
