package com.example.jakubwiraszka.lab4;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class University {           // Klasa University składa się z listy złożonej z obiektów klasy Departament i ta(Departament) nie może istnieć bez niej(University) - Kompozycja
    private final String name;
    private List<Departament> departaments;


    public University(String name) {
        this.name = name;
        this.departaments = new ArrayList<>();
    }

    public void addDepartament(String name) {
        if(findDepartament(name) == null) {
            departaments.add(new Departament(name));
        }
    }

    private Departament findDepartament(String name) {
        for(Departament i: departaments) {
            if(Objects.equals(name, i.getName())) {
                return i;
            }
        }
        return null;
    }

    public static class Departament {     // Klasa Departament składa się z list złożonych z Klas Student i Lecturer, ale klasy te mogą istnieć bez niej - Agregacja
        private final String name;
        private List<Student> students;
        private List<Lecturer> lecturers;

        public Departament(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void addStudent(String name, String surname, Course course, int year) {
            if(findStudent(name, surname) == null) {
                students.add(new Student(name, surname, course, year));
            }
        }

        public void addLecturer(String name, String surname) {
            if(findLecturer(name, surname) == null) {
                lecturers.add(new Lecturer(name, surname));
            }
        }

        private Student findStudent(String name, String surname) {
            for (Student i: students) {
                if(Objects.equals(i.getName(), name)) {
                    if(Objects.equals(i.getSurname(), surname)) {
                        return i;
                    }
                }
            }
            return null;
        }

        private Lecturer findLecturer(String name, String surname) {
            for (Lecturer i: lecturers) {
                if(Objects.equals(i.getName(), name)) {
                    if(Objects.equals(i.getSurname(), surname)) {
                        return i;
                    }
                }
            }
            return null;
        }
    }
}
