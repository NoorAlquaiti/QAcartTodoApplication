package com.todo.qacart.object;

public class Task {
    private boolean isCompleted;
    private String item;
    public Task(String item,boolean isCompleted){
        this.isCompleted=isCompleted;
        this.item=item;

    }


    public boolean getIsCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }



}
