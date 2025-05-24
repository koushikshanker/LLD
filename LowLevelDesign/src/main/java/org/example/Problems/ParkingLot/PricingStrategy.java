package org.example.Problems.ParkingLot;

import java.time.LocalDateTime;

public interface PricingStrategy {
    public int getPrice(VehicleType vehicleType, LocalDateTime entryTime, LocalDateTime exitTime);
}
