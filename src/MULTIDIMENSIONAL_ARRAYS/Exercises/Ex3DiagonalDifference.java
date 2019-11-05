package MULTIDIMENSIONAL_ARRAYS.Exercises;

import java.util.Arrays;
import java.util.Scanner;

public class Ex3DiagonalDifference {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[][] square = fillMatrix(scanner);
        differenceBetweenDiagonals(square);

    }

    private static void differenceBetweenDiagonals(int[][] square) {
        int firstDiagonal = 0;
        int secondDiagonal = 0;
        for (int row = 0; row < square.length; row++) {

            firstDiagonal += square[row][row];

        }

        for (int row = square.length - 1; row >= 0; row--) {

            secondDiagonal += square[row][square.length - row - 1];

        }
        System.out.println(Math.abs(firstDiagonal - secondDiagonal));
    }

    private static int[][] fillMatrix(Scanner scanner) {

        int rows = Integer.parseInt(scanner.nextLine());
        int cols = rows;

        int[][] matrix = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            int[] rowsData = Arrays.stream(scanner.nextLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();

            matrix[i] = rowsData;
        }
        return matrix;
    }
}
