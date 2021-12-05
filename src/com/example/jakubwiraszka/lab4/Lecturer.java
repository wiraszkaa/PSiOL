package com.example.jakubwiraszka.lab4;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Lecturer { // Klasa Lecturer wykorzystuje klasę Course, która jest niezależna - Asocjacja
    private final String name;
    private final String surname;
    private List<String> courses;

    public Lecturer(String name, String surname) {
        this.name = name;
        this.surname = surname;
        this.courses = new ArrayList<>();
    }

    public void addCourse(Course course) {
        if(findCourse(course.getName()) == null) {
            courses.add(course.getName());
        }
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    private String findCourse(String courseName) {
        for(String i: courses) {
            if(Objects.equals(courseName, i)) {
                return i;
            }
        }
        return null;
    }
}
