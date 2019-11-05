package MULTIDIMENSIONAL_ARRAYS.Exercises;

import java.util.Scanner;

public class Ex2MatrixOfPalindromes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String[][] palindromMatrix = palindromMatrix(scanner);
        printMatrix(palindromMatrix);
    }

    private static String[][] palindromMatrix(Scanner scanner) {
        String[] input = scanner.nextLine().split(" ");
        int rows = Integer.parseInt(input[0]);
        int cols = Integer.parseInt(input[1]);
        String[][] matrix = new String[rows][cols];
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                String element = "" + (char) ('a' + row) + (char) ('a' + row + col) + (char) ('a' + row);
                matrix[row][col] = element;
            }
        }
        return matrix;
    }

    private static void printMatrix(String[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}
