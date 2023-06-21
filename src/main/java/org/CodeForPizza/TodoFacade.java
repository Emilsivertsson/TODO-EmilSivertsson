package org.CodeForPizza;

import java.sql.SQLException;

/**
 * this class is used to create, read, update and delete todos.
 */
public class TodoFacade {

    SQLite db = new SQLite("user");

    public TodoFacade() throws SQLException {
        this.db = db;
    }

    public void create(int userId,String title, String text) throws SQLException {
        Todo todo = new Todo(title, text);
        todo.setDone(false);
        todo.setAssignedTo(userId);
        db.createTodo(todo);
    }

    public String read(int id) throws SQLException {
        return db.readOneTodo(id);
    }

    public String read() throws SQLException {
        return db.readAllTodos();
    }

    public void delete(int id) throws SQLException {
        db.deleteTodo(id);
    }

    public void update(int id, String description) throws SQLException {
        db.updateTodoDescription(id , description);
    }

    public void update(int id, boolean status) throws SQLException {
        db.updateTodoStatus(id, status);
    }
}

