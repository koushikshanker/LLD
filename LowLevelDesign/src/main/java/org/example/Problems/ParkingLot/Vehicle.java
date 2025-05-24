package org.example.Problems.ParkingLot;

import java.util.UUID;

public class Vehicle {
    private String id;
    private String name;
    private String numberPlate;
    private VehicleType vehicleType;

    public Vehicle( String name, String numberPlate, VehicleType vehicleType) {
        this.id = String.valueOf(UUID.randomUUID().toString());
        this.name = name;
        this.numberPlate = numberPlate;
        this.vehicleType = vehicleType;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumberPlate() {
        return numberPlate;
    }

    public void setNumberPlate(String numberPlate) {
        this.numberPlate = numberPlate;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }
}
