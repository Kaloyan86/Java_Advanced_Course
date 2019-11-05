package StacksAndQueues.Exercises;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Ex4BasicQueueOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] cmd = scanner.nextLine().split("\\s+");
        int limitNum = Integer.parseInt(cmd[0]);
        int numOfPolls = Integer.parseInt(cmd[1]);
        int matchNum = Integer.parseInt(cmd[2]);

        ArrayDeque<Integer> numbers = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt)
                .limit(limitNum)
                .forEach(numbers::offer);

        for (int i = 0; i < numOfPolls; i++) {
            numbers.poll();
        }
        if (numbers.contains(matchNum)) {
            System.out.println(true);
        } else {
            if (numbers.isEmpty()) {
                System.out.println(0);
            } else {
                System.out.println(Collections.min(numbers));
            }
        }
    }
}
