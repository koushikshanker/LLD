package org.example.Problems.KParkingLot.ParkingSpotStrategyChatgpt;

// NearestSpotAssignmentStrategy.java
import java.util.*;

public class NearestSpotAssignmentStrategy implements ParkingSpotAssignmentStrategy {
    private final Map<VehicleType, PriorityQueue<ParkingSpot>> spotMap;

    public NearestSpotAssignmentStrategy(List<ParkingSpot> allSpots) {
        this.spotMap = new HashMap<>();

        Comparator<ParkingSpot> comparator = new Comparator<ParkingSpot>() {
            @Override
            public int compare(ParkingSpot a, ParkingSpot b) {
                if (a.getFloor() != b.getFloor()) {
                    return Integer.compare(a.getFloor(), b.getFloor());
                }
                return Integer.compare(a.getSpotNumber(), b.getSpotNumber());
            }
        };

        for (VehicleType type : VehicleType.values()) {
            spotMap.put(type, new PriorityQueue<>(comparator));
        }

        for (ParkingSpot spot : allSpots) {
            spotMap.get(spot.getSpotType()).add(spot);
        }
    }

    @Override
    public synchronized ParkingSpot getParkingSpot(VehicleType vehicleType) {
        PriorityQueue<ParkingSpot> queue = spotMap.get(vehicleType);
        while (!queue.isEmpty()) {
            ParkingSpot spot = queue.poll();
            if (spot.isFree()) {
                spot.assignVehicle();
                return spot;
            }
        }
        throw new RuntimeException("No available spot for vehicle type: " + vehicleType);
    }

    @Override
    public synchronized void releaseSpot(ParkingSpot spot) {
        spot.releaseSpot();
        spotMap.get(spot.getSpotType()).add(spot);
    }
}
