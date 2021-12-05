package com.example.jakubwiraszka.lab6;

import java.util.ArrayList;

public interface MotorVehicle extends Vehicle {
    ArrayList<String> getBrokenPieces();
    void repairBrokenPieces();
}
