package org.example.Problems.KParkingLot.ParkingSpotStrategyChatgpt;

public class ParkingSpot {
    private final int floor;
    private final int spotNumber;
    private final VehicleType spotType;
    private boolean isOccupied;

    public ParkingSpot(int floor, int spotNumber, VehicleType spotType) {
        this.floor = floor;
        this.spotNumber = spotNumber;
        this.spotType = spotType;
        this.isOccupied = false;
    }

    public int getFloor() {
        return floor;
    }

    public int getSpotNumber() {
        return spotNumber;
    }

    public VehicleType getSpotType() {
        return spotType;
    }

    public boolean isFree() {
        return !isOccupied;
    }

    public void assignVehicle() {
        this.isOccupied = true;
    }

    public void releaseSpot() {
        this.isOccupied = false;
    }
}
