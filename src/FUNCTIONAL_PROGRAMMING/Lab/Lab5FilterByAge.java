package FUNCTIONAL_PROGRAMMING.Lab;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Lab5FilterByAge {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, Integer> people = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split(", ");
            people.putIfAbsent(input[0], Integer.parseInt(input[1]));
        }

        String condition = scanner.nextLine();
        int age = Integer.parseInt(scanner.nextLine());
        String format = scanner.nextLine();

        BiPredicate<Map.Entry<String, Integer>, Integer> older = (person, ageLimit) -> person.getValue() >= ageLimit;
        BiPredicate<Map.Entry<String, Integer>, Integer> younger = (person, ageLimit) -> person.getValue() < ageLimit;

        Consumer<Map.Entry<String, Integer>> printName = person -> System.out.println(person.getKey());

        Consumer<Map.Entry<String, Integer>> printAge = person -> System.out.println(person.getValue());

        Consumer<Map.Entry<String, Integer>> print
                = person -> System.out.printf("%s - %d\n", person.getKey(), person.getValue());
        if (format.equals("age")) {
            print = printAge;
        } else if (format.equals("name")) {
            print = printName;
        }

        people.entrySet().stream().filter(p ->
                condition.equals("older") ? older.test(p, age)
                        : younger.test(p, age))
                .forEach(print);
    }
}
