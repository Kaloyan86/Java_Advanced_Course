package ExamPrep.DemoJavaAdvancedExam16June2019;

import java.util.Arrays;
import java.util.Scanner;

public class P1TheGarden {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());
        String[][] field = new String[rows][];
        int carrots = 0;
        int potatoes = 0;
        int lettuce = 0;
        int harmed = 0;

        for (int i = 0; i < rows; i++) {
            field[i] = scanner.nextLine().split("\\s+");
        }
        String line = scanner.nextLine();
        while (!line.equals("End of Harvest")) {
            String[] cmd = line.split("\\s+");

            int row = Integer.parseInt(cmd[1]);
            int col = Integer.parseInt(cmd[2]);

            if (cmd[0].equals("Harvest") && inBounds(row, col, field)) {
                if (field[row][col].equals("L")) {
                    lettuce += 1;
                    field[row][col] = " ";
                } else if (field[row][col].equals("P")) {
                    potatoes += 1;
                    field[row][col] = " ";
                } else if (field[row][col].equals("C")) {
                    carrots += 1;
                    field[row][col] = " ";
                }

            } else if (cmd[0].equals("Mole") && inBounds(row, col, field)) {
                if (!field[row][col].equals(" ")) {
                    field[row][col] = " ";
                    harmed = 1;
                }

                String direction = cmd[3];

                if (direction.equals("up")) {
                    for (int i = row; i >= 0; i -= 2) {
                        if (!field[i][col].equals(" ")) {
                            field[i][col] = " ";
                            harmed++;
                        }
                    }
                } else if (direction.equals("down")) {
                    for (int i = row; i < field.length; i += 2) {
                        if (!field[i][col].equals(" ")) {
                            field[i][col] = " ";
                            harmed++;
                        }
                    }
                } else if (direction.equals("left")) {
                    for (int i = col; i >= 0; i -= 2) {
                        if (!field[row][i].equals(" ")) {
                            field[row][i] = " ";
                            harmed++;
                        }
                    }
                } else if (direction.equals("right")) {
                    for (int i = col; i < field[row].length; i += 2) {
                        if (!field[row][i].equals(" ")) {
                            field[row][i] = " ";
                            harmed++;
                        }
                    }


                }


            }


            line = scanner.nextLine();
        }
        printMatrix(field);
        System.out.printf("Carrots: %d\n" +
                "Potatoes: %d\n" +
                "Lettuce: %d\n" +
                "Harmed vegetables: %d", carrots, potatoes, lettuce, harmed);
    }

    private static void move(int row, int col, String direction) {


    }

    private static boolean inBounds(int r, int c, String[][] field) {
        return r >= 0 && r < field.length && c >= 0 && c < field[r].length;
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
