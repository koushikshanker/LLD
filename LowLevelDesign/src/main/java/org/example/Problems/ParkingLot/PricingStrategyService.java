package org.example.Problems.ParkingLot;

import java.time.Duration;
import java.time.LocalDateTime;

public class PricingStrategyService implements PricingStrategy{
    public int getPrice(VehicleType vehicleType, LocalDateTime entryTime, LocalDateTime exitTime)
    {
       switch (vehicleType)
       {
           case CAR -> {
               return (int) (4*10*(Duration.between(entryTime, exitTime).toHours()));
           }
           case BIKE -> {
               return (int) (2*10*(Duration.between(entryTime, exitTime).toHours()));
           }
           case TRUCK -> {
               return (int) (5*10*(Duration.between(entryTime, exitTime).toHours()));
           }
       }
       return 0;
    }

}
