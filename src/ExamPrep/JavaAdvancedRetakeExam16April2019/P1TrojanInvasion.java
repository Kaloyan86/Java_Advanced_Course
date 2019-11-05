package ExamPrep.JavaAdvancedRetakeExam16April2019;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class P1TrojanInvasion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //  stack => LIFO => ArrayDeque (pop () , push () , peek () )
        // queue => FIFO => ArrayDeque (poll () , offer () , peek () )

        ArrayDeque<Integer> defense = new ArrayDeque<>();
        ArrayDeque<Integer> attack = new ArrayDeque<>();

        int n = Integer.parseInt(scanner.nextLine());

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).forEach(defense::offer);


        for (int i = 1; i <= n && !defense.isEmpty(); i++) {

            Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt).forEach(attack::push);

            if (i % 3 == 0) {
                int additionalDefender = Integer.parseInt(scanner.nextLine());
                defense.offer(additionalDefender);
            }

            while (!defense.isEmpty() && !attack.isEmpty()) {

                int atacker = attack.pop();

                int defender = defense.poll();

                if (atacker > defender) {
                    atacker -= defender;
                    attack.push(atacker);
                } else if (atacker < defender) {
                    defender -= atacker;
                    defense.addFirst(defender);
                }
            }

        }
        if (defense.isEmpty()) {
            System.out.println("The Trojans successfully destroyed the Spartan defense.");
            System.out.printf("Warriors left: %s\n", attack.toString().replaceAll("[\\[\\]]", ""));
        } else {
            System.out.println("The Spartans successfully repulsed the Trojan attack.");
            System.out.printf("Plates left: %s\n",defense.toString().replaceAll("[\\[\\]]", ""));
        }
    }
}
