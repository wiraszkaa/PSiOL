package com.example.jakubwiraszka.lab3;

import java.io.FileNotFoundException;

public class Vector {
    private double x1;
    private double y1;
    private double x2;
    private double y2;

    public Vector() {
    }

    public Vector(double x1, double y1, double x2, double y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    public String printValue() {
        return ("[" + (x2 - x1) + ";" + (y2 - y1) + "]");
    }

    public double length() {
        return Math.sqrt(Math.pow((x2- x1), (y2 - y1)));
    }

    public Vector unitVector() {
        return new Vector(0, 0, ((x2 - x1) / length()), ((y2 - y1) / length()));
    }

    public boolean save(String path) throws FileNotFoundException {

        String vector = "[" + (x2 - x1) + ";" + (y2 - y1) + "]";

        return FileEditor.writeFile(vector, path);
    }

    public Vector read(String path) throws FileNotFoundException {
        String string = FileEditor.readFile(path);
        String[] words = string.split(" ");
        return new Vector(0, 0, Double.parseDouble(words[0]), Double.parseDouble(words[1]));
    }

    public Vector read1(String path) throws FileNotFoundException {
        String string = FileEditor.readFile(path);
        String[] words = string.split("");
        return new Vector(0, 0, Double.parseDouble(words[1]), Double.parseDouble(words[3]));
    }

    public Vector sumVectors(Vector other) {
        return new Vector((x1 + other.getX1()), (y1 + other.getY1()), (x2 + other.getX2()), (y2 + other.getY2()));
    }

    public Vector copy() {
        return new Vector(x1, y1, x2, y2);
    }

    public double getX1() {
        return x1;
    }

    public double getY1() {
        return y1;
    }

    public double getX2() {
        return x2;
    }

    public double getY2() {
        return y2;
    }
}
