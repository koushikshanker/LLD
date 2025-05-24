package org.example.Problems.ParkingLot;

import java.time.LocalDateTime;
import java.util.UUID;

public class Ticket {
    private String id;
    private String name;
    private Vehicle vehicle;
    private LocalDateTime entryTime;
    private ParkingSpot parkingSpot;
    private int price;
    private LocalDateTime exitTime;
    private TicketStatus ticketStatus;

    public Ticket(String name, Vehicle vehicle, LocalDateTime entryTime, ParkingSpot parkingSpot) {
        this.id = String.valueOf(UUID.randomUUID().toString());
        this.name = name;
        this.vehicle = vehicle;
        this.entryTime = entryTime;
        this.parkingSpot = parkingSpot;
        this.ticketStatus = TicketStatus.IN_PROGRESS;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDateTime getEntryTime() {
        return entryTime;
    }

    public ParkingSpot getParkingSpot() {
        return parkingSpot;
    }

    public int getPrice() {
        return price;
    }

    public LocalDateTime getExitTime() {
        return exitTime;
    }

    public TicketStatus getTicketStatus() {
        return ticketStatus;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEntryTime(LocalDateTime entryTime) {
        this.entryTime = entryTime;
    }

    public void setParkingSpot(ParkingSpot parkingSpot) {
        this.parkingSpot = parkingSpot;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setExitTime(LocalDateTime exitTime) {
        this.exitTime = exitTime;
    }

    public void setTicketStatus(TicketStatus ticketStatus) {
        this.ticketStatus = ticketStatus;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
}
