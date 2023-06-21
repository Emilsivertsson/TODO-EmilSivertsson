package org.CodeForPizza;

import java.sql.SQLException;

public class Application {

    SQLite sqLite = new SQLite("user");
    Input input = new Input();

    UserFacad userFacad = new UserFacad();
    TodoFacade todoFacade = new TodoFacade();



    public Application() throws SQLException {
        sqLite.createTables();
        run();
    }


    void run() throws SQLException {
        while (true) {
            int choice = input.inputNumber(Output.mainMenu());
            switch (choice) {
                case 1:
                    userMenu();
                    break;
                case 2:
                    todoMeny();
                    break;
                case 3:
                    System.out.println(Output.getExitText());
                    System.exit(0);
                    break;
                default:
                    System.out.println(Output.invalidInput());
                    break;
            }
        }
    }

    private void todoMeny() throws SQLException {
        int choice = input.inputNumber(Output.todoMenu());
        switch(choice){
            case 1:
                createTodo();
                break;
            case 2:
                showAllTodos();
                break;
            case 3:
                showOneTodo();
                break;
            case 4:
                updateTodo();
                break;
            case 5:
                deleteTodo();
                break;
            case 6:
                run();
                break;
            default:
                System.out.println(Output.invalidInput());
                break;
        }
    }

    private void deleteTodo() throws SQLException {
        System.out.println(todoFacade.read());
        int choice = input.inputNumber(Output.askForId());
        todoFacade.delete(choice);
    }

    private void showOneTodo() throws SQLException {
        System.out.println(todoFacade.read());
        int choice = input.inputNumber(Output.askForId());
        System.out.println(todoFacade.read(choice));
    }

    private void showAllTodos() throws SQLException {
        System.out.println(todoFacade.read());
    }

    private void createTodo() throws SQLException{
        System.out.println(userFacad.read());
        int userId = input.inputNumber(Output.askForId());
        String title = input.inputString(Output.askForTitle());
        String description = input.inputString(Output.askForDescription());
        todoFacade.create(userId, title, description);


    }


    private void updateTodo() throws SQLException {
        int choice = input.inputNumber(Output.updateTodo());
        switch(choice){
            case 21:
                updateTodoDescription();
                break;
            case 2:
                updateTodoStatus();
                break;
            case 3:
                todoMeny();
                break;
            default:
                System.out.println(Output.invalidInput());
                break;
        }

    }

    private void updateTodoStatus() throws SQLException {
        System.out.println(todoFacade.read());
        int choice = input.inputNumber(Output.askForId());
        int statusChoice = input.inputNumber(Output.askForDone());
        boolean status = false;
        switch (statusChoice){
            case 1:
                status = true;
                break;
            case 2:
                status = false;
                break;
            default:
                System.out.println(Output.invalidInput());
                break;
        }
        todoFacade.update(choice, status);
    }

    private void updateTodoDescription() throws SQLException{
        System.out.println(todoFacade.read());
        int choice = input.inputNumber(Output.askForId());
        String description = input.inputString(Output.askForNewDescription());
        todoFacade.update(choice, description);
    }

    private void userMenu() throws SQLException {
        int choice = input.inputNumber(Output.userMenu());
        switch(choice){
            case 1:
                createUser();
                break;
            case 2:
                showAllUsers();
                break;
            case 3:
                showOneUser();
                break;
            case 4:
                updateUser();
                break;
            case 5:
                deleteUser();
                break;
            case 6:
                run();
                break;
            default:
                System.out.println(Output.invalidInput());
                break;
        }
    }

    private void deleteUser() throws SQLException {
        System.out.println(userFacad.read());
        int choice = input.inputNumber(Output.askForId());
        userFacad.delete(choice);
    }

    private void showOneUser() throws SQLException {
        System.out.println(userFacad.read());
        int choice = input.inputNumber(Output.askForId());
        System.out.println(userFacad.read(choice));
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
        switch(choice){
            case 1:
                updateUserName();
                break;
            case 2:
                updateUserAge();
                break;
            case 3:
                userMenu();
                break;
            default:
                System.out.println(Output.invalidInput());
                break;
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

