package FUNCTIONAL_PROGRAMMING.Exercises;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Lab5ReverseAndExclude {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

        int numb = Integer.parseInt(scanner.nextLine());
        Predicate<Integer> isDivisible = x -> x % numb != 0;
        List<Integer> nonDivisible = numbers.stream().filter(isDivisible).collect(Collectors.toList());
        Collections.reverse(nonDivisible);
        nonDivisible.forEach(e -> System.out.print(e + " "));


    }
}
