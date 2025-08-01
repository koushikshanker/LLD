package org.example.Problems.KParkingLot.ParkingSpotStrategyChatgpt;

// ParkingLot.java
public class ParkingLot {
    private final ParkingSpotAssignmentStrategy strategy;

    public ParkingLot(ParkingSpotAssignmentStrategy strategy) {
        this.strategy = strategy;
    }

    public ParkingSpot parkVehicle(VehicleType vehicleType) {
        return strategy.getParkingSpot(vehicleType);
    }

    public void unparkVehicle(ParkingSpot spot) {
        strategy.releaseSpot(spot);
    }
}
