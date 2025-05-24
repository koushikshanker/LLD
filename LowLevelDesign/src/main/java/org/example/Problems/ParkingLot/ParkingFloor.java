package org.example.Problems.ParkingLot;

import java.util.List;
import java.util.UUID;

public class ParkingFloor {
    private String id;
    private String name;
    private int floorNumber;
    private List<ParkingSpot> parkingSpots;

    public ParkingFloor(String name, int floorNumber, List<ParkingSpot> parkingSpots) {
        this.id = String.valueOf(UUID.randomUUID().toString());
        this.name = name;
        this.floorNumber = floorNumber;
        this.parkingSpots = parkingSpots;
        assignFloorstoParkingSpots();
    }

    private void assignFloorstoParkingSpots() {
        for(ParkingSpot parkingSpot:parkingSpots)
        {
            parkingSpot.setParkingFloor(this);
        }
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public List<ParkingSpot> getParkingSpots() {
        return parkingSpots;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFloorNumber(int floorNumber) {
        this.floorNumber = floorNumber;
    }

    public void setParkingSpots(List<ParkingSpot> parkingSpots) {
        this.parkingSpots = parkingSpots;
    }
}
