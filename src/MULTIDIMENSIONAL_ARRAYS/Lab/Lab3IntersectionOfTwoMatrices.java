package MULTIDIMENSIONAL_ARRAYS.Lab;

import java.util.Arrays;
import java.util.Scanner;

public class Lab3IntersectionOfTwoMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());
        int cols = Integer.parseInt(scanner.nextLine());

        char[][] firstMatrix = fillMatrix(scanner, rows, cols);
        char[][] secondMatrix = fillMatrix(scanner, rows, cols);


        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (firstMatrix[i][j] == secondMatrix[i][j]) {

                    System.out.print(firstMatrix[i][j] + " ");
                } else {

                    System.out.print("* ");
                }
            }
            System.out.println();
        }

    }

    private static char[][] fillMatrix(Scanner scanner, int rows, int cols) {


        char matrix[][] = new char[rows][cols];

        for (int i = 0; i < rows; i++) {
            String[] line = scanner.nextLine().split("\\s+");
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = line[j].charAt(0);
            }
        }
        return matrix;
    }
}
