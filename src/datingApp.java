import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class datingApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> males = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).forEach(males::push);
        ArrayDeque<Integer> females = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).forEach(females::offer);

        // LIFO => ArrayDeque (pop () , push () , peek () )
        // FIFO => ArrayDeque (poll () , offer () , peek () )

        int matches = 0;
        while (!males.isEmpty() && !females.isEmpty()) {
            if (females.peek() <= 0) {
                females.poll();

            } else if (males.peek() <= 0) {
                males.pop();

            } else if (females.peek() % 25 == 0) {
                females.poll();
                females.poll();

            } else if (males.peek() % 25 == 0) {
                males.pop();
                males.pop();

            } else if (females.peek().equals(males.peek())) {
                matches++;
                females.poll();
                males.pop();
            } else {
                females.pop();
                int temp = males.pop();
                males.push(temp - 2);
            }

        }


        System.out.printf("Matches: %d\n", matches);

        if (males.size() == 0) {
            System.out.println("Males left: none");
        } else {
            System.out.print("Males left: ");
            System.out.print(males.toString().replaceAll("[\\[\\]]", ""));
            System.out.println();
        }

        if (females.size() == 0) {
            System.out.println("Females left: none");
        } else {
            System.out.print("Females left: ");
            System.out.print(females.toString().replaceAll("[\\[\\]]", ""));
        }

    }
}
