package org.CodeForPizza;

import java.sql.SQLException;

/**
 * This class is the main class of the application.
 * It is used to run the application, and to call the different menus.
 */
public class Application {

    Input input = new Input();

    UserFacad userFacad = new UserFacad();
    TodoFacade todoFacade = new TodoFacade();

    public Application() throws SQLException {
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
        if (!todoFacade.checkTodosExist()){
            System.out.println(Output.noTodos());
            todoMeny();
        } else {
            System.out.println(todoFacade.read());
            int id = input.inputNumber(Output.askForId());
            ifTodoExistsDelete(id);
        }
    }

    private void ifTodoExistsDelete(int id) throws SQLException {
        if (todoFacade.checkTodoExist(id)) {
            todoFacade.delete(id);
        } else {
            System.out.println(Output.noTodo());
            deleteTodo();
        }
    }

    private void showOneTodo() throws SQLException {
        if (!todoFacade.checkTodosExist()){
            System.out.println(Output.noTodos());
            todoMeny();
        } else {
            System.out.println(todoFacade.read());
            int id = input.inputNumber(Output.askForId());
            ifTodoExistsShowOneTodo(id);
        }
    }

    private void ifTodoExistsShowOneTodo(int id) throws SQLException {
        if (todoFacade.checkTodoExist(id)) {
            System.out.println(todoFacade.read(id));
        } else {
            System.out.println(Output.noTodo());
            showOneTodo();
        }
    }

    private void showAllTodos() throws SQLException {
        if (!todoFacade.checkTodosExist()){
            System.out.println(Output.noTodos());
            todoMeny();
        } else {
            System.out.println(todoFacade.read());
        }
    }

    private void createTodo() throws SQLException{
        System.out.println(userFacad.read());
        int id = input.inputNumber(Output.askForId());
        String title = input.inputString(Output.askForTitle());
        String description = input.inputString(Output.askForDescription());
        todoFacade.create(id, title, description);
    }

    private void updateTodo() throws SQLException {
        if (!todoFacade.checkTodosExist()){
            System.out.println(Output.noTodos());
            todoMeny();
        } else {
            updateTodoMenu();
        }
    }

    private void updateTodoMenu() throws SQLException {
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
        ifTodoExistsUpdateStatus(id);
    }

    private void ifTodoExistsUpdateStatus(int id) throws SQLException {
        if (!todoFacade.checkTodoExist(id)) {
            System.out.println(Output.noTodo());
            updateTodoStatus();
        } else {
            int statusChoice = input.inputNumber(Output.askForDone());
            boolean status = statusChoice(statusChoice);
            todoFacade.update(id, status);
        }
    }

    private static boolean statusChoice(int statusChoice) {
        boolean status = false;
        switch (statusChoice) {
            case 1 -> status = true;
            case 2 -> status = false;
            default -> System.out.println(Output.invalidInput());
        }
        return status;
    }

    private void updateTodoDescription() throws SQLException{
        System.out.println(todoFacade.read());
        int id = input.inputNumber(Output.askForId());
        ifTodoExistsUpdateDescription(id);
    }

    private void ifTodoExistsUpdateDescription(int id) throws SQLException {
        if (!todoFacade.checkTodoExist(id)) {
            System.out.println(Output.noTodo());
            updateTodoDescription();
        } else {
            String description = input.inputString(Output.askForNewDescription());
            todoFacade.update(id, description);
        }
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
        if (!userFacad.checkUsersExist()){
            System.out.println(Output.noUsers());
            userMenu();
        } else {
            System.out.println(userFacad.read());
            int id = input.inputNumber(Output.askForId());
            ifUserExistsDelete(id);
        }
    }

    private void ifUserExistsDelete(int id) throws SQLException {
        if(userFacad.checkIfUserExist(id)){
            userFacad.delete(id);
        } else {
            System.out.println(Output.noUser());
            deleteUser();
        }
    }


    private void showOneUser() throws SQLException {
        if (!userFacad.checkUsersExist()){
            System.out.println(Output.noUsers());
            userMenu();
        } else {
            System.out.println(userFacad.read());
            int id = input.inputNumber(Output.askForId());
            ifUserExistsShowOneUser(id);
        }
    }

    private void ifUserExistsShowOneUser(int id) throws SQLException {
        if (userFacad.checkIfUserExist(id)) {
            System.out.println(userFacad.read(id));
        } else {
            System.out.println(Output.noUser());
            showOneUser();
        }
    }

    private void showAllUsers() throws SQLException {
        if (!userFacad.checkUsersExist()){
            System.out.println(Output.noUsers());
            userMenu();
        } else {
            System.out.println(userFacad.read());
        }
    }


    private void createUser() throws SQLException {
        String name = input.inputString(Output.askForName());
        int age = input.inputNumber(Output.askForAge());
        userFacad.create(name, age);
    }

    private void updateUser() throws SQLException {
        if (!userFacad.checkUsersExist()){
            System.out.println(Output.noUsers());
            userMenu();
        } else {
            updateUserMeny();
        }
    }

    private void updateUserMeny() throws SQLException {
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
        ifUserExistsUpdateAge(id);
    }

    private void ifUserExistsUpdateAge(int id) throws SQLException {
        if (userFacad.checkIfUserExist(id)) {
            int age = input.inputNumber(Output.askForNewAge());
            userFacad.update(id, age);
        } else {
            System.out.println(Output.noUser());
            updateUserAge();
        }
    }

    private void updateUserName() throws SQLException {
        System.out.println(userFacad.read());
        int id = input.inputNumber(Output.askForId());
        ifUserExistsUpdateName(id);
    }

    private void ifUserExistsUpdateName(int id) throws SQLException {
        if (userFacad.checkIfUserExist(id)) {
            String name = input.inputString(Output.askForNewName());
            userFacad.update(id, name);
        } else {
            System.out.println(Output.noUser());
            updateUserName();
        }
    }
}

