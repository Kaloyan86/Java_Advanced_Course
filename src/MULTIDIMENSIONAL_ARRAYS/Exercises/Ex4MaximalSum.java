package MULTIDIMENSIONAL_ARRAYS.Exercises;

import java.util.Arrays;
import java.util.Scanner;

public class Ex4MaximalSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[][] matrix = fillMatrix(scanner);
        maxSumOfMatrix3x3(matrix);
    }

    private static void printMatrix(int[][] matrix, int rowIndex, int colIndex) {
        for (int row = rowIndex-1; row < rowIndex+3-1; row++) {
            for (int col = colIndex-1; col < colIndex+3-1; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    private static void maxSumOfMatrix3x3(int[][] matrix) {
        int maxSum = Integer.MIN_VALUE;
        int rowIndex = -1;
        int colIndex = -1;
        for (int row = 1; row < matrix.length - 1; row++) {
            for (int col = 1; col < matrix[row].length - 1; col++) {
                int currentSum = getMatrixSum(matrix, row, col);
                if (maxSum < currentSum) {
                    maxSum = currentSum;
                    rowIndex = row;
                    colIndex = col;
                }
            }
        }
        System.out.println("Sum = "+maxSum);
        printMatrix(matrix, rowIndex, colIndex);
    }

    private static int getMatrixSum(int[][] matrix, int row, int col) {
        int sum = 0;
        sum += matrix[row][col];
        sum += matrix[row - 1][col];
        sum += matrix[row + 1][col];
        sum += matrix[row][col - 1];
        sum += matrix[row][col + 1];
        sum += matrix[row + 1][col + 1];
        sum += matrix[row - 1][col - 1];
        sum += matrix[row - 1][col + 1];
        sum += matrix[row + 1][col - 1];


        return sum;
    }

    private static int[][] fillMatrix(Scanner scanner) {
        String[] input = scanner.nextLine().split(" ");
        int rows = Integer.parseInt(input[0]);
        int cols = Integer.parseInt(input[1]);

        int[][] matrix = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            int[] rowsData = Arrays.stream(scanner.nextLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();

            matrix[i] = rowsData;
        }
        return matrix;
    }
}
