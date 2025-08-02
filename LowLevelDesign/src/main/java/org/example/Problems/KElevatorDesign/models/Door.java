package org.example.Problems.KElevatorDesign.models;

import org.example.Problems.KElevatorDesign.enums.DoorAction;

public class Door {
    private DoorAction doorAction;

    public Door(DoorAction doorAction) {
        this.doorAction = doorAction;
    }

    public Door() {
    }

    public void openDoor(){
        doorAction = DoorAction.OPEN;
    }
    public void closeDoor(){
        doorAction = DoorAction.CLOSE;
    }

    public DoorAction getDoorAction() {
        return doorAction;
    }
}