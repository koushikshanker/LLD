package org.example.Problems.KParkingLot;

import java.time.LocalDateTime;

public interface PricingStrategy {
    public int getPrice(VehicleType vehicleType, LocalDateTime entryTime, LocalDateTime exitTime);
}
