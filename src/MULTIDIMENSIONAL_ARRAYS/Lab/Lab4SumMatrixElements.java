package MULTIDIMENSIONAL_ARRAYS.Lab;

import java.util.Arrays;
import java.util.Scanner;

public class Lab4SumMatrixElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[][] matrix = fillMatrix(scanner);
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            sum += Arrays.stream(matrix[i]).sum();
        }
        System.out.println(String.format("%d\n%d\n%d",matrix.length,matrix[0].length,sum));
    }

    private static int[][] fillMatrix(Scanner scanner) {
        int[] rowsCols = Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt).toArray();
        int rows = rowsCols[0];
        int cols = rowsCols[1];

        int matrix[][] = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            int[] rowsData = Arrays.stream(scanner.nextLine().split(", "))
                    .mapToInt(Integer::parseInt).toArray();

            matrix[i] = rowsData;
        }
        return matrix;
    }
}
