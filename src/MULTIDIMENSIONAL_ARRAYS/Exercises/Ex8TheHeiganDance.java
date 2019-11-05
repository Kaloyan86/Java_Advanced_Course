package MULTIDIMENSIONAL_ARRAYS.Exercises;

import java.util.Scanner;

public class Ex8TheHeiganDance {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int[][] matrix = new int[15][15];
        double heiganPower = 3000000;
        boolean isHeiganDefeated = false;
        double playerPower = 18500;
        boolean isPlayerDefeated = false;
        int[] position = {7, 7};

        double playersHit = Double.parseDouble(scanner.nextLine());


        boolean hasMoreDamage = false;
        String lastCmd = "";

        while (true) {
            int rowPlayer = position[0];
            int colPlayer = position[1];

            heiganPower -= playersHit;
            isHeiganDefeated = heiganPower <= 0;

            if (hasMoreDamage) {
                playerPower -= 3500;
                hasMoreDamage = false;
                isPlayerDefeated = playerPower <= 0;
            }
            if (isHeiganDefeated || isPlayerDefeated) {
                break;
            }

            String[] line = scanner.nextLine().split(" ");
            String cmd = line[0];
            int row = Integer.parseInt(line[1]);
            int col = Integer.parseInt(line[2]);


            if (isInArea(matrix, row, col, rowPlayer, colPlayer)) {

                if (move(matrix, row, col, rowPlayer, colPlayer)[0] == rowPlayer &&
                        move(matrix, row, col, rowPlayer, colPlayer)[1] == colPlayer) {

                    if (cmd.equals("Cloud")) {
                        lastCmd = "Plague Cloud";
                        playerPower -= 3500;
                        hasMoreDamage = true;

                    } else if (cmd.equals("Eruption")) {
                        lastCmd = "Eruption";
                        playerPower -= 6000;

                    }
                } else {
                    position = move(matrix, row, col, rowPlayer, colPlayer);

                }

            }

            isPlayerDefeated = playerPower <= 0;

            if (isPlayerDefeated) {
                break;
            }

        }
        printResult(heiganPower, playerPower, position, lastCmd);
    }

    private static void printResult(double heiganHp, double playerHp, int[] position, String lastSpell) {
        if (heiganHp <= 0) {
            System.out.println("Heigan: Defeated!");
        } else {
            System.out.printf("Heigan: %.2f\n", heiganHp);
        }
        if (lastSpell.equals("Cloud")) {
            lastSpell = "Plague Cloud";
        }

        if (playerHp <= 0) {
            System.out.printf("Player: Killed by %s\n", lastSpell);
        } else {
            System.out.printf("Player: %.0f\n", playerHp);
        }
        System.out.printf("Final position: %d, %d\n", position[0], position[1]);
    }

    private static boolean isInArea(int[][] matrix, int row, int col, int rPlayer, int cPlayer) {

        for (int r = row - 1; r < row - 1 + 3; r++) {
            for (int c = col - 1; c < col - 1 + 3 ; c++) {
                if (r == rPlayer && c == cPlayer) {
                    return true;

                }
            }
        }
        return false;
    }

    private static int[] move(int[][] matrix, int row, int col, int rowPlayer, int colPlayer) {
        int[] newPoss = {rowPlayer, colPlayer};
        if (rowPlayer - 1 >= 0 && !isInArea(matrix,row,col,rowPlayer-1,colPlayer)) {
            newPoss[0] = rowPlayer - 1;
            return newPoss;
        } else if (colPlayer + 1 < matrix.length && !isInArea(matrix,row,col,rowPlayer,colPlayer+1)) {
            newPoss[1] = colPlayer + 1;
            return newPoss;
        } else if (rowPlayer + 1 < matrix.length && !isInArea(matrix,row,col,rowPlayer+1,colPlayer)) {
            newPoss[0] = rowPlayer + 1;
            return newPoss;
        } else if (colPlayer - 1 >= 0 &&!isInArea(matrix,row,col,rowPlayer,colPlayer-1)) {
            newPoss[1] = colPlayer - 1;
            return newPoss;
        }
        return newPoss;
    }


}
