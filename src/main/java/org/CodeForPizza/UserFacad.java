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

    @Override
    public void create(String name, int age) throws SQLException {
        User user = new User(name, age);
        db.createPerson(user);
    }

    @Override
    public ArrayList<Todo> read(int id) throws SQLException {
        return db.readOneUser(id);
    }

    @Override
    public String read() throws SQLException {
        return db.readAllUsers();
    }

    public void delete(int id) throws SQLException {
        db.deleteUser(id);
    }

    @Override
    public void update(int id, int age) throws SQLException {
        db.updateUserAge(id, age);
    }

    @Override
    public void update(int id, String name) throws SQLException {
        db.updateUserName(id, name);
    }
}

