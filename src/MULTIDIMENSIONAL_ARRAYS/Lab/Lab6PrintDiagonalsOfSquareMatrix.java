package MULTIDIMENSIONAL_ARRAYS.Lab;

import java.util.Arrays;
import java.util.Scanner;

public class Lab6PrintDiagonalsOfSquareMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[][] square = fillMatrix(scanner);

        for (int row = 0; row < square.length; row++) {

            System.out.print(square[row][row] + " ");

        }
        System.out.println();
        for (int row = square.length - 1; row >= 0; row--) {

            System.out.print(square[row][square.length - row-1] + " ");

        }
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
