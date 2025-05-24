package org.example.Problems.ParkingLot;

import java.time.LocalDateTime;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        ParkingSpot spot1 = new ParkingSpot("spot1",VehicleType.CAR);
        ParkingSpot spot2 = new ParkingSpot("spot2",VehicleType.CAR);
        ParkingSpot spot3 = new ParkingSpot("spot3",VehicleType.BIKE);
        ParkingSpot spot4 = new ParkingSpot("spot4",VehicleType.TRUCK);

        ParkingFloor floor1 = new ParkingFloor("floor1",1, List.of(spot1,spot2));
        ParkingFloor floor2 = new ParkingFloor("floor2",2, List.of(spot3,spot4));

        ParkingLot parkingLot = new ParkingLot("ForumMallParkingLot", List.of(floor1,floor2));

        ParkingLotService parkingLotService = ParkingLotService.getInstance(parkingLot);


        System.out.println("Vehicle came in");
        System.out.println("----------------------------------");
        Vehicle vehicle = new Vehicle("FERARI","KA00FA9999",VehicleType.CAR);


        ParkingSpot parkingSpot = parkingLotService.getParkingSpot(vehicle);


        Ticket ticket = parkingLotService.getParkingTicket(vehicle, LocalDateTime.now(), parkingSpot);
        System.out.println("Giving ticket to User "+ticket.getId());
        System.out.println("----------------------------------");

        System.out.println("User exiting");
        System.out.println("----------------------------------");
        int priceForTimeSpent = parkingLotService.fetchFare(ticket,LocalDateTime.now().plusHours(2));

        System.out.println("price for time spent: Rs. "+priceForTimeSpent);
        System.out.println("----------------------------------");

        System.out.println("User exited");
        System.out.println("----------------------------------");
        parkingLotService.vehicleExited(ticket);


    }
}
