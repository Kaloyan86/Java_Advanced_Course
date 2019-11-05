import java.util.ArrayList;
import java.util.Scanner;

public class bookWorm {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();
        int rows = Integer.parseInt(scanner.nextLine());
        ArrayList<String> inputStrings = new ArrayList<>();
        for (int i = 0; i < rows; i++) {
            inputStrings.add(scanner.nextLine());
        }

        char[][] field = fillMatrix(inputStrings, rows);


        int pRow = 0;
        int pCol = 0;

        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                if (field[i][j] == 'P') {
                    pRow = i;
                    pCol = j;
                    break;
                }
            }
        }
        String command = scanner.nextLine();
        while (!command.equals("end")) {

            switch (command) {
                case "up":
                    pRow--;
                    if (isInTheField(pRow, pCol, field)) {
                        if (field[pRow][pCol] != '-') {
                            text += field[pRow][pCol];
                            field[pRow][pCol] = 'P';
                            field[pRow + 1][pCol] = '-';
                        }else {
                            field[pRow][pCol] = 'P';
                            field[pRow + 1][pCol] = '-';
                        }
                    } else {
                        pRow++;
                        int end = text.length()-1;
                        text = text.substring(0,end);
                    }
                    break;
                case "down":
                    pRow++;
                    if (isInTheField(pRow, pCol, field)) {
                        if (field[pRow][pCol] != '-') {
                            text += field[pRow][pCol];
                            field[pRow][pCol] = 'P';
                            field[pRow - 1][pCol] = '-';
                        }else {
                            field[pRow][pCol] = 'P';
                            field[pRow - 1][pCol] = '-';
                        }
                    } else {
                        pRow--;
                        int end = text.length()-1;
                        text = text.substring(0,end);
                    }
                    break;
                case "left":
                    pCol--;
                    if (isInTheField(pRow, pCol, field)) {
                        if (field[pRow][pCol] != '-') {
                            text += field[pRow][pCol];
                            field[pRow][pCol] = 'P';
                            field[pRow][pCol + 1] = '-';
                        }
                        else {
                            field[pRow][pCol] = 'P';
                            field[pRow][pCol+1] = '-';
                        }
                    } else {
                        pCol++;
                        int end = text.length()-1;
                        text = text.substring(0,end);
                    }
                    break;
                case "right":
                    pCol++;
                    if (isInTheField(pRow, pCol, field)) {
                        if (field[pRow][pCol] != '-') {
                            text += field[pRow][pCol];
                            field[pRow][pCol] = 'P';
                            field[pRow][pCol - 1] = '-';
                        }else {
                            field[pRow][pCol] = 'P';
                            field[pRow][pCol-1] = '-';
                        }
                    } else {
                        pCol--;
                        int end = text.length()-1;
                       text = text.substring(0,end);
                    }
                    break;
            }

            command = scanner.nextLine();
        }
        System.out.println(text);
        printMatrix(field);
    }

    private static boolean isInTheField(int newRow, int newCol, char[][] field) {
        return newRow >= 0 && newRow < field.length && newCol >= 0 && newCol < field[newRow].length;
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
