package StacksAndQueues.Exercises;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class Ex1ReverseNumbersWithAStack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // LIFO => ArrayDeque (pop () , push () , peek () )
        // FIFO => ArrayDeque (poll () , offer () , peek () )

        ArrayDeque<String> stack = new ArrayDeque<>();
        String exp = scanner.nextLine();
        Arrays.stream(exp.split("\\s+")).forEach(stack::push);

        stack.forEach(e -> System.out.print(stack.pop() + " "));

    }
}
