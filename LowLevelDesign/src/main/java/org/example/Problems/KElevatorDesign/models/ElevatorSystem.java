package org.example.Problems.KElevatorDesign.models;

import org.example.Problems.KElevatorDesign.enums.Direction;
import org.example.Problems.KElevatorDesign.enums.FloorNumber;

import java.util.*;

public class ElevatorSystem {
    private List<Elevator> elevators;
    private List<Floor> floors;
    private static volatile ElevatorSystem elevatorSystemInstance;



    private ElevatorSystem() {
    }



    public static ElevatorSystem getInstance()
    {
        if (elevatorSystemInstance == null)
        {
            synchronized (ElevatorSystem.class)
            {
                if (elevatorSystemInstance == null)
                {
                    return elevatorSystemInstance = new ElevatorSystem();
                }
            }
        }
        return elevatorSystemInstance;
    }

    public Elevator requestElevator(Direction direction, Floor floor)
    {
        FloorNumber requestedFloor = floor.getFloorNumber();
        Elevator bestElevator = null;
        int minDistance = Integer.MAX_VALUE;

        for (Elevator elevator : elevators)
        {
            Direction currentDir = elevator.getCurrentDirection();
            FloorNumber currentFloor = elevator.getCurrentFloorNumber();

            int distance = Math.abs(currentFloor.ordinal() - requestedFloor.ordinal());

            // If elevator is idle, it's a good candidate
            if (currentDir == Direction.IDLE)
            {
                if (distance < minDistance)
                {
                    minDistance = distance;
                    bestElevator = elevator;
                }
            }
            else if (currentDir == direction)
            {
                // Elevator going in requested direction and floor is on its way
                if ((direction == Direction.UP && currentFloor.ordinal() <= requestedFloor.ordinal()) ||
                        (direction == Direction.DOWN && currentFloor.ordinal() >= requestedFloor.ordinal()))
                {
                    if (distance < minDistance)
                    {
                        minDistance = distance;
                        bestElevator = elevator;
                    }
                }
            }
        }

        if (bestElevator != null)
        {
            bestElevator.setCurrentDirection(direction);
            bestElevator.setCurrentFloorNumber(requestedFloor);
            bestElevator.getDisplay().setFloorNumber(requestedFloor);
            bestElevator.getDisplay().setDirection(direction);
        }

        return bestElevator;
    }

    public void openDoor(Elevator elevator) {
        elevator.getDoor().openDoor();

    }
    public void closeDoor(Elevator elevator) {
        elevator.getDoor().closeDoor();

    }
    public void selectFloor(FloorNumber floorNumber, Elevator elevator) {
        elevator.getInsidePannel().pressFloorButton(floorNumber.ordinal());
    }

    public void setFloors(List<Floor> floors) {
        this.floors = floors;
    }

    public void setElevators(List<Elevator> elevators) {
        this.elevators = elevators;
    }
}
