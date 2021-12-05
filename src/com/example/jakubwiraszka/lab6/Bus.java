package com.example.jakubwiraszka.lab6;

import java.util.ArrayList;

public class Bus implements MotorVehicle, Fuelable {
    private int fuel;
    private ArrayList<String> brokenPieces;

    public Bus() {
        brokenPieces = new ArrayList<>();
        brokenPieces.add("GearBox");
        brokenPieces.add("Door");
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
