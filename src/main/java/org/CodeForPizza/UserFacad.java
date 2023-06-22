package org.CodeForPizza;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * this class is used to create, read, update and delete users.
 */
public class UserFacad implements UserInterface{

    SQLite db = new SQLite("user");

    public UserFacad() throws SQLException {
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
    public void create(String name, int age) throws SQLException {
        if (!db.checkConnection()) {
            db.openConnection("user");
        }
        User user = new User(name, age);
        db.createPerson(user);
        db.closeConnection();
    }

    @Override
    public ArrayList<Todo> read(int id) throws SQLException {
        if (!db.checkConnection()){
            db.openConnection("user");
        }
        ArrayList<Todo> todos = db.readOneUser(id);
        db.closeConnection();
        return todos;
    }

    @Override
    public String read() throws SQLException {
        if (!db.checkConnection()) {
            db.openConnection("user");
        }
        String users = db.readAllUsers();
        db.closeConnection();
        return users;
    }

    public void delete(int id) throws SQLException {
        if (!db.checkConnection()) {
            db.openConnection("user");
        }
        db.deleteUser(id);
        db.closeConnection();
    }

    @Override
    public void update(int id, int age) throws SQLException {
        if (!db.checkConnection()) {
            db.openConnection("user");
        }
        db.updateUserAge(id, age);
        db.closeConnection();
    }

    @Override
    public void update(int id, String name) throws SQLException {
        if (!db.checkConnection()) {
            db.openConnection("user");
        }
        db.updateUserName(id, name);
        db.closeConnection();
    }
}

