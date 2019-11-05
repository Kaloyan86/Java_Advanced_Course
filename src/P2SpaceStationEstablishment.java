import java.util.Scanner;

public class P2SpaceStationEstablishment {
    public static char[][] field;
    public static int rowStephan, colStephan;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());


        rowStephan = 0;
        colStephan = 0;
        int stars = 0;
        field = new char[rows][];

        int blackHoles = 0;

        int black1row = 0;
        int black1col = 0;
        int black2row = 0;
        int black2col = 0;


        for (int i = 0; i < rows; i++) {
            String line = scanner.nextLine();
            for (int j = 0; j < line.length(); j++) {
                if (line.charAt(j) == 'S') {
                    rowStephan = i;
                    colStephan = j;
                }
                if (line.charAt(j) == 'O') {
                    blackHoles += 1;
                    if (blackHoles == 2) {
                        black2row = i;
                        black2col = j;

                    } else {
                        black1row = i;
                        black1col = j;
                    }
                }

            }
            field[i] = line.toCharArray();

        }
        boolean isOut = true;
        boolean isWin = false;
        while (isOut) {
            String direction = scanner.nextLine();
            switch (direction) {
                case "up":
                    if (isInTheGalaxy(rowStephan - 1, colStephan, field)) {
                        field[rowStephan][colStephan] = '-';
                        isOut = false;
                        break;
                    }
                    if (field[rowStephan - 1][colStephan] != 'O') {
                        if (Character.isDigit(field[rowStephan - 1][colStephan])) {
                            field[rowStephan][colStephan] = '-';
                            String star = String.valueOf(field[rowStephan - 1][colStephan]);
                            stars += Integer.parseInt(star);
                            field[rowStephan - 1][colStephan] = 'S';
                            rowStephan -= 1;

                        } else {
                            field[rowStephan][colStephan] = '-';
                            field[rowStephan - 1][colStephan] = 'S';
                            rowStephan -= 1;
                        }
                    } else {
                        field[rowStephan][colStephan] = '-';
                        field[rowStephan - 1][colStephan] = 'S';
                        rowStephan -= 1;
                        ifIs2BlackHoles(blackHoles, black1row, black1col, black2row, black2col);
                    }
                    break;
                case "down":
                    if (isInTheGalaxy(rowStephan + 1, colStephan, field)) {
                        field[rowStephan][colStephan] = '-';
                        isOut = false;
                        break;
                    }
                    if (field[rowStephan + 1][colStephan] != 'O') {
                        if (Character.isDigit(field[rowStephan + 1][colStephan])) {
                            field[rowStephan][colStephan] = '-';
                            String star = String.valueOf(field[rowStephan + 1][colStephan]);
                            stars += Integer.parseInt(star);
                            field[rowStephan + 1][colStephan] = 'S';
                            rowStephan += 1;

                        } else {
                            field[rowStephan][colStephan] = '-';
                            field[rowStephan + 1][colStephan] = 'S';
                            rowStephan += 1;
                        }
                    } else {
                        field[rowStephan][colStephan] = '-';
                        field[rowStephan + 1][colStephan] = 'S';
                        rowStephan += 1;
                        ifIs2BlackHoles(blackHoles, black1row, black1col, black2row, black2col);


                    }

                    break;
                case "left":
                    if (isInTheGalaxy(rowStephan, colStephan - 1, field)) {
                        field[rowStephan][colStephan] = '-';
                        isOut = false;
                        break;
                    }
                    if (field[rowStephan][colStephan - 1] != 'O') {
                        if (Character.isDigit(field[rowStephan][colStephan - 1])) {
                            field[rowStephan][colStephan] = '-';
                            String star = String.valueOf(field[rowStephan][colStephan - 1]);
                            stars += Integer.parseInt(star);
                            field[rowStephan][colStephan - 1] = 'S';
                            colStephan -= 1;

                        } else {
                            field[rowStephan][colStephan] = '-';
                            field[rowStephan][colStephan - 1] = 'S';
                            colStephan -= 1;
                        }
                    } else {
                        field[rowStephan][colStephan] = '-';
                        field[rowStephan][colStephan - 1] = 'S';
                        colStephan -= 1;
                        ifIs2BlackHoles(blackHoles, black1row, black1col, black2row, black2col);


                    }
                    break;
                case "right":
                    if (isInTheGalaxy(rowStephan, colStephan + 1, field)) {
                        field[rowStephan][colStephan] = '-';
                        isOut = false;
                        break;
                    }
                    if (field[rowStephan][colStephan + 1] != 'O') {
                        if (Character.isDigit(field[rowStephan][colStephan + 1])) {
                            field[rowStephan][colStephan] = '-';
                            String star = String.valueOf(field[rowStephan][colStephan + 1]);
                            stars += Integer.parseInt(star);
                            field[rowStephan][colStephan + 1] = 'S';
                            colStephan += 1;

                        } else {
                            field[rowStephan][colStephan] = '-';
                            field[rowStephan][colStephan + 1] = 'S';
                            colStephan += 1;
                        }
                    } else {
                        field[rowStephan][colStephan] = '-';
                        field[rowStephan][colStephan + 1] = 'S';
                        colStephan += 1;
                        ifIs2BlackHoles(blackHoles, black1row, black1col, black2row, black2col);


                    }
                    break;
            }


            if (stars >= 50) {
                isWin = true;
                break;
            }
        }
        if (isWin) {
            System.out.println("Good news! Stephen succeeded in collecting enough star power!");

        } else {
            System.out.println("Bad news, the spaceship went to the void.");
        }
        System.out.println("Star power collected: " + stars);

        printMatrix(field);

    }

    private static void ifIs2BlackHoles(int blackHoles, int black1row, int black1col, int black2row, int black2col) {
        if (blackHoles == 2) {
            field[rowStephan][colStephan] = '-';
            if (rowStephan == black1row && colStephan == black1col) {
                field[black2row][black2col] = 'S';
                rowStephan = black2row;
                colStephan = black2col;
            } else {
                field[black1row][black1col] = 'S';
                rowStephan = black1row;
                colStephan = black1col;
            }
        }
    }

    private static boolean isInTheGalaxy(int newRow, int newCol, char[][] field) {
        return newRow < 0 || newRow >= field.length || newCol < 0 || newCol >= field[newRow].length;
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
