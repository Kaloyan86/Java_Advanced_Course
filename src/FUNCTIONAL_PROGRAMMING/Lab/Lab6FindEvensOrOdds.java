package FUNCTIONAL_PROGRAMMING.Lab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lab6FindEvensOrOdds {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] num = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

//        List<Integer> numbers = new ArrayList<>();
//        for (int i = num[0]; i <= num[1]; i++) {
//            numbers.add(i);
//
//        }

        Predicate<Integer> even = x -> x % 2 == 0;
        Predicate<Integer> filter = x -> x % 2 != 0;

        String command = scanner.nextLine();
        if (command.equals("even")) {
            filter = even;
        }
        IntStream.rangeClosed(num[0], num[1]).boxed()
                .filter(filter).forEach(e -> System.out.print(e + " "));

    }
}
