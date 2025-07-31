package org.example.Problems.ElevatorDesignAwesome;

public class ElevatorSystemDemo {
    public static void main(String[] args) {
        ElevatorController controller = new ElevatorController(3, 5);

        System.out.println("5th floor requesting lift for 10th floor");
        controller.requestElevator(5, 10);
        System.out.println("3rd floor requesting lift for 7th floor");
        controller.requestElevator(3, 7);
        System.out.println("8th floor requesting lift for 2nd floor");
        controller.requestElevator(8, 2);
        System.out.println("1st floor requesting lift for 9th floor");
        controller.requestElevator(1, 9);
    }
}