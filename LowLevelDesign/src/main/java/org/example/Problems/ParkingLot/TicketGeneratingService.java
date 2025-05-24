package org.example.Problems.ParkingLot;

import java.time.LocalDateTime;

public class TicketGeneratingService {
    public Ticket generateTicket(Vehicle vehicle, LocalDateTime time, ParkingSpot parkingSpot)
    {
        System.out.println("Generating ticket form ticket generating service");
        System.out.println("----------------------------------");
        Ticket ticket =  new Ticket("ticket name",vehicle,time,parkingSpot);
        ticket.setTicketStatus(TicketStatus.IN_PROGRESS);
        ticket.setVehicle(vehicle);
        return ticket;
    }
}
