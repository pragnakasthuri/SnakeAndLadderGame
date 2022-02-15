package com.bridgelabz;

import java.util.Random;

public class SnakeAndLadderUC1 {
    private static final int WIN_POS = 100;
    public static void main(String[] args) {
        int startPos = 0;
        System.out.println("Welcome to SnakeAndLadder Game!");
        do {
            int diceValue = getDiceValue();
        }while(startPos < WIN_POS);

    }

    public static int getDiceValue() {
        Random random = new Random();
        int randomNumber = random.nextInt(7);
        return randomNumber == 0 ? 1: randomNumber;
    }
}
