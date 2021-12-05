package com.example.jakubwiraszka.lab6;

import java.util.ArrayList;

public class Car implements MotorVehicle, Fuelable {
    private double fuel;
    private ArrayList<String> brokenPieces;

    public Car() {
        brokenPieces = new ArrayList<>();
        brokenPieces.add("Door");
        brokenPieces.add("Engine");
    }

    @Override
    public void refuel(double value) {
        fuel += value;
    }

    @Override
    public boolean isBroken() {
        return (brokenPieces.size() > 0);
    }

    @Override
    public ArrayList<String> getBrokenPieces() {
        return brokenPieces;
    }

    @Override
    public void repairBrokenPieces() {
        brokenPieces.clear();
    }
}
