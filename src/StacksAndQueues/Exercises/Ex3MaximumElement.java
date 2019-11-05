package StacksAndQueues.Exercises;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class Ex3MaximumElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        ArrayDeque<Integer> numbers = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            String[] cmd = input.split("\\s+");
            String command = cmd[0];
            switch (command){
                case "1":
                    int element = Integer.parseInt(cmd[1]);
                    numbers.push(element);
                    break;
                case "2":
                    numbers.pop();
                    break;
                case "3":
                    System.out.println(Collections.max(numbers));
                    break;
            }

        }
    }
}
