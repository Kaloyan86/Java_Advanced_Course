package FUNCTIONAL_PROGRAMMING.Lab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Lab1SortEvenNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] numbers = scanner.nextLine().split(", ");

        List<String> evenNumbers = Arrays.stream(numbers).map(Integer::parseInt)
                .filter(x -> x % 2 == 0)
                .map(String::valueOf)
                .collect(Collectors.toList());

        System.out.println(String.join(", ", evenNumbers));

        List<String> sortedNumbers = evenNumbers.stream().map(Integer::parseInt)
                .sorted(Integer::compare)
                .map(String::valueOf)
                .collect(Collectors.toList());

        System.out.println(String.join(", ", sortedNumbers));
    }
}
