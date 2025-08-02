package org.example.Problems.KElevatorDesign;

import org.example.Problems.KElevatorDesign.enums.Direction;
import org.example.Problems.KElevatorDesign.enums.ElevatorNumber;
import org.example.Problems.KElevatorDesign.enums.FloorNumber;
import org.example.Problems.KElevatorDesign.models.*;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Setup floors with outside panels
        List<Floor> floors = new ArrayList<>();
        for (FloorNumber floorNumber : FloorNumber.values()) {
            floors.add(new Floor(floorNumber, new OutsidePannel()));
        }

        // Setup elevators
        List<Elevator> elevators = new ArrayList<>();
        for (ElevatorNumber elevatorNumber : ElevatorNumber.values()) {
            elevators.add(new Elevator(
                    elevatorNumber,
                    new Door(),
                    new InsidePannel(),
                    new Display(FloorNumber.FLOOR_NUMBER1, Direction.IDLE, 0),
                    FloorNumber.FLOOR_NUMBER1,
                    Direction.IDLE
            ));
        }

        // Initialize elevator system singleton
        ElevatorSystem elevatorSystem = ElevatorSystem.getInstance();
        elevatorSystem.setFloors(floors);
        elevatorSystem.setElevators(elevators);

        // Simulate a request from Floor 5 going UP
        Floor floor5 = floors.get(4);
        System.out.println("Requesting elevator from floor 5 going UP...");
        Elevator assignedElevator = elevatorSystem.requestElevator(Direction.UP, floor5);

        if (assignedElevator != null) {
            System.out.println("Elevator assigned: " + assignedElevator.getElevatorNumber());
            System.out.println("Current floor: " + assignedElevator.getCurrentFloorNumber());
            System.out.println("Direction: " + assignedElevator.getCurrentDirection());

            // Open door
            elevatorSystem.openDoor(assignedElevator);
            System.out.println("Door action: " + assignedElevator.getDoor().getDoorAction());

            // Select floor 10 inside elevator
            elevatorSystem.selectFloor(FloorNumber.FLOOR_NUMBER10, assignedElevator);
            System.out.println("Floor 10 button pressed inside elevator? " +
                    assignedElevator.getInsidePannel().getElevatorButtonList().get(FloorNumber.FLOOR_NUMBER10.ordinal()).isPressed());

            // Close door
            elevatorSystem.closeDoor(assignedElevator);
            System.out.println("Door action after closing: " + assignedElevator.getDoor().getDoorAction());
        } else {
            System.out.println("No elevator available at this time.");
        }
    }
}
