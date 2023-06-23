package org.CodeForPizza;

import java.sql.SQLException;

/**
 * this class is used to create, read, update and delete todos.
 */
public class TodoFacade implements TodoInterface {

    SQLite db = new SQLite("user");

    public TodoFacade() throws SQLException {
    }

    @Override
    public void checkIfConnection() throws SQLException {
        if (db.checkConnection()) {
            db.openConnection("user");
        }
    }

    @Override
    public boolean checkTodoExist(int id) throws SQLException {
        checkIfConnection();
        boolean todoExist = db.checkIfTodoExist(id);
        db.closeConnection();
        return todoExist;
    }

    @Override
    public boolean checkTodosExist() throws SQLException {
        checkIfConnection();
        boolean todosExist = db.checkTodosExist();
        db.closeConnection();
        return todosExist;
    }

    @Override
    public void create(int userId,String title, String text) throws SQLException {
        checkIfConnection();
        Todo todo = new Todo(title, text);
        todo.setDone(false);
        todo.setAssignedTo(userId);
        db.createTodo(todo);
        db.closeConnection();
    }

    @Override
    public String read(int id) throws SQLException {
        checkIfConnection();
        String todo = db.readOneTodo(id);
        db.closeConnection();
        return todo;
    }

    @Override
    public String read() throws SQLException {
        checkIfConnection();
        String todos = db.readAllTodos();
        db.closeConnection();
        return todos;
    }

    @Override
    public void delete(int id) throws SQLException {
        checkIfConnection();
        db.deleteTodo(id);
        db.closeConnection();
    }

    @Override
    public void update(int id, String description) throws SQLException {
        checkIfConnection();
        db.updateTodoDescription(id , description);
        db.closeConnection();
    }

    @Override
    public void update(int id, boolean status) throws SQLException {
        checkIfConnection();
        db.updateTodoStatus(id, status);
        db.closeConnection();
    }
}

