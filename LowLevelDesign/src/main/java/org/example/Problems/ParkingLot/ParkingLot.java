package org.example.Problems.ParkingLot;

import java.util.List;
import java.util.UUID;

public class ParkingLot {
    private String id;
    private String name;
    private List<ParkingFloor> parkingFloorList;

    public ParkingLot(String name, List<ParkingFloor> parkingFloorList) {
        this.id = String.valueOf(UUID.randomUUID().toString());
        this.name = name;
        this.parkingFloorList = parkingFloorList;
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

    public List<ParkingFloor> getParkingFloorList() {
        return parkingFloorList;
    }

    public void setParkingFloorList(List<ParkingFloor> parkingFloorList) {
        this.parkingFloorList = parkingFloorList;
    }
}
