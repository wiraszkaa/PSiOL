package com.example.jakubwiraszka.lab6;

import java.util.ArrayList;

public class VehicleWorkshop {
    private ArrayList<String> brokenPieces;

    public void diagnose(MotorVehicle vehicle) {
        if(vehicle.isBroken()) {
            brokenPieces = vehicle.getBrokenPieces();
            System.out.println("Te części są zepsute: ");
            printBrokenPieces();
        } else {
            System.out.println("Pojazd jest OK");
        }
    }

    public void repair(MotorVehicle vehicle) {
        vehicle.repairBrokenPieces();
        System.out.println("Naprawiony");
    }

    public void printBrokenPieces() {
        for(String i: brokenPieces) {
            System.out.println(i);
        }
    }
}
