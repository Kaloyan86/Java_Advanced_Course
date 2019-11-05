package FUNCTIONAL_PROGRAMMING.Exercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Lab7FindTheSmallestElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayList::new));

        Function<List<Integer>, Integer> findIndexOfMin = (arr -> {
            int min = arr.stream().min(Integer::compareTo).get();
            return arr.lastIndexOf(min);
        });
        System.out.println(findIndexOfMin.apply(numbers));

    }
}
