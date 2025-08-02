package org.example.Problems.KElevatorDesign.models;

import org.example.Problems.KElevatorDesign.enums.DoorAction;
import org.example.Problems.KElevatorDesign.interfaces.Button;

public class DoorButton implements Button {
    private boolean status;

    private DoorAction doorAction;

    public DoorButton(boolean status, DoorAction doorAction) {
        this.status = status;
        this.doorAction = doorAction;
    }
    public DoorButton() {
        this.status = false;
    }

    public DoorAction getDoorAction() {
        return doorAction;
    }

    public void setDoorAction(DoorAction doorAction) {
        this.doorAction = doorAction;
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
            status = true; // Only set to pressed if not already pressed
            return true;
        }
        return false; // Already pressed, no change
    }

    // New method to reset button when door operation completes
    public void reset() {
        status = false;
    }
}
