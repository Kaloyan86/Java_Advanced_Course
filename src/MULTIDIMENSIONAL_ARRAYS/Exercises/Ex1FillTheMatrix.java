package MULTIDIMENSIONAL_ARRAYS.Exercises;

import java.util.Arrays;
import java.util.Scanner;

public class Ex1FillTheMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(", ");

        int n = Integer.parseInt(input[0]);
        int[][] matrix = new int[n][n];
        String pattern = input[1];
        if (pattern.equals("A")) {
            matrix = A(n);
            printMatrix(matrix);
        } else {
            matrix = B(n);
            printMatrix(matrix);
        }
    }

    private static int[][] B(int n) {
        int rows = n;
        int cols = rows;

        int[][] matrix = new int[rows][cols];
        int value = 1;
        for (int col = 0; col < n; col++) {
            if (col % 2 == 0) {
                for (int row = 0; row < n; row++) {
                    matrix[row][col] = value++;
                }
            } else {
                for (int row = n-1; row >= 0; row--) {
                    matrix[row][col] = value++;
                }
            }


        }
        return matrix;

    }

    private static void printMatrix(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    private static int[][] A(int n) {

        int rows = n;
        int cols = rows;

        int[][] matrix = new int[rows][cols];
        int value = 1;
        for (int col = 0; col < n; col++) {
            for (int row = 0; row < n; row++) {
                matrix[row][col] = value++;
            }

        }
        return matrix;
    }
}
