package org.CodeForPizza;

public interface TodoInterface {

    void create(int userId,String title, String text) throws Exception;
    String read(int id) throws Exception;
    String read() throws Exception;
    void delete(int id) throws Exception;
    void update(int id, String description) throws Exception;
    void update(int id, boolean status) throws Exception;
}
