package com.bridgelabz;

import java.util.Random;

public class SnakeAndLadderUC1 {
    private static final int WIN_POS = 100;
    public static void main(String[] args) {
        int startPosA = 0, startPosB = 0;
        int diceRollCntA = 0, diceRollCntB = 0;
        int player = 1;
        System.out.println("Welcome to SnakeAndLadder Game!");
        do {
            int diceValue = rollTheDice();
            if (player == 1) {
                diceRollCntA++;
                if ((startPosA + diceValue) > 100) {
                    player = 2;
                    continue; // no play
                } else if (diceValue < 3) { // considering snake for a dice value < 3
                    startPosA-=diceValue;
                    if (startPosA < 0) {
                        startPosA = 0;
                    }
                    player = 2;
                } else {
                    startPosA+=diceValue;
                    player = 1;
                }
                System.out.println("Dice Role: "+diceRollCntA+", A Position: "+startPosA);
                if (startPosA == 100) {
                    break;
                }
            } else {
                diceRollCntB++;

                if ((startPosB + diceValue) > 100) {
                    player = 1;
                    continue; // no play
                } else if (diceValue < 3) { // considering snake for a dice value < 3
                    startPosB-=diceValue;
                    if (startPosB < 0) {
                        startPosB = 0;
                    }
                    player = 1;
                } else {
                    startPosB+=diceValue;
                    player = 2;
                }
                System.out.println("Dice Role: "+diceRollCntB+", B Position: "+startPosB);
                if (startPosB == 100) {
                    break;
                }
            }
        }while(startPosA < WIN_POS || startPosB < WIN_POS);
        System.out.println("Congratulations "+(startPosA == 100 ? "A" : "B")+"! You won the SnakeAndLadder Game in "+(startPosA == 100 ? diceRollCntA : diceRollCntB)+" steps!");
    }

    public static int rollTheDice() {
        Random random = new Random();
        int randomNumber = random.nextInt(7);
        return randomNumber == 0 ? 1: randomNumber;
    }
}
