package org.example.Problems.KElevatorDesign.models;

import org.example.Problems.KElevatorDesign.enums.Direction;
import org.example.Problems.KElevatorDesign.interfaces.Pannel;

import java.util.ArrayList;
import java.util.List;

public class OutsidePannel implements Pannel {
    private List<HallButton> hallButtons;

    public OutsidePannel() {
        hallButtons = new ArrayList<>();
        hallButtons.add(new HallButton(false,Direction.UP));
        hallButtons.add(new HallButton(false,Direction.DOWN));
        hallButtons.add(new HallButton(false,Direction.IDLE));
    }

    public void moveUp(){
        // Find the UP button and press it
        for (HallButton button : hallButtons) {
            if (button.getDirection() == Direction.UP) {
                button.press(); // Press the UP button
                break;
            }
        }

    }
    public void moveDown(){
        // Find the DOWN button and press it
        for (HallButton button : hallButtons) {
            if (button.getDirection() == Direction.DOWN) {
                button.press(); // Press the DOWN button
                break;
            }
        }

    }

    public List<HallButton> getHallButtons() {
        return hallButtons;
    }
}
