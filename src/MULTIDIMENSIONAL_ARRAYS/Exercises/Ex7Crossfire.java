package MULTIDIMENSIONAL_ARRAYS.Exercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Ex7Crossfire {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<ArrayList<Integer>> matrix = fillMatrix(scanner);

        String line = scanner.nextLine();
        while (!line.equals("Nuke it from orbit")) {
            int[] coordinates = Arrays.stream(line.split("\\s+"))
                    .mapToInt(Integer::parseInt).toArray();

            int row = coordinates[0];
            int col = coordinates[1];
            int radius = coordinates[2];

            detonation(matrix, row, col, radius);

            line = scanner.nextLine();
        }
        printMatrix(matrix);
    }

    private static void printMatrix(ArrayList<ArrayList<Integer>> matrix) {
        for (int row = 0; row < matrix.size(); row++) {
            for (int col = 0; col < matrix.get(row).size(); col++) {
                System.out.print(matrix.get(row).get(col) + " ");
            }
            System.out.println();
        }
    }

    private static void detonation(ArrayList<ArrayList<Integer>> matrix, int row, int col, int radius) {

        for (int r = row - radius; r <= row + radius; r++) {
            if (isInBounds(matrix, r, col)) {
                matrix.get(r).set(col, 0);
            }
        }
        for (int c = col - radius; c <= col + radius; c++) {
            if (isInBounds(matrix, row, c)) {
                matrix.get(row).set(c, 0);
            }

        }
        for (int r = 0; r < matrix.size(); r++) {
            matrix.get(r).removeAll(new ArrayList<Integer>(){{add(0);}});
            if (matrix.get(r).size() == 0) {
                matrix.remove(r);
                r--;
            }

        }

    }

    private static boolean isInBounds(ArrayList<ArrayList<Integer>> matrix, int row, int col) {
        return row >= 0 &&
                row < matrix.size() &&
                col >= 0 &&
                col < matrix.get(row).size();
    }


    private static ArrayList<ArrayList<Integer>> fillMatrix(Scanner scanner) {
        String[] input = scanner.nextLine().split(" ");
        int rows = Integer.parseInt(input[0]);
        int cols = Integer.parseInt(input[1]);

        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
        int value = 1;
        for (int row = 0; row < rows; row++) {
            ArrayList<Integer> line = new ArrayList<>();
            for (int col = 0; col < cols; col++) {
                line.add(value);
                value++;
            }
            matrix.add(line);
        }
        return matrix;
    }
}
