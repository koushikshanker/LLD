package org.example.Problems.KParkingLot.ParkingSpotStrategyChatgpt;

// DefaultSpotAssignmentStrategy.java
import java.util.*;

public class DefaultSpotAssignmentStrategy implements ParkingSpotAssignmentStrategy {
    private final List<ParkingSpot> spots;

    public DefaultSpotAssignmentStrategy(List<ParkingSpot> allSpots) {
        this.spots = allSpots;
    }

    @Override
    public synchronized ParkingSpot getParkingSpot(VehicleType vehicleType) {
        for (ParkingSpot spot : spots) {
            if (spot.getSpotType() == vehicleType && spot.isFree()) {
                spot.assignVehicle();
                return spot;
            }
        }
        throw new RuntimeException("No available spot for vehicle type: " + vehicleType);
    }

    @Override
    public synchronized void releaseSpot(ParkingSpot spot) {
        spot.releaseSpot();
    }
}
