package org.CodeForPizza;

import java.sql.SQLException;
import java.util.ArrayList;

public class UserFacad{

    SQLite db = new SQLite("user");

    public UserFacad() throws SQLException {
        this.db = db;
    }

    public void create(String name, int age) throws SQLException {
        User user = new User(name, age);
        db.createPerson(user);
    }

    public ArrayList<Todo> read(int id) throws SQLException {
        return db.readOneUser(id);
    }

    public String read() throws SQLException {
        return db.readAllUsers();
    }


    public void delete(int id) throws SQLException {
        db.deleteUser(id);
    }

    public void update(int id, int age) throws SQLException {
        db.updateUserAge(id, age);

    }

    public void update(int id, String name) throws SQLException {
        db.updateUserName(id, name);
    }
}

