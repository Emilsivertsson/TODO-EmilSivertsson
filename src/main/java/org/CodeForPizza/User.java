package org.CodeForPizza;


import java.util.ArrayList;

/**
 * This class is to create and handle users.
 */
public class User{

    int id;

    String name;

    int age;

    ArrayList<Todo> todos;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
        todos = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name == null || name.isEmpty()){
            throw new IllegalArgumentException("Name can not be null or empty");
        }
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if(age < 0 || age == 0){
            throw new IllegalArgumentException("Age can not be negative or 0");
        }
        this.age = age;
    }

    public void setId(int id) {
        if(id < 0 || id == 0){
            throw new IllegalArgumentException("Id can not be negative or 0");
        }
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public ArrayList<Todo> getTodos() {
        return todos;
    }
}

