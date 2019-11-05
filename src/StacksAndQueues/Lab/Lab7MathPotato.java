package StacksAndQueues.Lab;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class Lab7MathPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> queue = new ArrayDeque<>();
        String input = scanner.nextLine();
        int n = Integer.parseInt(scanner.nextLine());

        Arrays.stream(input.split("\\s+")).forEach(queue::offer);
        int round = 1;
        while (queue.size() > 1) {
            for (int i = 1; i < n; i++) {
                queue.offer(queue.poll());
            }
            if (isPrime(round)){
                System.out.println("Prime " + queue.peek());
            }else {
                System.out.println("Removed " + queue.poll());
            }
            round ++;
        }
        System.out.println("Last is " + queue.peek());
    }

    private static boolean isPrime(int round) {
        if (round == 1){
            return false;
        }
        for (int i = 2; i < round; i++) {
            if (round % i == 0){
                return false;
            }
        }
        return true;

    }
}
