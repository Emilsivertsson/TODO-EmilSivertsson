package org.CodeForPizza;

import java.sql.SQLException;

public interface ConnectionInterface {
    void openConnection(String DBName) throws SQLException;

    boolean checkConnection() throws SQLException;

    void closeConnection() throws SQLException;
}
