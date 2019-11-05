package MULTIDIMENSIONAL_ARRAYS.Exercises;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Ex6StringMatrixRotation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] rotateData = scanner.nextLine().split("[()]+");

        int rotateAngle = Integer.parseInt(rotateData[1]) % 360;

        ArrayList<String> inputStrings = new ArrayList<>();

        String line = scanner.nextLine();

        int maxLength = line.length();

        while (!line.equals("END")) {
            inputStrings.add(line);
            line = scanner.nextLine();
            if (maxLength < line.length()) {
                maxLength = line.length();
            }
        }
        char[][] matrix = fillMatrix(inputStrings, maxLength);

        if (rotateAngle == 90) {

            for (int col = 0; col < maxLength; col++) {
                for (int row = matrix.length - 1; row >= 0; row--) {
                    System.out.print(matrix[row][col]);
                }
                System.out.println();
            }
        } else if (rotateAngle == 180) {
            for (int row = matrix.length - 1; row >= 0; row--) {
                for (int col = maxLength - 1; col >= 0; col--) {
                    System.out.print(matrix[row][col]);
                }
                System.out.println();
            }
        } else if (rotateAngle == 270) {
            for (int col = maxLength - 1; col >= 0; col--) {
                for (int row = 0; row < matrix.length; row++) {
                    System.out.print(matrix[row][col]);
                }
                System.out.println();
            }
        }else {
            printMatrix(matrix);
        }
    }

    private static void printMatrix(char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }

    private static char[][] fillMatrix(ArrayList<String> inputString, int maxLength) {

        int rows = inputString.size();
        int cols = maxLength;

        char[][] matrix = new char[rows][cols];

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {

                if (c > inputString.get(r).length() - 1) {
                    matrix[r][c] = ' ';
                } else {
                    matrix[r][c] = inputString.get(r).charAt(c);
                }
            }


        }
        return matrix;
    }
}
