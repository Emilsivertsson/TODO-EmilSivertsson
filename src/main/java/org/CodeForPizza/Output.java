package org.CodeForPizza;

public class Output {

    static String mainMenu() {
        return """
                Please choose an option to use:
                1. User
                2. Todo
                3. Exit
                """;
    }

    static String userMenu() {
        return """
                Please choose an option:
                1. Create new user
                2. Show all users
                3. Show all Todos for a user
                4. Update a user
                5. Delete a user
                6. Back to main
                """;
    }

    static String todoMenu(){
        return """
                Please choose an option:
                1. Create new todo
                2. Show all todos
                3. Show one todo and its info
                4. Update a todo
                5. Delete a todo
                6. Back to main
                """;
    }

    static String updateUser(){
        return """
                Please choose an option:
                1. Update name
                2. Update age
                3. Back to user menu
                """;
    }

    static String updateTodo(){
        return """
                Please choose an option:
                1. Update description
                2. Update done
                3. Back to todo menu
                """;
    }

    static String askForName() {
        return "What is the name of the user?";
    }

    static String askForAge() {
        return "What is the age of the user?";
    }

    static String askForNewAge() {
        return "What is the new age of the user?";
    }

    static String askForNewName() {
        return "What is the new name of the user?";
    }

    static String askForId() {
        return "Please enter id";
    }

    static String askForDescription() {
        return "What is the description of the todo?";
    }

    static String askForDone() {
        return """
                Is the todo done?\s
                1. Yes
                2. No
                """;
    }

    static String invalidInput() {
        return "Please input a number";
    }

    static String getExitText() {
        return "Exiting...";
    }


    static String askForNewDescription() {
        return "What is the new description of the todo?";
    }

    static String askForTitle() {
        return "What is the title of the todo?";
    }
}
