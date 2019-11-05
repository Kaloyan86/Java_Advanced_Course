package FUNCTIONAL_PROGRAMMING.Exercises;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lab9ListOfPredicates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int[] dividedNumbers = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        List<Integer> numbers = IntStream.rangeClosed(1, n).boxed().collect(Collectors.toList());

        Predicate<Integer> check = (x -> {
            for (int dividedNumber : dividedNumbers) {
                if (x == 0) {
                    continue;
                }
                if (x % dividedNumber != 0) {
                    return false;
                }
            }
            return true;

        });
        numbers.forEach(e -> {
            if (check.test(e)) {
                System.out.printf("%d ", e);
            }
        });

    }
}
