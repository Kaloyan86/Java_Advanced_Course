package FUNCTIONAL_PROGRAMMING.Exercises;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

public class Ex3CustomMinFunction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int minNum = Arrays.stream(numbers).min().getAsInt();
        System.out.println(minNum);

    }
}
