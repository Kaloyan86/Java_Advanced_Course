package StacksAndQueues.Exercises;

import java.util.*;

public class Ex2BasicStackOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String[] tokens = scanner.nextLine().split("\\s+");
        int limitNum = Integer.parseInt(tokens[0]);
        int numOfPops = Integer.parseInt(tokens[1]);
        int numMatch = Integer.parseInt(tokens[2]);
        ArrayDeque<Integer> numbers = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt)
                .limit(limitNum)
                .forEach(numbers::push);


        for (int i = 0; i < numOfPops; i++) {
            numbers.pop();
        }
        if (numbers.contains(numMatch)) {
            System.out.println("true");
        } else {
            if (numbers.size() == 0) {
                System.out.println(0);
            } else {
                //System.out.println(Collections.min(numbers));
                int min = Integer.MAX_VALUE;
                while (!numbers.isEmpty()) {
                    int num = numbers.pop();
                    if (min > num){
                        min = num;
                    }
                }
                System.out.println(min);
            }
        }
    }
}
