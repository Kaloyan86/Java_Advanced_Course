package MULTIDIMENSIONAL_ARRAYS.Lab;

import java.util.Arrays;
import java.util.Scanner;

public class Lab2PositionsOf {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[][] matrix = fillMatrix(scanner);
        int num = Integer.parseInt(scanner.nextLine());
        boolean isFound = false;

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                if (num == matrix[row][col]) {
                    System.out.println(row + " " + col);
                    isFound = true;
                }
            }

        }
        if (!isFound){
            System.out.println("not found");
        }
    }

    private static int[][] fillMatrix(Scanner scanner) {
        int[] rowsCols = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
        int rows = rowsCols[0];
        int cols = rowsCols[1];

        int matrix[][] = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            int[] rowsData = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt).toArray();

            matrix[i] = rowsData;
        }
        return matrix;
    }
}
