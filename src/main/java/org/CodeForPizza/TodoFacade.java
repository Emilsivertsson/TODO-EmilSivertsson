package org.CodeForPizza;

import java.sql.SQLException;

/**
 * this class is used to create, read, update and delete todos.
 */
public class TodoFacade implements TodoInterface {

    SQLite db = new SQLite("user");

    public TodoFacade() throws SQLException {
        this.db = db;
    }

    public Boolean isConnectionOpen() throws SQLException {
    	return db.checkConnection();
    }

    public void openConnection() throws SQLException {
    	db.openConnection("user");
    }

    public void closeConnection() throws SQLException {
    	db.closeConnection();
    }

    @Override
    public void create(int userId,String title, String text) throws SQLException {
        if (!db.checkConnection()) {
            db.openConnection("user");
        }
        Todo todo = new Todo(title, text);
        todo.setDone(false);
        todo.setAssignedTo(userId);
        db.createTodo(todo);
        db.closeConnection();
    }

    @Override
    public String read(int id) throws SQLException {
        if (!db.checkConnection()) {
            db.openConnection("user");
        }
        String todo = db.readOneTodo(id);
        db.closeConnection();
        return todo;
    }

    @Override
    public String read() throws SQLException {
        if (!db.checkConnection()) {
            db.openConnection("user");
        }
        String todos = db.readAllTodos();
        db.closeConnection();
        return todos;
    }

    @Override
    public void delete(int id) throws SQLException {
        if (!db.checkConnection()) {
            db.openConnection("user");
        }
        db.deleteTodo(id);
        db.closeConnection();
    }

    @Override
    public void update(int id, String description) throws SQLException {
        if (!db.checkConnection()) {
            db.openConnection("user");
        }
        db.updateTodoDescription(id , description);
        db.closeConnection();
    }

    @Override
    public void update(int id, boolean status) throws SQLException {
        if (!db.checkConnection()) {
            db.openConnection("user");
        }
        db.updateTodoStatus(id, status);
        db.closeConnection();
    }
}

