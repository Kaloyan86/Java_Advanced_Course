package MULTIDIMENSIONAL_ARRAYS.Lab;

import java.util.Arrays;
import java.util.Scanner;

public class Lab1CompareMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int [][] firstMatrix = fillMatrix(scanner);
        int [][] secondMatrix = fillMatrix(scanner);

        isEqual(firstMatrix,secondMatrix);
    }

    private static void isEqual(int[][] firstMatrix, int[][] secondMatrix) {
        if (firstMatrix.length != secondMatrix.length ||
        firstMatrix[0].length != secondMatrix[0].length){
            System.out.println("not equal");
            return;
        }
        for (int row = 0; row < firstMatrix.length; row++) {
            for (int col = 0; col < secondMatrix[0].length; col++) {
                if (firstMatrix[row][col] != secondMatrix[row][col]){
                    System.out.println("not equal");
                    return;
                }
            }
        }
        System.out.println("equal");
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

           matrix [i] = rowsData;
        }
        return matrix;
    }
}
