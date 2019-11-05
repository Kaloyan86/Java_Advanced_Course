import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class P1SpaceshipCrafting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int glass = 0;
        int aluminium = 0;
        int lithium = 0;
        int carbonFiber = 0;

        ArrayDeque<Integer> liquid = new ArrayDeque<>();
        ArrayDeque<Integer> physicItems = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).forEach(liquid::offer);

        Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).forEach(physicItems::push);


        while (!physicItems.isEmpty() && !liquid.isEmpty()) {
            int currentSum = physicItems.peek() + liquid.peek();
            if (currentSum == 25) {
                glass += 1;
                physicItems.pop();
                liquid.poll();
            } else if (currentSum == 50) {
                aluminium += 1;
                physicItems.pop();
                liquid.poll();
            } else if (currentSum == 75) {
                lithium += 1;
                physicItems.pop();
                liquid.poll();
            } else if (currentSum == 100) {
                carbonFiber += 1;
                physicItems.pop();
                liquid.poll();
            } else {

                liquid.poll();
                physicItems.push(physicItems.pop() + 3);

            }
        }


        System.out.println();
        if (glass > 0 && lithium > 0 && carbonFiber > 0 && aluminium > 0) {
            System.out.println("Wohoo! You succeeded in building the spaceship!");
        } else {
            System.out.println("Ugh, what a pity! You didn't have enough materials to build the spaceship.");
        }
        if (!liquid.isEmpty()) {
            System.out.print("Liquids left: ");
            System.out.print(liquid.toString().replaceAll("[\\[\\]]", ""));
            System.out.println();
        } else {
            System.out.println("Liquids left: none");
        }

        if (!physicItems.isEmpty()) {
            System.out.print("Physical items left: ");
            System.out.print(physicItems.toString().replaceAll("[\\[\\]]", ""));
            System.out.println();
        } else {
            System.out.println("Physical items left: none");
        }

        System.out.printf("Aluminium: %d\n" +
                "Carbon fiber: %d\n" +
                "Glass: %d\n" +
                "Lithium: %d\n", aluminium, carbonFiber, glass, lithium);
    }
}
