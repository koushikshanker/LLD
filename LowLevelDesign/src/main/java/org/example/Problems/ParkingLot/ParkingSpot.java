package org.example.Problems.ParkingLot;

import java.util.UUID;

public class ParkingSpot {
    private String id;
    private String name;
    private ParkingSpotStatus parkingSpotStatus;
    private ParkingFloor parkingFloor;
    private VehicleType vehicleType;
    private Vehicle vehicle;

    public ParkingSpot(String name, VehicleType vehicleType) {
        this.id = String.valueOf(UUID.randomUUID().toString());
        this.name = name;
        this.parkingSpotStatus = ParkingSpotStatus.FREE;
        this.vehicleType =vehicleType;
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

    public ParkingSpotStatus getParkingSpotStatus() {
        return parkingSpotStatus;
    }

    public void setParkingSpotStatus(ParkingSpotStatus parkingSpotStatus) {
        this.parkingSpotStatus = parkingSpotStatus;
    }

    public ParkingFloor getParkingFloor() {
        return parkingFloor;
    }

    public void setParkingFloor(ParkingFloor parkingFloor) {
        this.parkingFloor = parkingFloor;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

}
