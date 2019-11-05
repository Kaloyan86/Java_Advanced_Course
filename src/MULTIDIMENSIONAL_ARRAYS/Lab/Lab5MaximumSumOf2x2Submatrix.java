package MULTIDIMENSIONAL_ARRAYS.Lab;

import java.util.Arrays;
import java.util.Scanner;

public class Lab5MaximumSumOf2x2Submatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[][] matrix = fillMatrix(scanner);
        int maxSum = Integer.MIN_VALUE;
        int maxRow = -1 , maxCol  = -1;
        for (int i = 0; i < matrix.length - 1; i++) {
            for (int j = 0; j < matrix[0].length - 1; j++) {
                int currentSum = sumFromTopLeft(matrix, i, j);

                if (currentSum > maxSum) {
                    maxSum = currentSum;
                    maxRow = i;
                    maxCol = j;
                }
            }
        }
        System.out.printf("%d %d\n%d %d\n%d",matrix[maxRow][maxCol],matrix[maxRow][maxCol+1],
                matrix[maxRow+1][maxCol],
                matrix[maxRow+1][maxCol+1],
                maxSum);
    }

    private static int sumFromTopLeft(int[][] matrix, int row, int col) {
        return matrix[row][col] +
                matrix[row + 1][col] +
                matrix[row + 1][col + 1] +
                matrix[row][col + 1];
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
