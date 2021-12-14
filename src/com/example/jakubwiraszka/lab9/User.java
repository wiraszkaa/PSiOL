package com.example.jakubwiraszka.lab9;

import com.google.gson.annotations.Expose;

import java.util.ArrayList;

public class User {
    @Expose
    private int id;
    @Expose
    private String name;
    @Expose
    private String username;
    @Expose
    private String email;
    @Expose
    private Address address;
    @Expose
    private String phone;
    @Expose
    private String website;
    @Expose
    private Company company;
    @Expose(deserialize = false)
    private ArrayList<Todo> done = new ArrayList<>();
    @Expose(deserialize = false)
    private ArrayList<Todo> stillTodo = new ArrayList<>();

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public Address getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public String getWebsite() {
        return website;
    }

    public Company getCompany() {
        return company;
    }

    public ArrayList<Todo> getDone() {
        return done;
    }

    public ArrayList<Todo> getStillTodo() {
        return stillTodo;
    }

    public void addDone(Todo todo) {
        done.add(todo);
    }

    public void addNotDone(Todo todo) {
        stillTodo.add(todo);
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}
