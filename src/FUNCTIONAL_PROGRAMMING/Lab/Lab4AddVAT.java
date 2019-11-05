package FUNCTIONAL_PROGRAMMING.Lab;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.UnaryOperator;

public class Lab4AddVAT {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        UnaryOperator<Double> VAT = x -> x * 1.2;

        String[] prices = scanner.nextLine().split(", ");

        System.out.println("Prices with VAT:");

        Arrays.stream(prices)
                .map(Double::parseDouble)
                .map(VAT)
                .forEach(e -> System.out.println(String.format("%.2f", e)));
    }
}
