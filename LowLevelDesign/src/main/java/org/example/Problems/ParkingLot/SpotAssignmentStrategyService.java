package org.example.Problems.ParkingLot;

import java.util.List;

public class SpotAssignmentStrategyService implements SpotAssignmentStrategy{
    private ParkingLot parkingLot;

    public SpotAssignmentStrategyService(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public ParkingSpot getParkingSpot(VehicleType vehicleType)
    {
        System.out.println("getting parking spot from spot assignment service");
        System.out.println("----------------------------------");
        for(ParkingFloor parkingFloor: parkingLot.getParkingFloorList())
        {
           for(ParkingSpot parkingSpot:parkingFloor.getParkingSpots())
           {

               if(parkingSpot.getParkingSpotStatus()==ParkingSpotStatus.FREE && parkingSpot.getVehicleType()==vehicleType)
               {
                   return parkingSpot;
               }

           }
        }
        return null;
    }
}
