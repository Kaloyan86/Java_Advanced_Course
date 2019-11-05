package StacksAndQueues.Lab;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class Lab6HotPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // LIFO => ArrayDeque (pop () , push () , peek () )
        // FIFO => ArrayDeque (poll () , offer () , peek () )


        ArrayDeque<String> queue = new ArrayDeque<>();
        String input = scanner.nextLine();
        int n = Integer.parseInt(scanner.nextLine());

        Arrays.stream(input.split("\\s+")).forEach(queue::offer);

        while (queue.size() > 1) {
            for (int i = 1; i < n; i++) {
                queue.offer(queue.poll());
            }
            System.out.println("Removed " + queue.poll());
        }
        System.out.println("Last is "+queue.peek());
    }
}
