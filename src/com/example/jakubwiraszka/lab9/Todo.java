package com.example.jakubwiraszka.lab9;

import com.google.gson.annotations.Expose;

public class Todo {
    @Expose(serialize = false)
    private int userId;
    @Expose
    private int id;
    @Expose
    private String title;
    @Expose(serialize = false)
    private boolean completed;

    public int getUserId() {
        return userId;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public boolean isCompleted() {
        return completed;
    }
}
