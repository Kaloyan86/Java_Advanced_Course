package ExamPrep.JavaAdvancedExam24Feb2019;

import java.util.ArrayList;
import java.util.Scanner;

public class P2TronRacers {
    private static char[][] playfield;
    private static int
            firstRow = 0,
            firstCol = 0,
            secondRow = 0,
            secondCol = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        playfield = fillMatrix(scanner);

        int[] firstCurrentPosition = firstCurr(playfield);
        int[] secondCurrentPosition = secondCurr(playfield);

        firstRow = firstCurrentPosition[0];
        firstCol = firstCurrentPosition[1];

        secondRow = secondCurrentPosition[0];
        secondCol = secondCurrentPosition[1];


        boolean isFirstAlive = true;
        boolean isSecondAlive = true;

        while (isSecondAlive) {
            String[] line = scanner.nextLine().split(" ");

            isFirstAlive = move('f',firstRow, firstCol, line[0]);
            if (!isFirstAlive){
                break;
            }
            isSecondAlive = move('s',secondRow, secondCol, line[1]);



        }
        printMatrix(playfield);
    }
    private static boolean move(char player, int playerX, int playerY, String direction) {
        int newPlayerX = playerX;
        int newPlayerY = playerY;
        switch (direction) {
            case "up":
                newPlayerX = playerX - 1 < 0 ?
                        playfield.length - 1 : playerX - 1;
                break;
            case "down":
                newPlayerX = playerX + 1 >= playfield.length ?
                        0 : playerX + 1;
                break;
            case "left":
                newPlayerY = playerY - 1 < 0 ?
                        playfield.length - 1 : playerY - 1;
                break;
            case "right":
                newPlayerY = playerY + 1 >= playfield.length ?
                        0 : playerY + 1;
                break;
        }

        if ((playfield[newPlayerX][newPlayerY] == 'f' && player == 's') ||
                (playfield[newPlayerX][newPlayerY] == 's' && player == 'f')) {

            playfield[newPlayerX][newPlayerY] = 'x';
            return false;
        }

        playfield[newPlayerX][newPlayerY] = player;

        if (player == 'f') {
            firstRow = newPlayerX;
            firstCol = newPlayerY;
        } else {
            secondRow = newPlayerX;
            secondCol = newPlayerY;
        }

        return true;
    }

    private static int[] secondCurr(char[][] matrix) {
        int[] coordinates = new int[2];
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                if (matrix[row][col] == 's') {
                    coordinates[0] = row;
                    coordinates[1] = col;
                }
            }
        }
        return coordinates;
    }

    private static int[] firstCurr(char[][] matrix) {
        int[] coordinates = new int[2];
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                if (matrix[row][col] == 'f') {
                    coordinates[0] = row;
                    coordinates[1] = col;
                }
            }
        }
        return coordinates;
    }

    private static char[][] fillMatrix(Scanner scanner) {

        int n = Integer.parseInt(scanner.nextLine());
        char matrix[][] = new char[n][n];

        for (int i = 0; i < n; i++) {
            String[] line = scanner.nextLine().split("");
            for (int j = 0; j < n; j++) {
                matrix[i][j] = line[j].charAt(0);
            }
        }
        return matrix;
    }

    private static void printMatrix(char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }
}
