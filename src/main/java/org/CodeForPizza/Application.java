package org.CodeForPizza;

import java.sql.SQLException;

/**
 * This class is the main class of the application.
 * It is used to run the application, and to call the different menus.
 */
public class Application {

    SQLite sqLite = new SQLite("user");
    Input input = new Input();

    UserFacad userFacad = new UserFacad();
    TodoFacade todoFacade = new TodoFacade();

    public Application() throws SQLException {
        sqLite.createTables();
        mainMenu();
    }

    void mainMenu() throws SQLException {
        while (true) {
            int choice = input.inputNumber(Output.mainMenu());
            switch (choice) {
                case 1 -> userMenu();
                case 2 -> todoMeny();
                case 3 -> {
                    System.out.println(Output.getExitText());
                    System.exit(0);
                }
                default -> System.out.println(Output.invalidInput());
            }
        }
    }

    private void todoMeny() throws SQLException {
        int choice = input.inputNumber(Output.todoMenu());
        switch (choice) {
            case 1 -> createTodo();
            case 2 -> showAllTodos();
            case 3 -> showOneTodo();
            case 4 -> updateTodo();
            case 5 -> deleteTodo();
            case 6 -> mainMenu();
            default -> System.out.println(Output.invalidInput());
        }
    }

    private void deleteTodo() throws SQLException {
        System.out.println(todoFacade.read());
        int id = input.inputNumber(Output.askForId());
        todoFacade.delete(id);
    }

    private void showOneTodo() throws SQLException {
        System.out.println(todoFacade.read());
        int id = input.inputNumber(Output.askForId());
        System.out.println(todoFacade.read(id));
    }

    private void showAllTodos() throws SQLException {
        System.out.println(todoFacade.read());
    }

    private void createTodo() throws SQLException{
        System.out.println(userFacad.read());
        int id = input.inputNumber(Output.askForId());
        String title = input.inputString(Output.askForTitle());
        String description = input.inputString(Output.askForDescription());
        todoFacade.create(id, title, description);
    }

    private void updateTodo() throws SQLException {
        int choice = input.inputNumber(Output.updateTodo());
        switch (choice) {
            case 1 -> updateTodoDescription();
            case 2 -> updateTodoStatus();
            case 3 -> todoMeny();
            default -> System.out.println(Output.invalidInput());
        }
    }

    private void updateTodoStatus() throws SQLException {
        System.out.println(todoFacade.read());
        int id = input.inputNumber(Output.askForId());
        int statusChoice = input.inputNumber(Output.askForDone());
        boolean status = false;
        switch (statusChoice) {
            case 1 -> status = true;
            case 2 -> status = false;
            default -> System.out.println(Output.invalidInput());
        }
        todoFacade.update(id, status);
    }

    private void updateTodoDescription() throws SQLException{
        System.out.println(todoFacade.read());
        int id = input.inputNumber(Output.askForId());
        String description = input.inputString(Output.askForNewDescription());
        todoFacade.update(id, description);
    }

    private void userMenu() throws SQLException {
        int choice = input.inputNumber(Output.userMenu());
        switch (choice) {
            case 1 -> createUser();
            case 2 -> showAllUsers();
            case 3 -> showOneUser();
            case 4 -> updateUser();
            case 5 -> deleteUser();
            case 6 -> mainMenu();
            default -> System.out.println(Output.invalidInput());
        }
    }

    private void deleteUser() throws SQLException {
        System.out.println(userFacad.read());
        int id = input.inputNumber(Output.askForId());
        userFacad.delete(id);
    }

    private void showOneUser() throws SQLException {
        System.out.println(userFacad.read());
        int id = input.inputNumber(Output.askForId());
        System.out.println(userFacad.read(id));
    }


    private void showAllUsers() throws SQLException {
        System.out.println(userFacad.read());
    }

    private void createUser() throws SQLException {
        String name = input.inputString(Output.askForName());
        int age = input.inputNumber(Output.askForAge());
        userFacad.create(name, age);
    }

    private void updateUser() throws SQLException {
        int choice = input.inputNumber(Output.updateUser());
        switch (choice) {
            case 1 -> updateUserName();
            case 2 -> updateUserAge();
            case 3 -> userMenu();
            default -> System.out.println(Output.invalidInput());
        }
    }

    private void updateUserAge() throws SQLException {
        System.out.println(userFacad.read());
        int id = input.inputNumber(Output.askForId());
        int age = input.inputNumber(Output.askForNewAge());
        userFacad.update(id, age);
    }

    private void updateUserName() throws SQLException {
        System.out.println(userFacad.read());
        int id = input.inputNumber(Output.askForId());
        String name = input.inputString(Output.askForNewName());
        userFacad.update(id, name);
    }
}

