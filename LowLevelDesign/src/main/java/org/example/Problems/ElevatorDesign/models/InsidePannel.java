package org.example.Problems.ElevatorDesign.models;

import org.example.Problems.ElevatorDesign.enums.DoorAction;
import org.example.Problems.ElevatorDesign.enums.FloorNumber;
import org.example.Problems.ElevatorDesign.interfaces.Pannel;

import java.util.ArrayList;
import java.util.List;

public class InsidePannel implements Pannel {
    private List<ElevatorButton> elevatorButtonList;
    private List<DoorButton> doorButtons;

    public InsidePannel() {
        elevatorButtonList=new ArrayList<>();
        doorButtons=new ArrayList<>();
        for (int i = 0; i <15 ; i++) {
            elevatorButtonList.add(new ElevatorButton(false, FloorNumber.values()[i]));
        }

        for (int i = 0; i <2 ; i++) {
            doorButtons.add(new DoorButton(false, DoorAction.values()[i]));
        }
    }

    public boolean pressFloorButton(int floorNumber) {
        return elevatorButtonList.get(floorNumber).press();
    }
    public boolean pressDoorButton(int doorNumber) {
        return doorButtons.get(doorNumber).press();
    }

    public List<ElevatorButton> getElevatorButtonList() {
        return elevatorButtonList;
    }

    public List<DoorButton> getDoorButtons() {
        return doorButtons;
    }
}