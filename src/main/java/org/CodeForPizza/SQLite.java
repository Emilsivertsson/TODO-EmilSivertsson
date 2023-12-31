package org.CodeForPizza;

import java.sql.*;
import java.util.ArrayList;

/**
 * this class handles the connection to the database and the queries.
 */
public class SQLite implements SQLInterface, ConnectionInterface {

    Connection conn = null;

    public SQLite (String DBName) throws SQLException {
        openConnection(DBName);
        createTables();
        closeConnection();
    }

    @Override
    public void openConnection(String DBName) throws SQLException {
        try {
            conn = DriverManager.getConnection("jdbc:sqlite:" + DBName + ".db");
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
    }

    @Override
    public boolean checkConnection() throws SQLException {
        try {
            return conn.isClosed();
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
    }

    @Override
    public void closeConnection() throws SQLException {
        try {
            conn.close();
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
    }

    @Override
    public void createTables() throws SQLException {

        String users = "CREATE TABLE IF NOT EXISTS users " +
                "(id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "name VARCHAR (50)," +
                "age INTEGER," +
                "todo_id INTEGER," +
                "FOREIGN KEY (todo_id) REFERENCES todo (assignedTo))";

        String todo = "CREATE TABLE IF NOT EXISTS todo " +
                "(id INTEGER PRIMARY KEY, " +
                "title VARCHAR (50)," +
                "text VARCHAR (2500)," +
                "done BOOLEAN, " +
                "assignedTo INTEGER)";
        try {
            Statement stmt = conn.createStatement();
            stmt.execute(todo);
            stmt.execute(users);
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
    }

    @Override
    public boolean checkIfUserExist(int id) throws SQLException {
        try {
            PreparedStatement stmt = conn.prepareStatement("SELECT COUNT(*) AS count FROM users WHERE id = ?");
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                int count = rs.getInt("count");
                return count <= 0;
            }
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }

        return true;
    }

    @Override
    public boolean checkUsersExist() throws SQLException {
        try {
            PreparedStatement stmt = conn.prepareStatement("SELECT COUNT(*) AS count FROM users");
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                int count = rs.getInt("count");
                return count <= 0;
            }
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }

        return true;
    }

    @Override
    public void createPerson(User user) throws SQLException {
        try{
            PreparedStatement stmt = conn.prepareStatement("Insert into users (name,age) values (?,?)");
            stmt.setString(1, user.getName());
            stmt.setInt(2, user.getAge());
            stmt.executeUpdate();
        }catch (SQLException e){
            throw new SQLException(e.getMessage());
        }
    }

    @Override
    public ArrayList<Todo> readOneUser(int id) throws SQLException {
        try{
            PreparedStatement stmt = conn.prepareStatement("""
                    SELECT users.name, users.age, todo.id, todo.title, todo.text, todo.done
                                    FROM users
                                    inner join todo on users.id = todo.assignedTo
                                    WHERE users.id = ?""");

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            ArrayList<Todo> todos = new ArrayList<>();


            while (rs.next()) {
                Todo todo = new Todo();
                todo.setId(rs.getInt("id"));
                todo.setTitle(rs.getString("title"));
                todo.setText(rs.getString("text"));
                todo.setDone(rs.getBoolean("done"));
                todos.add(todo);
            }
            return todos;
        } catch (SQLException e){
            throw new SQLException(e.getMessage());
        }
    }

    @Override
    public String readAllUsers() throws SQLException {
        try{
            PreparedStatement stmt = conn.prepareStatement("Select * from users");
            ResultSet rs = stmt.executeQuery();
            String result = "";
            while (rs.next()){
                result += rs.getInt("id")
                        + " " + rs.getString("name")
                        + " " + rs.getInt("age") + "\n"
                        +"-----------------" + "\n";
            }
            return result;
        }catch (SQLException e){
            throw new SQLException(e.getMessage());
        }
    }

    @Override
    public void deleteUser(int id) throws SQLException {
        try{
            PreparedStatement deleteTodosStmt = conn.prepareStatement("DELETE FROM todo WHERE assignedTo = ?");
            deleteTodosStmt.setInt(1, id);
            deleteTodosStmt.executeUpdate();

            PreparedStatement stmt = conn.prepareStatement("Delete from users where id = ?");
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }catch (SQLException e){
            throw new SQLException(e.getMessage());
        }
    }

    @Override
    public void updateUserAge(int id, int age) throws SQLException {
        try{
            PreparedStatement stmt = conn.prepareStatement("Update users set age = ? where id = ?");
            stmt.setInt(1, age);
            stmt.setInt(2, id);
            stmt.executeUpdate();
        }catch (SQLException e){
            throw new SQLException(e.getMessage());
        }
    }

    @Override
    public void updateUserName(int id, String name) throws SQLException {
        try{
            PreparedStatement stmt = conn.prepareStatement("Update users set name = ? where id = ?");
            stmt.setString(1, name);
            stmt.setInt(2, id);
            stmt.executeUpdate();
        }catch (SQLException e){
            throw new SQLException(e.getMessage());
        }
    }

    @Override
    public boolean checkIfTodoExist(int id) throws SQLException {
        try {
            PreparedStatement stmt = conn.prepareStatement("SELECT COUNT(*) AS count FROM todo WHERE id = ?");
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                int count = rs.getInt("count");
                return count <= 0;
            }
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }

        return true;
    }

    @Override
    public boolean checkTodosExist() throws SQLException {
        try {
            PreparedStatement stmt = conn.prepareStatement("SELECT COUNT(*) AS count FROM todo");
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                int count = rs.getInt("count");
                return count <= 0;
            }
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
        return true;
    }

    @Override
    public void createTodo(Todo todo) throws SQLException {
        try {
            PreparedStatement stmt = conn.prepareStatement("Insert into todo (title, text, done, assignedTo) values (?,?,?,?)");
            stmt.setString(1, todo.getTitle());
            stmt.setString(2, todo.getText());
            stmt.setBoolean(3, todo.isDone());
            stmt.setInt(4, todo.getAssignedTo());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
    }

    @Override
    public String readOneTodo(int id) throws SQLException {
        try{
            PreparedStatement stmt = conn.prepareStatement("""
                    Select todo.title, todo.text, todo.done, users.name from todo
                            left join users on todo.assignedTo = users.id
                    where todo.id = ?""");

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            return  "Title: " +rs.getString("title") + "\n"
                    + "Description: " +rs.getString("text") + "\n"
                    + "Completed: " + rs.getBoolean("done") + "\n"
                    + "Assigned to: " + rs.getString("name") + "\n";
        } catch (SQLException e){
            throw new SQLException(e.getMessage());
        }
    }

    @Override
    public String readAllTodos() throws SQLException {
        try {
            PreparedStatement stmt = conn.prepareStatement("Select id,title from todo");
            ResultSet rs = stmt.executeQuery();
            String result = "";
            while (rs.next()) {
                result += "Id: "+rs.getInt("id") + "\n"
                        + "Title: " + rs.getString("title") + "\n"
                        +"-----------------" + "\n";
            }
            return result;
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
    }

    @Override
    public void deleteTodo(int id) throws SQLException {
        try {
            PreparedStatement stmt = conn.prepareStatement("Delete from todo where id = ?");
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
    }

    @Override
    public void updateTodoDescription(int id, String description) throws SQLException {
        try {
            PreparedStatement stmt = conn.prepareStatement("Update todo set text = ? where id = ?");
            stmt.setString(1, description);
            stmt.setInt(2, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
    }

    @Override
    public void updateTodoStatus(int id, boolean status) throws SQLException {
        try {
            PreparedStatement stmt = conn.prepareStatement("Update todo set done = ? where id = ?");
            stmt.setBoolean(1, status);
            stmt.setInt(2, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
    }
}

