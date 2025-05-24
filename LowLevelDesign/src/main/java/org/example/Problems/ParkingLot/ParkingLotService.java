package org.example.Problems.ParkingLot;

import java.time.LocalDateTime;
import java.util.List;

public class ParkingLotService {
    private ParkingLot parkingLot;
    private PricingStrategyService pricingStrategyService;
    private SpotAssignmentStrategyService spotAssignmentStrategyService;
    private PaymentService paymentServce;
    private Notificationservice notificationservice;
    private TicketGeneratingService ticketGeneratingService;
    private static ParkingLotService instance;

    public ParkingLotService(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
        this.pricingStrategyService = new PricingStrategyService();
        this.spotAssignmentStrategyService = new SpotAssignmentStrategyService(parkingLot);
        this.paymentServce = new PaymentService();
        this.notificationservice = new Notificationservice();
        this.ticketGeneratingService = new TicketGeneratingService();
    }

    public static ParkingLotService getInstance(ParkingLot parkingLot) {
        if (instance == null) {
            instance = new ParkingLotService(parkingLot);
        }
        return instance;
    }

    ParkingSpot getParkingSpot(Vehicle vehicle)
    {
        System.out.println("getting parking spot from parking lot service");
        System.out.println("----------------------------------");
        ParkingSpot parkingSpot = spotAssignmentStrategyService.getParkingSpot(vehicle.getVehicleType());
        if(parkingSpot!=null)
        {
            System.out.println("marking parking spot as occupied");
            System.out.println("----------------------------------");
            parkingSpot.setParkingSpotStatus(ParkingSpotStatus.OCCUPIED);
            parkingSpot.setVehicle(vehicle);
            parkingSpot.setVehicleType(vehicle.getVehicleType());
            return parkingSpot;
        }
        else
        {
            throw new RuntimeException("parking spot not found");
        }

    }

    public int fetchFare(Ticket ticket, LocalDateTime exitTime) {
        System.out.println("fetching fare from parking lot service");
        System.out.println("----------------------------------");
        return pricingStrategyService.getPrice(ticket.getVehicle().getVehicleType(),ticket.getEntryTime(),exitTime);
    }

    public Ticket getParkingTicket(Vehicle vehicle, LocalDateTime now, ParkingSpot parkingSpot) {
        System.out.println("Generating ticket from parking lot service");
        System.out.println("----------------------------------");
        return ticketGeneratingService.generateTicket(vehicle,now,parkingSpot);
    }

    public void vehicleExited(Ticket ticket) {
        System.out.println("Marking parking spot as free");
        System.out.println("----------------------------------");
        ticket.getParkingSpot().setParkingSpotStatus(ParkingSpotStatus.FREE);
        System.out.println("Marking ticket as paid");
        System.out.println("----------------------------------");
        ticket.setTicketStatus(TicketStatus.PAID);
    }
}
