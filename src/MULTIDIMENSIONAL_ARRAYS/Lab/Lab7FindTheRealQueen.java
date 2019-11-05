package MULTIDIMENSIONAL_ARRAYS.Lab;

import java.util.Scanner;

public class Lab7FindTheRealQueen {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char[][] chessBoard = fillMatrix(scanner);

        for (int row = 0; row < chessBoard.length; row++) {
            int count = 0;
            for (int col = 0; col < chessBoard[0].length; col++) {
                char symbol = chessBoard[row][col];
                if (symbol == 'q') {
                    if (isValidQueen(chessBoard, row, col)) {
                        System.out.println(row + " " + col);
                    } else {
                        count++;
                        if (count > 1) {
                            break;
                        }
                    }
                }
            }
        }
        System.out.println();
    }

    private static boolean isValidQueen(char[][] chessBoard, int row, int col) {
        if (isValidByColumn(chessBoard, row, col) && isValidByDiagonal(chessBoard, row, col)
                && isValidByRow(chessBoard, row, col)) {
            return true;
        }

        return false;
    }

    private static boolean isValidByRow(char[][] chessBoard, int row, int col) {
        int queenCount = 0;

        for (int i = 0; i < chessBoard.length; i++) {
            char currentChar = chessBoard[row][i];
            if (currentChar == 'q') {
                queenCount++;

            }
            if (queenCount > 1) {
                return false;
            }
        }

        return true;
    }

    private static boolean isValidByDiagonal(char[][] chessBoard, int row, int col) {
        char symbol = chessBoard[row][col];
        int queenCount = 0;

        for (int i = 0; row + i < chessBoard.length && col + i < chessBoard.length; i++) {
            if (chessBoard[row + i][col + i] == 'q') {
                queenCount++;
            }
            if (queenCount > 1) {
                return false;
            }
        }
        queenCount = 0;
        for (int i = 0; row + i < chessBoard.length && col - i >= 0; i++) {
            if (chessBoard[row + i][col - i] == 'q') {
                queenCount++;
            }
            if (queenCount > 1) {
                return false;
            }
        }
        queenCount = 0;

        for (int i = 0; row - i >= 0 && col - i >= 0; i++) {

            if (chessBoard[row - i][col - i] == 'q') {
                queenCount++;
            }

            if (queenCount > 1) {
                return false;
            }
        }
        queenCount = 0;
        for (int i = 0; row - i >= 0 && col + i < chessBoard.length; i++) {

            if (chessBoard[row - i][col + i] == 'q') {
                queenCount++;
            }

            if (queenCount > 1) {
                return false;
            }
        }
        return true;
    }

    private static boolean isValidByColumn(char[][] chessBoard, int row, int col) {
        int queenCount = 0;

        for (int i = 0; i < chessBoard.length; i++) {
            char currentChar = chessBoard[i][col];
            if (currentChar == 'q') {
                queenCount++;

            }
            if (queenCount > 1) {
                return false;
            }
        }

        return true;
    }

    private static char[][] fillMatrix(Scanner scanner) {


        char matrix[][] = new char[8][8];

        for (int i = 0; i < 8; i++) {
            String[] line = scanner.nextLine().split("\\s+");
            for (int j = 0; j < 8; j++) {
                matrix[i][j] = line[j].charAt(0);
            }
        }
        return matrix;
    }
}
