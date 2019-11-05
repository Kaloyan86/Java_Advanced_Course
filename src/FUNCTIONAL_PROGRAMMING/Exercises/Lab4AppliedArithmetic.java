package FUNCTIONAL_PROGRAMMING.Exercises;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Lab4AppliedArithmetic {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

        Function<List<Integer>, List<Integer>> add = arr -> arr.stream().map(e -> ++e).collect(Collectors.toList());
        Function<List<Integer>, List<Integer>> multiply = arr -> arr.stream().map(e -> e *= 2).collect(Collectors.toList());
        Function<List<Integer>, List<Integer>> subtract = arr -> arr.stream().map(e -> --e).collect(Collectors.toList());
        Consumer<List<Integer>> printer = arr -> arr.forEach(e -> System.out.print(e + " "));

        String command = scanner.nextLine();
        while (!command.equals("end")) {

            switch (command) {
                case "add":
                    numbers = add.apply(numbers);
                    break;

                case "multiply":
                    numbers = multiply.apply(numbers);
                    break;

                case "subtract":
                    numbers = subtract.apply(numbers);
                    break;

                case "print":
                    printer.accept(numbers);
                    System.out.println();
                    break;
            }


            command = scanner.nextLine();
        }
    }
}
