package FUNCTIONAL_PROGRAMMING.Lab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Lab2SumNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] split = scanner.nextLine().split(", ");
        Function<String, Integer> parse = Integer::parseInt;
        List<Integer> numbers = Arrays.stream(split).map(parse)
                .collect(Collectors.toList());
        System.out.println("Count = " + numbers.size());

        int sum = numbers.stream().reduce(0, (e1, e2) -> e1 + e2);

        System.out.println("Sum = " + sum);
    }
}
