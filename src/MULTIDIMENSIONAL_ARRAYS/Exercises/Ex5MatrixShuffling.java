package MULTIDIMENSIONAL_ARRAYS.Exercises;

import java.util.Arrays;
import java.util.Scanner;

public class Ex5MatrixShuffling {
    public static String[][] matrix;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        matrix = fillMatrix(scanner);

        String[] input = scanner.nextLine().split("\\s+");

        while (!input[0].equals("END")) {

            if (input.length != 5 || !input[0].equals("swap")) {
                System.out.println("Invalid input!");
                input = scanner.nextLine().split("\\s+");
                continue;
            }

            int row1 = Integer.parseInt(input[1]);
            int col1 = Integer.parseInt(input[2]);
            int row2 = Integer.parseInt(input[3]);
            int col2 = Integer.parseInt(input[4]);

            swapIndex(row1, col1, row2, col2);

            input = scanner.nextLine().split("\\s+");
        }

    }

    private static void swapIndex(int row1, int col1, int row2, int col2) {
        try {
            String firstIndex = matrix[row1][col1];
            String secondIndex = matrix[row2][col2];
            for (int r = 0; r < matrix.length; r++) {
                for (int c = 0; c < matrix[r].length; c++) {

                    if (r == row1 && c == col1) {
                        matrix[r][c] = secondIndex;
                        System.out.print(secondIndex + " ");
                    } else if (r == row2 && c == col2) {
                        System.out.print(firstIndex + " ");
                        matrix[r][c] = firstIndex;
                    } else {
                        System.out.print(matrix[r][c] + " ");
                    }

                }
                System.out.println();
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid input!");
        }


    }

    private static String[][] fillMatrix(Scanner scanner) {
        String[] input = scanner.nextLine().split(" ");
        int rows = Integer.parseInt(input[0]);
        int cols = Integer.parseInt(input[1]);

        String[][] matrix = new String[rows][cols];

        for (int i = 0; i < rows; i++) {
            String[] rowsData = scanner.nextLine().split(" ");

            matrix[i] = rowsData;
        }
        return matrix;
    }
}
