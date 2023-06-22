package org.CodeForPizza;

import java.sql.SQLException;
import java.util.ArrayList;

public interface UserInterface {

    void create(String name, int age) throws SQLException;
    ArrayList<Todo> read(int id) throws SQLException;
    String read() throws SQLException;
    void delete(int id) throws SQLException;
    void update(int id, int age) throws SQLException;
    void update(int id, String name) throws SQLException;

}
