package com.example.jakubwiraszka.lab6;

public class Main {

    public static void main(String[] args) {
        Bike bike = new Bike();
        Bus bus = new Bus();
        Car car= new Car();
        Tractor tractor = new Tractor();
        VehicleWorkshop vehicleWorkshop = new VehicleWorkshop();
        TankStation tankStation = new TankStation();

//        vehicleWorkshop.diagnoze(bike);
//        tankStation.tank(bike);
        tankStation.tank(bus);
        vehicleWorkshop.diagnose(bus);
        vehicleWorkshop.diagnose(car);
        vehicleWorkshop.diagnose(tractor);
        vehicleWorkshop.repair(bus);
        vehicleWorkshop.diagnose(bus);
    }
}
