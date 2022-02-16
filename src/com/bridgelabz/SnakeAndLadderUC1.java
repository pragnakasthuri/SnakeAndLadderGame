package com.bridgelabz;

import java.util.Random;

public class SnakeAndLadderUC1 {
    private static final int WIN_POS = 100;
    public static void main(String[] args) {
        int startPos = 0;
        int cnt = 0;
        System.out.println("Welcome to SnakeAndLadder Game!");
        do {
            cnt++;
            int diceValue = getDiceValue();
            if (startPos + diceValue > 100) {
                continue; // no play
            } else if (diceValue < 3) {
                startPos-=diceValue;
                if (startPos < 0) {
                    startPos = 0;
                }
            } else {
                startPos+=diceValue;
            }
            System.out.println("Dice Role: "+cnt+", Position: "+startPos);
        }while(startPos < WIN_POS);
        System.out.println("Congratulations ! You won the SnakeAndLadder Game in "+cnt+" steps!");
    }

    public static int getDiceValue() {
        Random random = new Random();
        int randomNumber = random.nextInt(7);
        return randomNumber == 0 ? 1: randomNumber;
    }
}
