package FUNCTIONAL_PROGRAMMING.Exercises;

import java.util.*;
import java.util.stream.Collectors;

public class Lab8CustomComparator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayList::new));

        Comparator<Integer> comparator = ((a, b) -> {
            if (a % 2 == 0 && b % 2 != 0) {
                return -1;
            } else if (b % 2 == 0 && a % 2 != 0) {
                return 1;
            }
            return a.compareTo(b);
        });
        numbers.stream().sorted(comparator).forEach(e -> System.out.print(e + " "));
    }
}
