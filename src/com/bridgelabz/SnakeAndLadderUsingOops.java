package com.bridgelabz;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

class Player {
    int playerId;
    int currentPosition = 0;
    int diceRollCount = 0;

    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    public void setCurrentPosition(int currentPosition) {
        this.currentPosition = currentPosition;
    }

    public void setDiceRollCount(int diceRollCount) {
        this.diceRollCount = diceRollCount;
    }

    public int getCurrentPosition() {
        return currentPosition;
    }

    public int getDiceRollCount() {
        return diceRollCount;
    }
}

public class SnakeAndLadderUsingOops {
    private final static int WIN_POS = 100;
    private static Map<Integer, Integer> snake = new HashMap<Integer, Integer>();
    private static Map<Integer, Integer> ladder = new HashMap<Integer, Integer>();

    static {
        snake.put(24, 7);
        snake.put(54, 32);
        snake.put(87, 43);
        snake.put(96, 65);

        ladder.put(8, 31);
        ladder.put(28, 77);
        ladder.put(40, 62);
        ladder.put(71, 91);

    }

    public static void main(String[] args) {
        Player player1 = new Player(); player1.setPlayerId(1);
        Player player2 = new Player(); player2.setPlayerId(2);
        Player currentPlayer = player1;

        do {
            int diceValue = rollTheDice();
            currentPlayer.diceRollCount++;
            if (currentPlayer.getCurrentPosition() + diceValue > WIN_POS) {
                currentPlayer = currentPlayer.getPlayerId() == 1 ? player2 : player1;
                continue;
            } else{
                currentPlayer.setCurrentPosition(currentPlayer.getCurrentPosition() + diceValue);
                if (currentPlayer.getCurrentPosition() == WIN_POS) {
                    break;
                } else if (snake.containsKey(currentPlayer.getCurrentPosition())) {
                    currentPlayer.setCurrentPosition(snake.get(currentPlayer.getCurrentPosition()));
                } else if (ladder.containsKey(currentPlayer.getCurrentPosition())) {
                    currentPlayer.setCurrentPosition(ladder.get(currentPlayer.getCurrentPosition()));
                    continue;
                }
            }
            currentPlayer = currentPlayer.getPlayerId() == 1 ? player2 : player1;
        }while(player1.getCurrentPosition() < WIN_POS || player2.getCurrentPosition() < WIN_POS);

        System.out.println("Congratulations! Player: "+currentPlayer.getPlayerId()+", You won the game in "+currentPlayer.getDiceRollCount()+" steps");
    }

    public static int rollTheDice() {
        Random random = new Random();
        int randomNumber = random.nextInt(7);
        return randomNumber == 0 ? 1 : randomNumber;
    }
}
