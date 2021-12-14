package com.example.jakubwiraszka.lab9;

import com.example.jakubwiraszka.lab3.FileEditor;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class JSONData {
    public static void main(String[] args) throws FileNotFoundException {
        Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().setPrettyPrinting().create();
        String userJSON = GetHttpData.HttpGet("https://jsonplaceholder.typicode.com/users");
        Type userListType = new TypeToken<ArrayList<User>>() {
        }.getType();
        ArrayList<User> users = gson.fromJson(userJSON, userListType);

        String todoJSON = GetHttpData.HttpGet("https://jsonplaceholder.typicode.com/todos");
        Type todolistType = new TypeToken<ArrayList<Todo>>() {
        }.getType();
        ArrayList<Todo> todos = new Gson().fromJson(todoJSON, todolistType);

        for (User user : users) {
            for (Todo todo : todos) {
                if (todo.getUserId() == user.getId()) {
                    if (todo.isCompleted()) {
                        user.addDone(todo);
                    } else if (!todo.isCompleted()) {
                        user.addNotDone(todo);
                    }
                }
            }
        }

        FileEditor.writeFile(gson.toJson(users), "D:\\Projekty\\Java\\PSiOL\\src\\com\\example\\jakubwiraszka\\lab9\\users_todo.json");
    }
}
