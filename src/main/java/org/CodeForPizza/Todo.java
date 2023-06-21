package org.CodeForPizza;

/**
 * This class is used to create and handle todos.
 */
public class Todo {

    int id;

    String title;
    String text;

    boolean done;

    int assignedTo;

    public Todo(String title,String text) {
        this.text = text;
        this.title = title;
        this.done = false;
    }

    public Todo() {
    }

    public String getText() {
        return text;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public int getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(int assignedTo) {
        if(assignedTo < 0 || assignedTo == 0){
            throw new IllegalArgumentException("Id can not be negative or 0");
        }
        this.assignedTo = assignedTo;
    }

    public String getTitle() {
        return title;
    }

    public void setId(int id) {
        if(id < 0 || id == 0){
            throw new IllegalArgumentException("Id can not be negative or 0");
        }
        this.id = id;
    }

    public void setTitle(String title) {
        if(title.equals("")){
            throw new IllegalArgumentException("Title must be at least 1 character long and can not be empty");
        }
        this.title = title;
    }

    public void setText(String text) {
        if(text.equals("")){
            throw new IllegalArgumentException("Text must be at least 1 character long and can not be empty");
        }
        this.text=text;
    }

    @Override
    public String toString() {
        return "id: " + id + "\n" +
                "Title: " + title + "\n" +
                "Description: " + text + "\n" +
                "Done: " + done + "\n"
                +"--------------------\n";
    }
}


