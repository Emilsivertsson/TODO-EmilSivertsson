package org.CodeForPizza;

import java.sql.SQLException;

/**
 * this interface is implements methods create, read, update and delete todos.
 */
public interface TodoInterface {

    boolean checkTodoExist(int id) throws SQLException;
    boolean checkTodosExist() throws SQLException;
    void create(int userId,String title, String text) throws Exception;
    String read(int id) throws Exception;
    String read() throws Exception;
    void delete(int id) throws Exception;
    void update(int id, String description) throws Exception;
    void update(int id, boolean status) throws Exception;
}
