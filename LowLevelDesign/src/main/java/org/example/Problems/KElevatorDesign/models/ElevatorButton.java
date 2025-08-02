package org.example.Problems.KElevatorDesign.models;

import org.example.Problems.KElevatorDesign.enums.FloorNumber;
import org.example.Problems.KElevatorDesign.interfaces.Button;

public class ElevatorButton implements Button {
    private boolean status;

    private FloorNumber floorNumber;

    public ElevatorButton(boolean status, FloorNumber floorNumber) {
        this.status = status;
        this.floorNumber = floorNumber;
    }
    public ElevatorButton() {
    }

    public FloorNumber getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(FloorNumber floorNumber) {
        this.floorNumber = floorNumber;
    }



    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public boolean isPressed() {
        return status;
    }

    @Override
    public boolean press() {
        if (!status) {
            status = true;
            return true;
        }
        return false;
    }

    public void reset() {
        status = false;
    }
}