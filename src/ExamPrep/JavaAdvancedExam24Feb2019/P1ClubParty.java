package ExamPrep.JavaAdvancedExam24Feb2019;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class P1ClubParty {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        //  stack => LIFO => ArrayDeque (pop () , push () , peek () )
        // queue => FIFO => ArrayDeque (poll () , offer () , peek () )

        int capacity = Integer.parseInt(scanner.nextLine());
        ArrayDeque<String> queue = new ArrayDeque<>();
        String input = scanner.nextLine();

        String[] data = input.split("\\s+");
        List<Integer> numOfPeople = new LinkedList<>();

        for (int i = data.length - 1; i >= 0; i--) {
            if (Character.isDigit(data[i].charAt(0))) {
                if (queue.isEmpty()) {
                    continue;
                }
                int currentReservation = Integer.parseInt(data[i]);
                int sum = numOfPeople.stream().mapToInt(x -> x).sum();
                if (currentReservation > capacity) {
                    continue;
                }
                if (currentReservation + sum <= capacity) {
                    numOfPeople.add(Integer.parseInt(data[i]));

                } else {
                    print(queue.poll(), numOfPeople);
                    numOfPeople.clear();
                    i++;
                }
            } else {
                queue.offer(data[i]);
            }
        }


    }

    public static void print(String poll, List<Integer> numOfPeople) {
        System.out.print(poll + " -> ");
        System.out.println(numOfPeople.stream()
                .map(String::valueOf).collect(Collectors.joining(", ")));
    }
}
