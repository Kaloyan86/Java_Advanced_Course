package FUNCTIONAL_PROGRAMMING.Exercises;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Lab6PredicateForNames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numb = Integer.parseInt(scanner.nextLine());

        List<String> words = Arrays.stream(scanner.nextLine().split("\\s+"))
                .collect(Collectors.toList());


        Predicate<String> isLengthCorrect = x -> x.length() <= numb;
        words.stream().filter(isLengthCorrect).forEach(System.out::println);
    }
}
