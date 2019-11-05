package StacksAndQueues.Exercises;

import java.util.Scanner;

public class Ex7RecursiveFibonacci {
    private static long[] memory;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        memory = new long[n + 1];
        long result = fibo(n);
        System.out.println(result);
    }

    private static long fibo(int n) {

        if (n < 2) {
            return 1;
        }
        if (memory[n] != 0) {
            return memory[n];
        }
        return memory[n] = fibo(n - 1) + fibo(n - 2);
    }
}
