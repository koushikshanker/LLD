package org.example.Problems.KSnakeandladdergame;

import java.util.Arrays;
import java.util.List;

public class SnakeAndLadderDemo {
    public static void run() {
        GameManager gameManager = GameManager.getInstance();

        // Start game 1
        List<String> players1 = Arrays.asList("Player 1", "Player 2", "Player 3");
        gameManager.startNewGame(players1);
    }
}
