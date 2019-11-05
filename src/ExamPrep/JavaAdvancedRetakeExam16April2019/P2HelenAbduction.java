package ExamPrep.JavaAdvancedRetakeExam16April2019;

import java.util.Scanner;

public class P2HelenAbduction {

    public static char[][] field;
    public static int rowP, colP;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int power = Integer.parseInt(scanner.nextLine());
        int rows = Integer.parseInt(scanner.nextLine());

        int rowH = 0;
        int colH = 0;

        int rowS = 0;
        int colS = 0;

        rowP = 0;
        colP = 0;

        field = new char[rows][];


        for (int i = 0; i < rows; i++) {
            String line = scanner.nextLine();
            for (int j = 0; j < line.length(); j++) {
                if (line.charAt(j) == 'H') {
                    rowH = i;
                    colH = j;
                }
                if (line.charAt(j) == 'P') {
                    rowP = i;
                    colP = j;
                }

            }
            field[i] = line.toCharArray();

        }

        boolean isAbducted = false;
        while (power > 0 && !isAbducted) {
            power -= 1;
            String direction = scanner.next();
            rowS = scanner.nextInt();
            colS = scanner.nextInt();
            field[rowS][colS] = 'S';
            field[rowP][colP] = '-';
            switch (direction) {
                case "up":
                    if (canMove(rowP - 1, colP, field)) {

                        rowP--;
                        if (field[rowP][colP] == 'S') {
                            power -= 2;
                        } else if (field[rowP][colP] == 'H') {
                            isAbducted = true;
                        }

                    }
                    break;
                case "down":
                    if (canMove(rowP + 1, colP, field)) {
                        rowP++;
                        if (field[rowP][colP] == 'S') {
                            power -= 2;
                        } else if (field[rowP][colP] == 'H') {
                            isAbducted = true;
                        }

                    }
                    break;
                case "left":
                    if (canMove(rowP, colP - 1, field)) {

                        colP--;
                        if (field[rowP][colP] == 'S') {
                            power -= 2;
                        } else if (field[rowP][colP] == 'H') {
                            isAbducted = true;
                        }

                    }
                    break;
                case "right":
                    if (canMove(rowP, colP + 1, field)) {

                        colP++;
                        if (field[rowP][colP] == 'S') {
                            power -= 2;
                        } else if (field[rowP][colP] == 'H') {
                            isAbducted = true;
                        }

                    }
                    break;
            }

            field[rowP][colP] = 'P';
        }
        if (!isAbducted) {
            field[rowP][colP] = 'X';
            System.out.printf("Paris died at %d;%d.\n", rowP, colP);
        } else {
            field[rowP][colP] = '-';
            System.out.print("Paris has successfully abducted Helen! ");
            System.out.printf("Energy left: %d\n", power);
        }
        printMatrix(field);


    }

    private static boolean canMove(int newRow, int newCol, char[][] field) {
        return newRow >= 0 && newRow < field.length && newCol >= 0 && newCol < field[newRow].length;
    }


    private static void printMatrix(char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }
}
