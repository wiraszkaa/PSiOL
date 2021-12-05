package com.example.jakubwiraszka.lab4;

public class Student {    // Klasa Student wykorzystuje klasę Course, która jest niezależna - Asocjacja
    private final String name;
    private final String surname;
    private String course;
    private int year;

    public Student(String name, String surname, Course course, int year) {
        this.name = name;
        this.surname = surname;
        this.course = course.getName();
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }
}
