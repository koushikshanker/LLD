package org.example.Problems.KParkingLot.ParkingSpotStrategyChatgpt;

public interface ParkingSpotAssignmentStrategy {
    ParkingSpot getParkingSpot(VehicleType vehicleType);
    void releaseSpot(ParkingSpot spot);
}
